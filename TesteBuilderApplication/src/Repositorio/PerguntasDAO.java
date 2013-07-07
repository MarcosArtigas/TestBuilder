package Repositorio;

import Entidades.Nivel;
import Entidades.Pergunta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class PerguntasDAO {

    private Statement _statement;
    private Connection _conn;
    private int _generatedKey = -1;
    private PreparedStatement _stm;

    public PerguntasDAO() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        _conn = DbConnection.getConnection();
    }

    //Retorna o id da ultima pergunta inserida
    public boolean InserirPergunta(Pergunta pergunta) throws SQLException {

        String sql="INSERT INTO Perguntas(Pergunta, Tipo) VALUES(?,?)";   
        _stm = _conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        _stm.setString(1, pergunta.Pergunta);
        _stm.setInt(2, pergunta.Tipo);
        boolean executouAQuery = _stm.executeUpdate() > 0;


        ResultSet rs = _stm.executeQuery("SELECT LAST_INSERT_ID()");

        if (rs.next()) {
            _generatedKey = rs.getInt(1);
        }

        rs.close();
        _stm.close();
        return executouAQuery;

    }

    public int RetornarUltimoIndiceInserido() throws Exception {

        if (_generatedKey >= 0) {
            return _generatedKey;
        } else {
            throw new Exception();
        }
    }
    
    public boolean ExcluirPergunta(int idPergunta) throws SQLException
    {
        _stm = _conn.prepareStatement("DELETE FROM perguntas WHERE Id = ?");
        _stm.setInt(1, idPergunta);

        
        
        boolean retorno = _stm.executeUpdate() > 0;
        
        _stm.close();
        
        return retorno;
    }

    public boolean ExcluirPergunta(Pergunta pergunta) throws SQLException {

        _stm = _conn.prepareStatement("DELETE FROM Peguntas WHERE Pergunta = ? AND Tipo = ?");
        _stm.setString(1, pergunta.Pergunta);
        _stm.setInt(2, pergunta.Tipo);

        
        
         boolean retorno = _stm.executeUpdate() > 0;
        
        _stm.close();
        
        return retorno;
    }
    
    public boolean EditarPergunta(Pergunta pergunta) throws SQLException
    {
        _stm = _conn.prepareStatement("UPDATE Perguntas SET Pergunta = ?, Tipo = ? WHERE Id = ?");
        _stm.setString(1, pergunta.Pergunta);
        _stm.setInt(2, pergunta.Tipo);
        _stm.setInt(3, pergunta.Id);
        
        
        
         boolean editou = _stm.executeUpdate() > 0;
        
        _stm.close();
        
        return editou;
    }
    
    public ArrayList<Pergunta> RetornarPerguntas(int tipo) throws SQLException
    {
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        String sql = "SELECT * FROM Perguntas WHERE Tipo = ? ORDER BY RAND() LIMIT 20";
        
        _stm = _conn.prepareStatement(sql);
        _stm.setInt(1, tipo);
        
        ResultSet rs = _stm.executeQuery();
        
        while(rs.next())
        {
            Pergunta pergunta = new Pergunta();
            
            pergunta.Id = rs.getInt("Id");
                    
            pergunta.Pergunta = rs.getString("Pergunta");
            pergunta.Tipo = rs.getInt("Tipo");
            
            perguntas.add(pergunta);
        }
        
        return perguntas;
    }
        
    public ArrayList<Pergunta> RetornarPerguntas() throws SQLException
    {
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        String sql = "SELECT * FROM Perguntas";
        _stm = _conn.prepareStatement(sql);
        ResultSet rs = _stm.executeQuery();
        
        while(rs.next())
        {
            Pergunta pergunta = new Pergunta();
            
            pergunta.Id = rs.getInt("Id");
                    
            pergunta.Pergunta = rs.getString("Pergunta");
            pergunta.Tipo = rs.getInt("Tipo");
            
            perguntas.add(pergunta);
        }
        
        return perguntas;
        
    }

    public Pergunta RetornarPergunta(int idPergunta) throws SQLException {
        String sql = "SELECT * FROM Perguntas WHERE Id = ?";
        _stm = _conn.prepareStatement(sql);
        _stm.setInt(1, idPergunta);
        
        ResultSet rs = _stm.executeQuery();
        Pergunta pergunta = new Pergunta();
        while(rs.next())
        {
            
            
            pergunta.Id = rs.getInt("Id");
                    
            pergunta.Pergunta = rs.getString("Pergunta");
            pergunta.Tipo = rs.getInt("Tipo");
            
            
        }
        
        return pergunta;
    }
    
}
