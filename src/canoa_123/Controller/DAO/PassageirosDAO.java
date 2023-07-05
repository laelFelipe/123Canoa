/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller.DAO;

import canoa_123.Models.Passageiros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class PassageirosDAO {
    //  public static Integer idusuario;

    //  Connection conn;
    //  PreparedStatement pstm;
    public void cadastrarPassageiro(Passageiros passageiro) throws ExceptionDAO {
        String sql = "insert into passageiro (nome, cpf, telefone,senha) values (?,?,?,?)";
        PreparedStatement psta = null;
        Connection conn = null;
        try {
            conn = new ConnectionMVC().conectaBD();
            psta = conn.prepareStatement(sql);
            psta.setString(1, passageiro.getNome());
            psta.setString(2, passageiro.getCpf());
            psta.setInt(3, passageiro.getTelefone());
            psta.setString(4, passageiro.getSenha());
            psta.execute();
            //  JOptionPane.showMessageDialog(null, "Passageiro cadastrado com sucesso!!");
        } catch (SQLException e) {
            throw new ExceptionDAO("erro EM PASSAGEIRODAO " + e);
        } finally {
            try {
                if (psta != null) {
                    psta.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar psta " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar conn " + e);
            }
        }
    }

    // FUNCAO BUSCAR PASSAGEIRO
    public ArrayList<Passageiros> listarPassageiros(String nome) throws ExceptionDAO {

        String sql = "select *from passageiro where nome like '%" + nome + "%' order by nome";
        Connection conn = null;
        PreparedStatement pstm = null;
        ArrayList<Passageiros> passageiros = null;
        try {
            conn = new ConnectionMVC().conectaBD();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            if (rs != null) {
                passageiros = new ArrayList<>();
                while (rs.next()) {
                    Passageiros passageiro = new Passageiros();
                    passageiro.setId(rs.getInt("id"));
                    passageiro.setNome(rs.getString("nome"));
                    passageiro.setCpf(rs.getString("cpf"));
                    passageiro.setTelefone(rs.getInt("telefone"));
                    passageiros.add(passageiro);
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("erro EM BARCODAO " + e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar psta " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar conn " + e);
            }
        }

        return passageiros;
    }

    /// ALTERAR PASSAGEIRO
    public void alterarPassageiros(Passageiros passageiro) throws ExceptionDAO {
        String sql = "update passageiro set nome = ?, cpf = ?, telefone = ? where id = ?";
        PreparedStatement psta = null;
        Connection conn = null;
        try {
            conn = new ConnectionMVC().conectaBD();
            psta = conn.prepareStatement(sql);
            psta.setString(1, passageiro.getNome());
            psta.setString(2, passageiro.getCpf());
            psta.setInt(3, passageiro.getTelefone());
            psta.setInt(4, passageiro.getId());
            psta.execute();

        } catch (SQLException e) {
            throw new ExceptionDAO("erro EM PASSAGEIRODAO " + e);
        } finally {
            try {
                if (psta != null) {
                    psta.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar psta " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar conn " + e);
            }
        }
    }

    // AUTENTICAÇÃO DE PASSAGEIRO
    public ResultSet autenticacaoPassageiro(Passageiros passageiro) {
        Connection conn;
        conn = new ConnectionMVC().conectaBD();

        try {
            String sql = "Select *from passageiro where nome = ? and senha = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, passageiro.getNome());
            pstm.setString(2, passageiro.getSenha());
            ResultSet rs = pstm.executeQuery();
            //idusuario = passageiro.getId();
            //JOptionPane.showMessageDialog(null, idusuario);
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PASSAGEIRODAO" + erro);
            return null;
        }
    }
    
    
    
    
     public ArrayList<Passageiros> listarPassageirosCpf(String cpf) throws ExceptionDAO {

        String sql = "select *from passageiro where cpf like '%" + cpf + "%' order by cpf";
        Connection conn = null;
        PreparedStatement pstm = null;
        ArrayList<Passageiros> passageiros = null;
       // Passageiros passageiros = new Passageiros();
        try {
            conn = new ConnectionMVC().conectaBD();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
            if (rs != null) {
                passageiros = new ArrayList<>();
                while (rs.next()) {
                    Passageiros passageiro = new Passageiros();
                    passageiro.setId(rs.getInt("id"));
                    passageiro.setNome(rs.getString("nome"));
                    passageiro.setCpf(rs.getString("cpf"));
                    passageiro.setTelefone(rs.getInt("telefone"));
                    passageiros.add(passageiro);
                }
            }

        } catch (SQLException e) {
            throw new ExceptionDAO("erro EM BARCODAO " + e);
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar psta " + e);
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("erro ao fechar conn " + e);
            }
        }

        return passageiros;
    }
     
     
     
     
     
      // LISTAR PASSAGEIRO POR CPF PARA COMPRA DE PASSAGEM
    
   /* public ResultSet listarPassageirosCpf(Passageiros passageiro) {
        Connection conn;
        conn = new ConnectionMVC().conectaBD();

        try {
            String sql = "Select *from passageiro where cpf = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, passageiro.getNome());
            pstm.setString(2, passageiro.getSenha());
            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "PASSAGEIRODAO" + erro);
            return null;
        }
    
    }
    */
}
