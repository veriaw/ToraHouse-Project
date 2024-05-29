/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.auctioneer;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class ModelTableAuctioneer extends AbstractTableModel {

    List<ModelAuctioneer> daftarAuctioneer;
    String kolom[]={"ID", "Nama Pelelang", "Alamat Rumah", "Price"};
    
    public ModelTableAuctioneer(List<ModelAuctioneer> daftarAuctioneer) {
        this.daftarAuctioneer = daftarAuctioneer;
    }
    
    @Override
    public int getRowCount() {
        return daftarAuctioneer.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarAuctioneer.get(rowIndex).getId();
            case 1:
                return daftarAuctioneer.get(rowIndex).getNamaUser();
            case 2:
                return daftarAuctioneer.get(rowIndex).getAlamat();
            case 3:
                return daftarAuctioneer.get(rowIndex).getPrice();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
