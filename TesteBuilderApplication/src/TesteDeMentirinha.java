
import Entidades.Pergunta;
import Entidades.Resposta;
import Infra.TextFileManager;
import Repositorio.PerguntasDAO;
import Repositorio.RespostasDAO;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Murilo
 */
public class TesteDeMentirinha {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, URISyntaxException, IOException
    {
//        PerguntasDAO perguntasDao = new PerguntasDAO();
//        RespostasDAO respostasDao = new RespostasDAO();
//        
//        for (Pergunta p : perguntasDao.RetornarPerguntas())
//        {
//            System.out.println("Pergunta: " + p.Pergunta);
//            for(Resposta r : respostasDao.RetornarRepostas(p.Id))
//            {
//                System.out.println("----Alternativa: " + r.Resposta);
//            }
//            
//        }
        TextFileManager txt = new TextFileManager("prova");
        txt.AdicionarLinhasAoArquivo("hahahahhahahahahahuahsiudha");
        
        
        
        
    }
}
