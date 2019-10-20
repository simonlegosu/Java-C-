
package jeudupendu;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import javax.swing.*;
import java.text.*;
import java.util.*;

public class GestionJeu {
    //chaque bonne lettre donne 1 point, un mot completé en donne 3.
    //integrer mecanisme qui termine la partie si le bonhomme se fait pendre
    private int gamesPlayed = 0;
    
    
    public joueur NouveauJoueur(String name)
    {
        joueur j = new joueur();
        j.setNom(name);
        j.resetScore();
        return j;
    }
    

    public String startGame(String[] usedWords)
    {
        boolean fw = false;
        mots m = new mots();        
        String s = m.getRandomMot();
        for (int u = 0; u < usedWords.length; u++)
        {
            if (usedWords[u].contains(s))
            {
                fw = true;
            }
        }
        if (fw)
        {            
            s = startGame(usedWords);
        }
        return s; 
        
    }
    public Boolean checkLettre(char c, String mot)
    {
        char[] test = mot.toCharArray();
        for (int i = 0; i < test.length; i++)
        {
            if(c == test[i])
                return true;                
        }
        return false;
    }
    public void nextGame()
    {
        this.gamesPlayed += 1;
    }
    
    public int getGame()
    {
        int g = this.gamesPlayed;
        return g;
    }
    public Boolean endGame()
    {
        if(this.gamesPlayed == 10)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    
    
}
