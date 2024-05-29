/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.user.DAOUser;
import model.user.InterfaceDAOUser;
import model.user.ModelUser;
import view.Login;

/**
 *
 * @author Lenovo
 */
public class ControllerUser {
    Login loginPage;
    InterfaceDAOUser daoUser;
    ModelUser user = null;
    List<ModelUser> daftarUser;
    
    
    public ControllerUser(Login loginPage) {
        this.loginPage = loginPage;
        this.daoUser = new DAOUser();
    }
    
    public boolean autentikasi(String username, String password){
       
        user=daoUser.authentication(username, password);
        System.out.println(user.getPassword());
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }
}
