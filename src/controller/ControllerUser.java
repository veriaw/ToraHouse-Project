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
        if(!username.equals(user.getUsername()) || !password.equals(user.getPassword())){
            return false;
        }else if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            return true;
            }
        return false;
    }
}
