/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.rumah;

import controller.ControllerRumah;
import controller.ControllerUser;
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
public class DAORumah implements InterfaceDAORumah {
    

    @Override
    public void insert(ModelRumah rumah) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO sell_house (alamat, luas_tanah, luas_bangunan, kamar_tidur, kamar_mandi, garasi, start_price, status, seller_id) VALUES (?, ?, ?, ?, ?, ?, ?, 'ForSale', ?);";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, rumah.getAlamat());
            statement.setInt(2, rumah.getLuasTanah());
            statement.setInt(3, rumah.getLuasBangunan());
            statement.setInt(4, rumah.getKamarTidur());
            statement.setInt(5, rumah.getKamarMandi());
            statement.setInt(6, rumah.getGarasi());
            statement.setInt(7, rumah.getPrice());
            statement.setInt(8, ControllerUser.getCurrentUser().getId());
            
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
    public void update(ModelRumah rumah) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE sell_house SET alamat=?, luas_tanah=?, luas_bangunan=?, kamar_tidur=?, kamar_mandi=?, garasi=?, start_price=? WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, rumah.getAlamat());
            statement.setInt(2, rumah.getLuasTanah());
            statement.setInt(3, rumah.getLuasBangunan());
            statement.setInt(4, rumah.getKamarTidur());
            statement.setInt(5, rumah.getKamarMandi());
            statement.setInt(6, rumah.getGarasi());
            statement.setInt(7, rumah.getPrice());
            statement.setInt(8, rumah.getId());
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
            String query = "DELETE FROM sell_house WHERE id=?;";
            
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
    public List<ModelRumah> getAll() {
        List<ModelRumah> listRumah = null;
        try{
            listRumah = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM sell_house;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelRumah home = new ModelRumah();
  
                home.setId(resultSet.getInt("id"));
                home.setAlamat(resultSet.getString("alamat"));
                home.setLuasTanah(resultSet.getInt("luas_tanah"));
                home.setLuasBangunan(resultSet.getInt("luas_bangunan"));
                home.setKamarTidur(resultSet.getInt("kamar_tidur"));
                home.setKamarMandi(resultSet.getInt("kamar_mandi"));
                home.setGarasi(resultSet.getInt("garasi"));
                home.setPrice(resultSet.getInt("start_price"));
                home.setStatus(resultSet.getString("status"));
                
                listRumah.add(home);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listRumah;
    }

    @Override
    public List<ModelRumah> getShowSell(Integer id) {
        List<ModelRumah> listRumah = null;
        try{
            listRumah = new ArrayList<>();
            String query = "SELECT * FROM sell_house WHERE seller_id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ModelRumah home = new ModelRumah();
  
                home.setId(resultSet.getInt("id"));
                home.setAlamat(resultSet.getString("alamat"));
                home.setLuasTanah(resultSet.getInt("luas_tanah"));
                home.setLuasBangunan(resultSet.getInt("luas_bangunan"));
                home.setKamarTidur(resultSet.getInt("kamar_tidur"));
                home.setKamarMandi(resultSet.getInt("kamar_mandi"));
                home.setGarasi(resultSet.getInt("garasi"));
                home.setPrice(resultSet.getInt("start_price"));
                home.setStatus(resultSet.getString("status"));
                
                listRumah.add(home);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listRumah;
    }

    @Override
    public ModelRumah getCurrentHouse(Integer id) {
        ModelRumah home = new ModelRumah();
        try{
            
            String query = "SELECT * FROM sell_house WHERE id=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            resultSet.next();
            
            home.setId(resultSet.getInt("id"));
            home.setAlamat(resultSet.getString("alamat"));
            home.setLuasTanah(resultSet.getInt("luas_tanah"));
            home.setLuasBangunan(resultSet.getInt("luas_bangunan"));
            home.setKamarTidur(resultSet.getInt("kamar_tidur"));
            home.setKamarMandi(resultSet.getInt("kamar_mandi"));
            home.setGarasi(resultSet.getInt("garasi"));
            home.setPrice(resultSet.getInt("start_price"));
            home.setStatus(resultSet.getString("status"));
            
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return home;
    }
    
    
}
    
