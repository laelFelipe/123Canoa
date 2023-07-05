/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller;

import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Models.Passageiros;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class PassageirosController {
    //CADASTRAR PASSAGEIROS
    
      public boolean cadastrarPassageiros (String nome, String cpf, int telefone, String senha) throws ExceptionDAO{
        if (nome !=null && nome.length()>0 && cpf !=null && cpf.length()>0){
                Passageiros passageiro = new Passageiros(nome, cpf, telefone, senha);
                passageiro.cadastrarPassageiro(passageiro);
                return true;
       } else{
            JOptionPane.showMessageDialog(null, "ERRO EM PASSAGEIRO CONTROLLER");
           return false;
        }           
    
}
 
    
    
    // listar Passageiros
    public ArrayList<Passageiros> listarPassageiros(String nome) throws ExceptionDAO {
        return new Passageiros().listarPassageiros(nome);

    }
    
    // ALTERAR PASSAGEIROS
    public boolean alterarPassageiro (int passageiroId, String nome, String cpf,int telefone, String senha) throws ExceptionDAO{
        if (nome !=null && nome.length()>0 && cpf !=null && cpf.length()>0){
                 Passageiros passageiro = new Passageiros(nome, cpf, telefone, senha);
                 passageiro.setId(passageiroId);
                 passageiro.alterarPassageiro(passageiro);
                 return true;
       } else{
            JOptionPane.showMessageDialog(null, "ERRO EM PASSAGEIRO CONTROLLER");
           return false;
        }           
    
}
    
    
    //LISTAR PASSAGEIRO CPF COMPRA DE PASSAGEM
    
     public ArrayList<Passageiros> listarPassageirosCpf(String cpf) throws ExceptionDAO {
        return new Passageiros().listarPassageirosCpf(cpf);

    }
}
