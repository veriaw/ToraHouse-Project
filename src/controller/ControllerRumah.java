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
import model.user.ModelUser;
import view.*;
/**
 *
 * @author Lenovo
 */
public class ControllerRumah {
    Menu_Utama_Pembeli halamanTable;
    Menu_Utama_Penjual halamanTable2;
    InterfaceDAORumah daoRumah;
    List<ModelRumah> daftarRumah;
    
    public ControllerRumah(Menu_Utama_Pembeli halamanTable) {
        this.halamanTable = halamanTable;
        this.daoRumah = new DAORumah();
    }
    
    public ControllerRumah(Menu_Utama_Penjual halamanTable2) {
        this.halamanTable2 = halamanTable2;
        this.daoRumah = new DAORumah();
    }
    
    public void showAllHouse(){
        daftarRumah=daoRumah.getAll();
        ModelTableRumah table = new ModelTableRumah(daftarRumah);

        // Mengisi tabel yang berada pada halaman Table Mahasiswa
        halamanTable.getTableRumah().setModel(table);
    }
    
    public void showSellHouse(){
        daftarRumah=daoRumah.getShowSell(ControllerUser.getCurrentUser().getId());
        ModelTableRumah table = new ModelTableRumah(daftarRumah);
        halamanTable2.getTableRumah().setModel(table);
    }
}
