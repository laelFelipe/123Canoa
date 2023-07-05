/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller.DAO;

/**
 *
 * @author erico
 */

import canoa_123.Controller.DAO.ExceptionDAO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import canoa_123.Models.Barcos;
import java.util.ArrayList;
        
    
public class BarcoDAO {
    public void cadastrarBarco (Barcos barco) throws ExceptionDAO{
        String sql = "insert into barco (nome, capacidade) value (?,?)";
        PreparedStatement psta = null;
        Connection conn = null;
        try{
            conn = new  ConnectionMVC().getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1, barco.getNome());
            psta.setInt(2, barco.getCapacidade());
            psta.execute();
        }catch(SQLException e){
            throw new ExceptionDAO ("erro " + e);
        }finally{
            try{
              if (psta != null){psta.close();}   
              
            }catch (SQLException e){
                throw new ExceptionDAO ("erro ao fechar psta " + e);
        } try {
            if (conn != null){ conn.close();}
        } catch (SQLException e){
            throw new ExceptionDAO ("erro ao fechar conn " + e);
        }
        }
    }
    
    public void alterarBarco (Barcos barco) throws ExceptionDAO{
        String sql = "update barco set nome = ?, capacidade = ? where id = ?";
        PreparedStatement psta = null;
        Connection conn = null;
        try{
            conn = new  ConnectionMVC().getConnection();
            psta = conn.prepareStatement(sql);
            psta.setString(1, barco.getNome());
            psta.setInt(2, barco.getCapacidade());
            psta.setInt(3, barco.getId());
            psta.execute();
        }catch(SQLException e){
            throw new ExceptionDAO ("erro " + e);
        }finally{
            try{
              if (psta != null){psta.close();}   
              
            }catch (SQLException e){
                throw new ExceptionDAO ("erro ao fechar psta " + e);
        } try {
            if (conn != null){ conn.close();}
        } catch (SQLException e){
            throw new ExceptionDAO ("erro ao fechar conn " + e);
        }
        }
    }
    
    public ArrayList<Barcos> listarBarcos (String nome) throws ExceptionDAO{
        String sql = "select * from barco where nome like '%" + nome + "%' order by nome";
        
        PreparedStatement psta = null;
        Connection conn = null;
        ArrayList<Barcos> barcos = null;
        
        try{
            conn = new  ConnectionMVC().getConnection();
            psta = conn.prepareStatement(sql);
            ResultSet rs = psta.executeQuery(sql);
            
            if (rs != null){
                barcos = new ArrayList<Barcos>();
                while (rs.next()){
                Barcos barco = new Barcos();
                barco.setId(rs.getInt("id"));
                barco.setNome(rs.getString("nome"));
                barco.setCapacidade(rs.getInt("capacidade"));
                barcos.add(barco);
                }
            }
            

            }catch(SQLException e){
            throw new ExceptionDAO ("erro " + e);
            }finally{
                    try{
                            if (psta != null){psta.close();}   
              
            }catch (SQLException e){
                throw new ExceptionDAO ("erro ao fechar psta " + e);
        } try {
            if (conn != null){ conn.close();}
        } catch (SQLException e){
            throw new ExceptionDAO ("erro ao fechar conn " + e);
        }
        }
        
           return barcos;
    }
}
