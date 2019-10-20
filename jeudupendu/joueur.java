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
public class joueur {
    private int score = 0;
    private String nom;

    public String getNom()
    {
        return nom;
    }
    public void setNom(String newNom)
    {
        this.nom = newNom;
    }

    public int getScore() 
    {
        return score;
    }  
    public void setScore(int newScore) 
    {
        this.score += newScore;
    }
        public void resetScore() 
    {
        this.score = 0;
    }
    @Override
    public String toString()
    {
    String scoreS = String.valueOf(score);
    String info = (nom + "*" + scoreS);
    return info;
    }

    
}



