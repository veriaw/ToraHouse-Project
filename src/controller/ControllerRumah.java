/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
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
    Sell sell;
    Update up;
    Tawar offer;
    private static Integer house_id;
    Detail_Buy detail;
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
    
    public ControllerRumah(Detail_Buy detail) {
        this.detail = detail;
        this.daoRumah = new DAORumah();
    }
    
    public ControllerRumah(Sell sell) {
        this.sell = sell;
        this.daoRumah = new DAORumah();
    }
    
    public ControllerRumah(Update up) {
        this.up = up;
        this.daoRumah = new DAORumah();
    }
    
    public ControllerRumah(Tawar offer) {
        this.offer = offer;
        this.daoRumah = new DAORumah();
    }

    public static void setHouse_id(Integer house_id) {
        ControllerRumah.house_id = house_id;
    }

    public static Integer getHouse_id() {
        return house_id;
    }
    
    
    public void sellHouse(){
        if(sell.getInputAlamat().equals("")||sell.getLuasTanah().equals("")||sell.getLuasBangunan().equals("")||sell.getKamarMandi().equals("")||sell.getKamarTidur().equals("")||sell.getGarasi().equals("")||sell.getPrice().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi Form Terlebih Dahulu!");
        }
        ModelRumah home= new ModelRumah();
        home.setAlamat(sell.getInputAlamat());
        home.setLuasTanah(sell.getLuasTanah());
        home.setLuasBangunan(sell.getLuasBangunan());
        home.setKamarMandi(sell.getKamarMandi());
        home.setKamarTidur(sell.getKamarTidur());
        home.setGarasi(sell.getGarasi());
        home.setPrice(sell.getPrice());
        daoRumah.insert(home);
    }
    
    public void cancelSell(Integer baris){
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable2.getTableRumah().getValueAt(baris, 0);
        String nama = halamanTable2.getTableRumah().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus Rumah Dengan " + nama + "?",
                "Hapus Rumah",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoRumah.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil Membatalkan Penjualan.");
        }
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
    
    public void showCurrentHouse(){
        
        System.out.println(house_id);
        ModelRumah rumah = new ModelRumah();
        rumah=daoRumah.getCurrentHouse(house_id);
        detail.setAlamat(rumah.getAlamat());
        detail.setLuasTanah(rumah.getLuasTanah());
        detail.setLuasBangunan(rumah.getLuasBangunan());
        detail.setKamarMandi(rumah.getKamarMandi());
        detail.setKamarTidur(rumah.getKamarTidur());
        detail.setGarasi(rumah.getGarasi());
        detail.setPrice(rumah.getPrice());
        detail.setStatus(rumah.getStatus());
    }
    
    public void showOfferedHouse(){
        
        System.out.println(house_id);
        ModelRumah rumah = new ModelRumah();
        rumah=daoRumah.getCurrentHouse(house_id);
        offer.setAlamat(rumah.getAlamat());
        offer.setLuasTanah(rumah.getLuasTanah());
        offer.setLuasBangunan(rumah.getLuasBangunan());
        offer.setKamarMandi(rumah.getKamarMandi());
        offer.setKamarTidur(rumah.getKamarTidur());
        offer.setGarasi(rumah.getGarasi());
        offer.setPrice(rumah.getPrice());
        offer.setStatus(rumah.getStatus());
    }
    
    public void updateHouse(){
        if(up.getInputAlamat().equals("")||up.getLuasTanah().equals("")||up.getLuasBangunan().equals("")||up.getKamarMandi().equals("")||up.getKamarTidur().equals("")||up.getGarasi().equals("")||up.getPrice().equals("")){
            JOptionPane.showMessageDialog(null, "Lengkapi Form Terlebih Dahulu!");
        }
        ModelRumah home= new ModelRumah();
        home.setAlamat(up.getInputAlamat());
        home.setLuasTanah(up.getLuasTanah());
        home.setLuasBangunan(up.getLuasBangunan());
        home.setKamarMandi(up.getKamarMandi());
        home.setKamarTidur(up.getKamarTidur());
        home.setGarasi(up.getGarasi());
        home.setPrice(up.getPrice());
        home.setId(house_id);
        
        daoRumah.update(home);
    }
    
    public void filterByPrice(){
        Integer min=halamanTable.getMinPrice();
        Integer max=halamanTable.getMaxPrice();
        daftarRumah=daoRumah.filterHouse(max, min);
        ModelTableRumah table = new ModelTableRumah(daftarRumah);
        halamanTable.getTableRumah().setModel(table);
    }
    
    public void updateStatus(){
        daoRumah.updateStatus(house_id);
    }
}
