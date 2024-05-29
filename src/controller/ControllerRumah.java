/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.rumah.DAORumah;
import model.rumah.InterfaceDAORumah;
import model.rumah.ModelRumah;
import model.rumah.ModelTableRumah;
import view.*;
/**
 *
 * @author Lenovo
 */
public class ControllerRumah {
    Menu_Utama_Pembeli halamanTable;


    InterfaceDAORumah daoRumah;

    List<ModelRumah> daftarRumah;
    
    public ControllerRumah(Menu_Utama_Pembeli halamanTable) {
        this.halamanTable = halamanTable;
        this.daoRumah = new DAORumah();
    }
    
    public void showAllHouse(){
        daftarRumah=daoRumah.getAll();
        ModelTableRumah table = new ModelTableRumah(daftarRumah);

        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableRumah().setModel(table);
    }
}
