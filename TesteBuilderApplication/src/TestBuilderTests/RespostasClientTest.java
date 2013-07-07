package TestBuilderTests;

import Repositorio.RespostasDAO;
import Entidades.Resposta;
import java.sql.SQLException;
import junit.framework.*;

public class RespostasClientTest extends TestCase {
    public void verificar_se_cadastra_no_banco() throws SQLException
    {
        RespostasDAO respostaClient = new RespostasDAO();
        Resposta resposta = new Resposta("Teste de inserção com junit", true);
        
        boolean inseriuComSucesso = respostaClient.InserirResposta(resposta, 2);
        
        Assert.assertTrue(inseriuComSucesso);
    }
}
