/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.user;

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
public class DAOUser implements InterfaceDAOUser {

    
    
    @Override
    public void insert(ModelUser user) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "INSERT INTO profile (nama, username, password, kelamin, no_hp) VALUES (?, ?, ?, ?, ?);";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, user.getNama());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getKelamin());
            statement.setString(5, user.getNoHp());
            
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
    public void update(ModelUser user) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE profile SET nama=?, username=?, password=?, kelamin=?, no_hp=? WHERE id=?;";
            
            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
            */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, user.getNama());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getKelamin());
            statement.setString(5, user.getNoHp());
            statement.setInt(6, user.getId());
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
    public List<ModelUser> getAll() {
        List<ModelUser> listUser = null;
        try{
            listUser = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            String query = "SELECT * FROM profile;";
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
                ModelUser user = new ModelUser();
  
                user.setId(resultSet.getInt("id"));
                user.setNama(resultSet.getString("nama"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setKelamin(resultSet.getString("kelamin"));
                user.setNoHp(resultSet.getString("no_hp"));
                
                listUser.add(user);
            }
            
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listUser;
    }

    @Override
    public ModelUser authentication(String username, String password) {
        ModelUser user = new ModelUser();
        try{
            
            String query = "SELECT * FROM profile WHERE username=? AND password=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, username);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            
            user.setId(resultSet.getInt("id"));
            user.setNama(resultSet.getString("nama"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setKelamin(resultSet.getString("kelamin"));
            user.setNoHp(resultSet.getString("no_hp"));
            
            statement.close();
        }catch(SQLException e){
            System.out.println("Error: " + e.getLocalizedMessage());
        }
    return user;
    }
}
    
