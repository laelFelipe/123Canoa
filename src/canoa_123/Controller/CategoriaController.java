/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller;
import canoa_123.Controller.DAO.ExceptionDAO;
import canoa_123.Models.Barcos;
import canoa_123.Models.Categorias;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */

public class CategoriaController {
    
    public boolean cadastrarCategoria(String nome) throws ExceptionDAO {
        if (nome != null && nome.length() > 0) {
            Categorias categorias = new Categorias(nome);
            categorias.cadastrarCategorias(categorias);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO EM CATEGORIA CONTROLLER");
            return false;
        }

    }

    public ArrayList<Categorias> listarCategoria(String nome) throws ExceptionDAO {
        return new Categorias().listarCategoria(nome);
    }

    //
    public boolean alterarCategoria(int categoriaId, String nome) throws ExceptionDAO {
        if (nome != null && nome.length() > 0) {
            Categorias categoria = new Categorias(nome);
            categoria.setId(categoriaId);
            categoria.alterarCategoria(categoria);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "ERRO NO CATEGORIA  CONTROLLER");
            return false;
        }

    }
}
