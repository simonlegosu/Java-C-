/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudupendu;

/**
 *
 * @author 633-086163
 */
public class mots 
{    
    private String motsliste[] = { "chandelle", "automobile", "chaise", "bicyclette", "pigeon", "pinceau", "policier", "restaurant", "village", "novembre"};

    public String getRandomMot()
    {
        String s = "";        
        int wordpick = (int)(Math.random()*10);
        s = motsliste[wordpick];
        return s;
    }
    

    

            
    
    
}

//creer une méthode qui prend un mot comme argument et qui sépare les lettres

//creer une méthode qui analyse la lettre saisie et qui établie si elle se retrouve dans le mot
