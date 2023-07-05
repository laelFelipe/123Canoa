/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package canoa_123.Controller.DAO;
import canoa_123.Models.Categorias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author °°Felipe°°Lael°°
 */
public class CategoriaDAO {
    
    public void CadastrarCategoria(Categorias cat) throws ExceptionDAO{
        
        String sql = "insert into categoria (nome) values (?)";
        PreparedStatement psta = null;
        Connection conn = null;
        try{
            conn = new  ConnectionMVC().conectaBD();
            psta = conn.prepareStatement(sql);
            psta.setString(1, cat.getNome());
           psta.execute();
        }catch(SQLException e){
            throw new ExceptionDAO ("erro EM CATEGORIADAO " + e);
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
    
    
    // FUNCAO LISTAR CATEGORIA
    
    public ArrayList<Categorias> listarCategoria (String nome) throws ExceptionDAO{
          
            String sql = "select *from categoria where nome like '%" + nome + "%' order by nome";
            Connection conn = null;
            PreparedStatement pstm = null;
            ArrayList<Categorias> categorias = null;
             try{
            conn = new  ConnectionMVC().conectaBD();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery(sql);
                if(rs != null){
                    categorias = new ArrayList <>();
                    while(rs.next()){
                        Categorias categoria = new Categorias();
                        categoria.setId(rs.getInt("id"));
                        categoria.setNome(rs.getString("nome"));
                        categorias.add(categoria);
                    }
                }
                
             }catch(SQLException e){
            throw new ExceptionDAO ("erro EM CATEGORIADAO " + e);
        }finally{
            try{
              if (pstm != null){pstm.close();}   
              
            }catch (SQLException e){
                throw new ExceptionDAO ("erro ao fechar psta " + e);
        } try {
            if (conn != null){ conn.close();}
        } catch (SQLException e){
            throw new ExceptionDAO ("erro ao fechar conn " + e);
        }
        }
            
            return categorias;
      
        }
    
    
    
    
    // ALTERAR CATEGORIA
     
     public void alterarCategoria (Categorias categoria) throws ExceptionDAO{
        String sql = "update categoria set nome = ? where id = ?";
        PreparedStatement psta = null;
        Connection conn = null;
        try{
            conn = new  ConnectionMVC().conectaBD();
            psta = conn.prepareStatement(sql);
            psta.setString(1, categoria.getNome());
            psta.setInt(2, categoria.getId());
            psta.execute();
        }catch(SQLException e){
            throw new ExceptionDAO ("erro EM CATEGORIADAO " + e);
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
}
