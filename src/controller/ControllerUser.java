/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import model.user.DAOUser;
import model.user.InterfaceDAOUser;
import model.user.ModelUser;
import view.*;

/**
 *
 * @author Lenovo
 */
public class ControllerUser {
    Login loginPage;
    Register register;
    Menu_Utama_Penjual sell;
    private static ModelUser currentUser;
    InterfaceDAOUser daoUser;
    List<ModelUser> daftarUser;
    
    
    public ControllerUser(Login loginPage) {
        this.loginPage = loginPage;
        this.daoUser = new DAOUser();
    }
    
    public ControllerUser(Register register){
        this.register = register;
        this.daoUser = new DAOUser();
    }
    
     public ControllerUser(Menu_Utama_Penjual sell){
        this.sell = sell;
        this.daoUser = new DAOUser();
    }
     

    public static ModelUser getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(ModelUser currentUser) {
        ControllerUser.currentUser = currentUser;
    }
     
     
    public void register (){
        ModelUser user= new ModelUser();
        user.setNama(register.getInputNama());
        user.setKelamin(register.getKelamin());
        user.setUsername(register.getUsername());
        user.setPassword(register.getPassword());
        user.setNoHp(register.getNoHp());
        
        daoUser.insert(user);
    }
    
    public boolean autentikasi(String username, String password){
        ModelUser user=null;
        user=daoUser.authentication(username, password);
        currentUser=user;
        if(!username.equals(user.getUsername()) || !password.equals(user.getPassword())){
            return false;
        }else if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            return true;
            }
        return false;
    }
}
