/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller.DAO;

import canoa_123.Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class UsuarioDAO {
    public ResultSet autenticacaoUsuario(Usuario usu) {
         Connection conn;
        conn = new ConnectionMVC().conectaBD();

        try {
            String sql = "Select *from usuario where nome_usuario = ? and senha_usuario = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, usu.getNome_usuario());
            pstm.setString(2, usu.getSenha_usuario());
            ResultSet rs = pstm.executeQuery();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
            return null;
        }
    }
}
