/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.auctioneer;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface InterfaceDAOAuctioneer {
    public void insert(ModelAuctioneer auctioneer);
    public void update(ModelAuctioneer auctioneer);
    public void delete(int id);
    public List<ModelAuctioneer> getAll();
}
