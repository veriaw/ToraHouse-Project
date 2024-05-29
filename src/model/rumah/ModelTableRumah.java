/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.rumah;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTableRumah extends AbstractTableModel{
    List<ModelRumah> daftarRumah;
    
    String kolom[] = {"ID", "Alamat", "Luas Tanah", "Luas Bangunan", "Kamar Tidur", "Kamar Mandi", "Garasi", "Start Price", "Status"};
    
    public ModelTableRumah(List<ModelRumah> daftarRumah) {
        this.daftarRumah = daftarRumah;
    }
    
    @Override
    public int getRowCount() {
        return daftarRumah.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarRumah.get(rowIndex).getId();
            case 1:
                return daftarRumah.get(rowIndex).getAlamat();
            case 2:
                return daftarRumah.get(rowIndex).getLuasTanah();
            case 3:
                return daftarRumah.get(rowIndex).getLuasBangunan();
            case 4:
                return daftarRumah.get(rowIndex).getKamarTidur();
            case 5:
                return daftarRumah.get(rowIndex).getKamarMandi();
            case 6:
                return daftarRumah.get(rowIndex).getGarasi();
            case 7:
                return daftarRumah.get(rowIndex).getPrice();
            case 8:
                return daftarRumah.get(rowIndex).getStatus();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
    
    
}
