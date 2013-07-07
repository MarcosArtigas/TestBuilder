/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Murilo
 */
public class Pergunta {
    public int Id;
    public String Pergunta;
    public int Tipo;
    
    
    public String RetornarTipoString()
    {
        switch(Tipo)
        {
            case 0: 
                return "Fácil";
            case 1:
                return "Médio";
            default:
                return "Difícil";
                
        }
    }
}
