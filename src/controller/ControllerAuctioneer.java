/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.auctioneer.DAOAuctioneer;
import model.auctioneer.ModelAuctioneer;
import model.auctioneer.ModelTableBargain;
import model.auctioneer.ModelTableOffer;
import model.rumah.DAORumah;
import model.rumah.ModelRumah;
import model.rumah.ModelTableRumah;
import view.*;
import view.Tawar;

/**
 *
 * @author Lenovo
 */
public class ControllerAuctioneer {
    Tawar auction;
    Menu_Utama_Pembeli tableBargain;
    DAOAuctioneer daoAuctioneer;
    Detail_Buy tableOffer;
    History history;
    List<ModelAuctioneer> daftarAuctioneer;
    public ControllerAuctioneer(Tawar auction){
        this.auction=auction;
        this.daoAuctioneer=new DAOAuctioneer();
    }
    
    public ControllerAuctioneer(Menu_Utama_Pembeli tableBargain){
        this.tableBargain=tableBargain;
        this.daoAuctioneer=new DAOAuctioneer();
    }
    
    public ControllerAuctioneer(Detail_Buy tableOffer){
        this.tableOffer=tableOffer;
        this.daoAuctioneer=new DAOAuctioneer();
    }
    
    public ControllerAuctioneer(History history){
        this.history=history;
        this.daoAuctioneer=new DAOAuctioneer();
    }
    
    public void bargain(){
        if(auction.getBargain().equals("")){
            JOptionPane.showMessageDialog(null, "Masukan Nominal Penawaran!");
        }
        ModelRumah house = new ModelRumah();
        DAORumah daoRumah = new DAORumah();
        house=daoRumah.getCurrentHouse(ControllerRumah.getHouse_id());
        ModelAuctioneer offer = new ModelAuctioneer();
        offer.setHouseId(ControllerRumah.getHouse_id());
        offer.setProfileId(ControllerUser.getCurrentUser().getId());
        offer.setPrice(auction.getBargain());
        offer.setOwnerId(house.getSellerId());
        daoAuctioneer.insert(offer);
    }
    
    public void showBargain(){
        daftarAuctioneer=daoAuctioneer.showBargain(ControllerUser.getCurrentUser().getId());
        ModelTableBargain table = new ModelTableBargain(daftarAuctioneer);
        tableBargain.getTableRumah().setModel(table);
    }
    
    public void showOffer(){
        daftarAuctioneer=daoAuctioneer.showOffer(ControllerRumah.getHouse_id());
        ModelTableOffer table = new ModelTableOffer(daftarAuctioneer);
        tableOffer.getTableOffer().setModel(table);
    }
    
    public void deleteBargain(Integer baris){
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) tableBargain.getTableRumah().getValueAt(baris, 0);
        String nama = tableBargain.getTableRumah().getValueAt(baris, 3).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus Penawaran Rumah " + nama + "?",
                "Hapus Penawaran",
                JOptionPane.YES_NO_OPTION
        );

        // Jika user memilih opsi "yes", maka hapus data.
        if (input == 0) {
            /* 
              Memanggil method delete() untuk menghaous data dari DB
              berdasarkan id yang dipilih.
            */
            daoAuctioneer.delete(id);
            
            // Menampilkan pop-up jika berhasil menghapus.
            JOptionPane.showMessageDialog(null, "Berhasil Membatalkan Penawaran.");
        }
    }
    
    public void takeOffer(Integer baris){
        Integer id = (int) tableOffer.getTableOffer().getValueAt(baris, 0);
        daoAuctioneer.takeOffer(id);
    }
    
    public void showHistory(){
        daftarAuctioneer=daoAuctioneer.showHistory(ControllerUser.getCurrentUser().getId());
        ModelTableBargain table = new ModelTableBargain(daftarAuctioneer);
        history.getTableHistory().setModel(table);
    }
}
