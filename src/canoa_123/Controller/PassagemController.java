/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller;

import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Models.Barcos;
import canoa_123.Models.Passageiros;
import canoa_123.Models.Passagens;
import canoa_123.Models.Rotas;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class PassagemController {
    public boolean cadastrarPassagem (float valor, Rotas rota, Passageiros passageiro ) throws ExceptionDAO{
        if ((rota !=null) && (passageiro != null) && (valor !=0 && valor > 0)){
                 Passagens passagem = new Passagens(rota, passageiro);
                 passagem.cadastrarPassagem(passagem);
                 return true;
       } else{
            JOptionPane.showMessageDialog(null, "ERRO NO BARCO CONTROLLER");
           return false;
        }           
    
}
}
