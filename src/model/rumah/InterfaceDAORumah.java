/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.rumah;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface InterfaceDAORumah {
    public void insert(ModelRumah rumah);
    public void update(ModelRumah rumah);
    public void delete(int id);
    public List<ModelRumah> getAll();
}
