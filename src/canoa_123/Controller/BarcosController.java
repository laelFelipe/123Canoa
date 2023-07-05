/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller;

import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Controller.DAO.BarcoDAO;
import canoa_123.Models.Barcos;
import java.util.ArrayList;

/**
 *
 * @author erico
 */
public class BarcosController {
    
    public boolean cadastrarBarco (String nome, int capacidade) throws ExceptionDAO{
        if (nome !=null && nome.length()>0 && capacidade != 0 && capacidade>0){
                 Barcos barco = new Barcos(nome, capacidade);
                 barco.cadastrarBarco(barco);
                 return true;
        } else{
           return false;
        }           
    
}
        public boolean alterarBarco (int barcoId, String nome, int capacidade) throws ExceptionDAO{
        if (nome !=null && nome.length()>0 && capacidade != 0 && capacidade>0){
                 Barcos barco = new Barcos(nome, capacidade);
                 barco.setId(barcoId);
                 barco.alterarBarco(barco);
                 return true;
        } else{
           return false;
        }           
    
}
    public ArrayList<Barcos> listarBarcos (String nome) throws ExceptionDAO{
        return new Barcos().listarBarcos(nome);
    }
    
}
