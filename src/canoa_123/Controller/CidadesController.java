/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller;

import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Models.Cidades;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class CidadesController {
     // cadastrar cidade
    public boolean cadastrarCidade(String estado, String localidade) throws ExceptionDAO {
        if (estado != null && estado.length() > 0 && localidade != null && localidade.length() > 0) {
            Cidades cidade = new Cidades(localidade, estado);
            cidade.CadastrarCidades(cidade);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO EM CIDADE CONTROLLER");
            return false;
        }

    }

    // listar cidade
    public ArrayList<Cidades> listarCidades(String nome) throws ExceptionDAO {
        return new Cidades().listarCidades(nome);
    }

    // ALTERAR CIDADE
    public boolean alterarCidade(int cidadeId, String estado, String localidade) throws ExceptionDAO {
        if (estado != null && estado.length() > 0 && localidade != null && localidade.length() > 0) {
            Cidades cidade = new Cidades(localidade, estado);
            cidade.setId(cidadeId);
            cidade.alterarCidade(cidade);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO NO BARCO CONTROLLER");
            return false;
        }

    }
}
