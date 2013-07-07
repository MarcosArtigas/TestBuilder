/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Murilo
 */
public class Resposta {
    public int Id;
    public String Resposta;
    public boolean EhCorreta;
    
    public Resposta()
    {}
    public Resposta(String resposta, boolean ehCorreta)
    {
        this.Resposta = resposta;
        this.EhCorreta = ehCorreta;
    }
    
    public Resposta(int idResposta, String resposta, boolean ehCorreta)
    {
        this.Id = idResposta;
        this.Resposta = resposta;
        this.EhCorreta = ehCorreta;
    }
    
}
