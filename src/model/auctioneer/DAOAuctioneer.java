/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.auctioneer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Connector;

/**
 *
 * @author Lenovo
 */
public class DAOAuctioneer implements InterfaceDAOAuctioneer{
    
    @Override
    public void insert(ModelAuctioneer auctioneer) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO auctioneer (profile_id, house_id, price, owner_id, status) VALUES (?, ?, ?, ?, 'Belum Diterima');";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, auctioneer.getProfileId());
            statement.setInt(2, auctioneer.getHouseId());
            statement.setInt(3, auctioneer.getPrice());
            statement.setInt(4, auctioneer.getOwnerId());
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void update(ModelAuctioneer auctioneer) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE auctioneer SET profile_id=?, house_id=?, price=? WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, auctioneer.getProfileId());
            statement.setInt(2, auctioneer.getHouseId());
            statement.setInt(3, auctioneer.getPrice());
            statement.setInt(4, auctioneer.getId());
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "DELETE FROM auctioneer WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public List<ModelAuctioneer> getAll() {
        List<ModelAuctioneer> listAuctioneer = null;
        try{
            listAuctioneer = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM auctioneer;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelAuctioneer auctioneer = new ModelAuctioneer();
  
                auctioneer.setId(resultSet.getInt("id"));
                auctioneer.setProfileId(resultSet.getInt("profile_id"));
                auctioneer.setHouseId(resultSet.getInt("house_id"));
                auctioneer.setPrice(resultSet.getInt("price"));
                
                listAuctioneer.add(auctioneer);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listAuctioneer;
    }

    @Override
    public List<ModelAuctioneer> showBargain(Integer id) {
        List<ModelAuctioneer> listAuctioneer = null;
        try{
            listAuctioneer = new ArrayList<>();
            String query = "SELECT auctioneer.id, profile.nama, sell_house.alamat, profile.no_hp, sell_house.start_price, auctioneer.price, auctioneer.status FROM ((auctioneer INNER JOIN sell_house ON sell_house.id=auctioneer.house_id) INNER JOIN profile ON profile.id=auctioneer.owner_id) WHERE auctioneer.profile_id=? AND sell_house.status='ForSale';";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ModelAuctioneer auctioneer = new ModelAuctioneer();
  
                auctioneer.setId(resultSet.getInt("id"));
                auctioneer.setAlamat(resultSet.getString("sell_house.alamat"));
                auctioneer.setNamaPemilik(resultSet.getString("profile.nama"));
                auctioneer.setNoHp(resultSet.getString("profile.no_hp"));
                auctioneer.setStartPrice(resultSet.getInt("sell_house.start_price"));
                auctioneer.setPrice(resultSet.getInt("auctioneer.price"));
                auctioneer.setStatus(resultSet.getString("auctioneer.status"));
                
                listAuctioneer.add(auctioneer);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listAuctioneer;
    }

    @Override
    public List<ModelAuctioneer> showOffer(Integer id) {
        List<ModelAuctioneer> listAuctioneer = null;
        try{
            listAuctioneer = new ArrayList<>();
            
            String query = "SELECT auctioneer.id, sell_house.alamat, profile.nama, profile.no_hp, sell_house.start_price, auctioneer.price, auctioneer.status FROM ((auctioneer INNER JOIN sell_house ON sell_house.id=auctioneer.house_id) INNER JOIN profile ON profile.id=auctioneer.profile_id) WHERE auctioneer.house_id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ModelAuctioneer auctioneer = new ModelAuctioneer();
  
                auctioneer.setId(resultSet.getInt("id"));
                auctioneer.setAlamat(resultSet.getString("sell_house.alamat"));
                auctioneer.setNamaUser(resultSet.getString("profile.nama"));
                auctioneer.setNoHp(resultSet.getString("profile.no_hp"));
                auctioneer.setStartPrice(resultSet.getInt("sell_house.start_price"));
                auctioneer.setPrice(resultSet.getInt("auctioneer.price"));
                auctioneer.setStatus(resultSet.getString("auctioneer.status"));
                
                listAuctioneer.add(auctioneer);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listAuctioneer;
    }
    
    @Override
    public void takeOffer(Integer id) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE auctioneer SET status='Diterima' WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            // Menjalankan query untuk menghapus data mahasiswa yang dipilih
            statement.executeUpdate();
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    @Override
    public List<ModelAuctioneer> showHistory(Integer id) {
        List<ModelAuctioneer> listAuctioneer = null;
        try{
            listAuctioneer = new ArrayList<>();
            
            String query = "SELECT auctioneer.id, profile.nama, sell_house.alamat, profile.no_hp, sell_house.start_price, auctioneer.price, auctioneer.status FROM ((auctioneer INNER JOIN sell_house ON sell_house.id=auctioneer.house_id) INNER JOIN profile ON profile.id=auctioneer.owner_id) WHERE auctioneer.profile_id=? AND auctioneer.status='Diterima';";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ModelAuctioneer auctioneer = new ModelAuctioneer();
  
                auctioneer.setId(resultSet.getInt("id"));
                auctioneer.setAlamat(resultSet.getString("sell_house.alamat"));
                auctioneer.setNamaPemilik(resultSet.getString("profile.nama"));
                auctioneer.setNoHp(resultSet.getString("profile.no_hp"));
                auctioneer.setStartPrice(resultSet.getInt("sell_house.start_price"));
                auctioneer.setPrice(resultSet.getInt("auctioneer.price"));
                auctioneer.setStatus(resultSet.getString("auctioneer.status"));
                
                listAuctioneer.add(auctioneer);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listAuctioneer;
    }
    
    
}


