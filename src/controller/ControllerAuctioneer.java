/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.auctioneer.DAOAuctioneer;
import model.auctioneer.ModelAuctioneer;
import view.Tawar;

/**
 *
 * @author Lenovo
 */
public class ControllerAuctioneer {
    Tawar auction;
    DAOAuctioneer daoAuctioneer;
    
    public ControllerAuctioneer(Tawar auction){
        this.auction=auction;
        this.daoAuctioneer=new DAOAuctioneer();
    }
    
    public void bargain(){
        ModelAuctioneer offer = new ModelAuctioneer();
        offer.setHouseId(ControllerRumah.getHouse_id());
        offer.setProfileId(ControllerUser.getCurrentUser().getId());
        offer.setPrice(auction.getBargain());
        daoAuctioneer.insert(offer);
    }
}
