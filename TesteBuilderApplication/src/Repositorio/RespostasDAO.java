/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Entidades.Resposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Murilo
 */

public class RespostasDAO {
   
    private Statement _statement;
    private Connection _conn;
    
    public RespostasDAO()
    {
        _conn = DbConnection.getConnection();
    }
    
    public boolean InserirResposta(Resposta resposta, int idPergunta) throws SQLException
    {
        PreparedStatement stm = _conn.prepareStatement("INSERT INTO Respostas(Resposta, EhCorreta, IdPergunta) VALUES(?, ?, ?)");
        stm.setString(1, resposta.Resposta);
        stm.setBoolean(2, resposta.EhCorreta);
        stm.setInt(3, idPergunta);
        
        boolean inseriu = stm.executeUpdate() > 0;
        
        stm.close();
        return inseriu;
    }
    
    public boolean EditarResposta(Resposta resposta, int idPergunta) throws SQLException
    {
        String sql = "UPDATE Respostas SET Resposta = ?, "
                + "EhCorreta = ?, "
                + "IdPergunta = ? WHERE Id = ?";
        PreparedStatement stm = _conn.prepareStatement(sql);
        
        stm.setString(1, resposta.Resposta);
        stm.setBoolean(2, resposta.EhCorreta);
        stm.setInt(3, idPergunta);
        stm.setInt(4, resposta.Id);
        
        boolean editou = stm.executeUpdate() > 0;
        
        stm.close();
        return editou;
        
    }
    
    public ArrayList<Resposta> RetornarRepostas(int idPergunta) throws SQLException
    {
        ArrayList<Resposta> respostas = new ArrayList<>();
        
        PreparedStatement stm = _conn.prepareStatement("SELECT Respostas.* "
                + "FROM Respostas INNER JOIN Perguntas "
                + "ON Respostas.IdPergunta = Perguntas.Id "
                + "WHERE Perguntas.Id = ?");
        stm.setInt(1, idPergunta);
        
        ResultSet rs = stm.executeQuery();
        while(rs.next())
        {
            respostas.add(new Resposta(
                    rs.getInt("Id"),
                    rs.getString("Resposta"), 
                    rs.getBoolean("EhCorreta")));
        }
        stm.close();
        rs.close();
        return respostas;
        
    }
}
