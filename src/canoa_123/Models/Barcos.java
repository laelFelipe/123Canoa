/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Models;

import canoa_123.Controller.DAO.BarcoDAO;
import canoa_123.Controller.DAO.ExceptionDAO;
import java.util.ArrayList;

/**
 *
 * @author erico
 */
public class Barcos {
    private int id;
    private String nome;
    private int capacidade;
    
    public Barcos(){
    
    }
            
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public Barcos( String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
    
    public void cadastrarBarco(Barcos barco) throws ExceptionDAO{
        new BarcoDAO().cadastrarBarco(barco);
    }
    
        public void alterarBarco(Barcos barco) throws ExceptionDAO{
        new BarcoDAO().alterarBarco(barco);
    }
    
    public ArrayList<Barcos> listarBarcos (String nome) throws ExceptionDAO{
        return new BarcoDAO().listarBarcos(nome);
    }
  
    
    
}
