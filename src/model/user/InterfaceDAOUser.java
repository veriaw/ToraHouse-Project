/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.user;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface InterfaceDAOUser {
    public void insert(ModelUser user);
    public void update(ModelUser user);
    public void delete(int id);
    public List<ModelUser> getAll();
    public ModelUser authentication(String username, String password);
    public ModelUser showProfile(Integer id);
}
