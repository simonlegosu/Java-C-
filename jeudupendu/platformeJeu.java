/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jeudupendu;
import java.awt.*;
import java.awt.event.*;
import java.awt.Component.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.text.*;
import java.util.*;

/**
 *
 * @author 633-086163
 */
public class platformeJeu extends javax.swing.JFrame {
    public GestionJeu ges = null;
    public joueur enCours = null;    
    public String NomJoueurActif = "";
    public String motActif = "";
    public String result = "";
    public int tentative = 0;
    ArrayList<String> usedMot = new ArrayList<String>();
    ArrayList<Character> usedChar = new ArrayList<Character>();
    public Graphics g;
  
    
    /**
     * Creates new form platformeJeu
     */
    public platformeJeu(GestionJeu ges, String uname)
    {
        super("Le jeu du Pendu - " + uname);
        
        initComponents();        
        this.ges = ges;        
        enCours = ges.NouveauJoueur(uname);
        NomJoueurActif = enCours.getNom();
        
               
    }
    public platformeJeu() {
        super("Le jeu du Pendu");
        initComponents();
    }
 

   
    
    
    public String setmessageJeu(int etat)
    {
        //0 = start 1 == pendant 2 = gagnante 3 = perdante
        String s = "erreur";
            switch (etat) {
        case 0:
            s = "Cliquez sur le bouton 'Générer' pour commencer.";
            break;
        case 1:
            s = "Il reste " + String.valueOf(6 - this.tentative) + " tentatives.";
            break;
        case 2:
            s = "Tu as trouve le mot avec seulement " + String.valueOf(this.tentative) + "erreurs! Encore?";
            break;
        case 3:
            s = "Partie terminé. Le mot recherché était '" + this.motActif + "'.";
            break;  
        case 4:
            s = "Essaie de deviner le mot en cliquant sur la lettre de ton choix.";
            break; 
        default:
            break;
    }
        
        return s;
    }
    
    public void enableButt()
    {
        qButt.setEnabled(true);
        wButt.setEnabled(true);
        eButt.setEnabled(true);
        rButt.setEnabled(true);
        tButt.setEnabled(true);
        yButt.setEnabled(true);
        uButt.setEnabled(true);
        iButt.setEnabled(true);
        oButt.setEnabled(true);
        pButt.setEnabled(true);
        aButt.setEnabled(true);
        sButt.setEnabled(true);
        dButt.setEnabled(true);
        fButt.setEnabled(true);
        gButt.setEnabled(true);
        hButt.setEnabled(true);
        jButt.setEnabled(true);
        kButt.setEnabled(true);
        lButt.setEnabled(true);
        zButt.setEnabled(true);
        xButt.setEnabled(true);
        cButt.setEnabled(true);
        vButt.setEnabled(true);
        bButt.setEnabled(true);
        nButt.setEnabled(true);
        mButt.setEnabled(true);               
    }
    public void disableButt()
    {
        qButt.setEnabled(false);
        wButt.setEnabled(false);
        eButt.setEnabled(false);
        rButt.setEnabled(false);
        tButt.setEnabled(false);
        yButt.setEnabled(false);
        uButt.setEnabled(false);
        iButt.setEnabled(false);
        oButt.setEnabled(false);
        pButt.setEnabled(false);
        aButt.setEnabled(false);
        sButt.setEnabled(false);
        dButt.setEnabled(false);
        fButt.setEnabled(false);
        gButt.setEnabled(false);
        hButt.setEnabled(false);
        jButt.setEnabled(false);
        kButt.setEnabled(false);
        lButt.setEnabled(false);
        zButt.setEnabled(false);
        xButt.setEnabled(false);
        cButt.setEnabled(false);
        vButt.setEnabled(false);
        bButt.setEnabled(false);
        nButt.setEnabled(false);
        mButt.setEnabled(false); 
    }
    
    public String ecrireMot(char saisit)
    {                
           //lettre est dans le mot, réafficher le mot caché avec la lettre deviner
        result = "";        
        for (int j = 0; j < motActif.length(); j++)
        {                
            if (saisit == motActif.charAt(j))
            {
                result += saisit;
                System.out.println(result + "1st check");
            }
            else
            {
                if (usedChar.contains(motActif.charAt(j)))
                {
                    result += motActif.charAt(j);
                    System.out.println(result + "2nd check");
                }
                else
                {                       
                    result += "*";
                    System.out.println(result + "3rd check");
                }             
            }
        }
        usedChar.add(saisit);
        System.out.println(result);
        if (result.equals(motActif))
        {
            motCache.setText(result);
            System.out.println("partie gagnante");
            messageJeu.setText(setmessageJeu(2));            
            if (ges.endGame())
            {
                String[] opt = new String[]{"Réessayer", "Changer de nom", "Quitter"};
                
                int a = JOptionPane.showOptionDialog(null, setmessageJeu(3) + "\nVotre score final est de " + String.valueOf(enCours.getScore()) + " points", "TU AS GAGNÉ!!!", 0, JOptionPane.PLAIN_MESSAGE, null, opt, null); 
                switch (a) 
                {
                    case 0:
                        System.out.println("CASE 0 - RETRY");                            
                             
                            scoreLabel.setText(String.valueOf(enCours.getScore()));
                            this.motActif = "";
                            this.result = "";
                            this.tentative = 0;
                            paintBonhomme.repaint();
                            this.usedMot.clear();
                            this.usedChar.clear();
                            motCache.setText("*A*C*M*E*");
                            messageJeu.setText(setmessageJeu(0));
                            startGame.setEnabled(true);
                            debutPartie.setEnabled(true);
                            disableButt();
                            enCours.resetScore();
                            

                        // attendre la réponse : oui = retourner au menu principal pour qu'il puisse changer de nom.
                        break;
                    case 1:
                        System.out.println("CASE 1 - CHANGENAME");
                        this.setVisible(false);
                        this.dispose();
                        accueilFrame acc = new accueilFrame();
                        acc.setVisible(true);
                        break;
                        
                    case 2:
                        
                        System.out.println("CASE 2 - QUITT");
                        System.exit(0);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        System.out.println("CASE 3 - QUITT");
                        System.exit(0);
                        break;
                    default:
                        break;
                }//dire au user qu'il a épuisé la banque de mot et sont score. offrir de recommencer la partie ou changer de nom ou quitter
            }
            else
            {
            //demander a lusager si il veut generer un nouveau mot et continuer a jouer sur la meme partie            
            //ou si il veut recommencer la partie            
            //yesno box qui annonce la victoire
            //if yes, reset bonhomme + nouveau + enable les boutons
            //else retourner menu accueil
            String[] option = new String[]{"Continuer", "Changer de nom", "Quitter"};                
            int a = JOptionPane.showOptionDialog(null, setmessageJeu(3) + "\nVotre score est de " + String.valueOf(enCours.getScore()) + " points", "MOT TROUVÉ", 0, JOptionPane.PLAIN_MESSAGE, null, option, null);
            switch (a) {
                    case 0:
                        System.out.println("CASE 0 - CONTINUE");                           
                             
                            scoreLabel.setText(String.valueOf(enCours.getScore()));
                            this.motActif = "";//PAS DANS LA LISTE usedMot
                            this.result = "";
                            this.tentative = 0;
                            paintBonhomme.repaint();
                            this.usedChar.clear();
                            //reset le ptit bonhomme
                            motCache.setText("*A*C*M*E*");
                            
                            debutPartie.setEnabled(true);
                            startGame.setEnabled(true);
                            messageJeu.setText(setmessageJeu(0));
                            disableButt();                            
                        break;
                    case 1:
                        System.out.println("CASE 1 - CHANGENAME");
                        this.setVisible(false);
                        this.dispose();
                        accueilFrame acc = new accueilFrame();
                        acc.setVisible(true);
                        break;
                        
                    case 2:
                        
                        System.out.println("CASE 2 - QUITT");
                        System.exit(0);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        System.out.println("CASE 3 - QUITT");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
            
        }

        return result;        
    }
    
    public void testLettre(char saisit)
    {
        messageJeu.setText(setmessageJeu(1));
        if (ges.checkLettre(saisit, motActif))
        {     
            System.out.println(enCours.getScore()+" pkoi il ajoute 1 a la fin dla game");
           enCours.setScore(1);
           motCache.setText(ecrireMot(saisit));
           scoreLabel.setText(String.valueOf(enCours.getScore()));                      
        }
        else
        {            
            System.out.println("trouve pas la lettre");
            this.tentative++;
            paintBonhomme.repaint();
            System.out.println(String.valueOf(this.tentative));
            messageJeu.setText(setmessageJeu(1));
            
            
            if(this.tentative >=6)
            {
                System.out.println("partie terminé");
                messageJeu.setText(setmessageJeu(3));
                //messagebox qui offre de réessayer avec le meme username ou recommencer avec un nouveau
                //close et réouvrir le game shit avec le meme username, ou retourner l'écran principal
                String[] opt = new String[]{"Réessayer", "Changer de nom", "Quitter"};
                
                int a = JOptionPane.showOptionDialog(null, setmessageJeu(3) + "\nVotre score final est de " + String.valueOf(enCours.getScore()) + " points", "GAME OVER", 0, JOptionPane.PLAIN_MESSAGE, null, opt, null); 
                switch (a) 
                {
                    case 0:
                        System.out.println("CASE 0 - RETRY");                            
                            enCours.resetScore(); 
                            scoreLabel.setText(String.valueOf(enCours.getScore()));
                            this.motActif = "";
                            this.result = "";
                            this.tentative = 0;
                            paintBonhomme.repaint();
                            this.usedMot.clear();
                            this.usedChar.clear();
                            motCache.setText("*A*C*M*E*");
                            messageJeu.setText(setmessageJeu(0));
                            startGame.setEnabled(true);
                            debutPartie.setEnabled(true);
                            disableButt();
                            

                        // attendre la réponse : oui = retourner au menu principal pour qu'il puisse changer de nom.
                        break;
                    case 1:
                        System.out.println("CASE 1 - CHANGENAME");
                        this.setVisible(false);
                        this.dispose();
                        accueilFrame acc = new accueilFrame();
                        acc.setVisible(true);
                        break;
                        
                    case 2:
                        
                        System.out.println("CASE 2 - QUITT");
                        System.exit(0);
                        break;
                    case JOptionPane.CLOSED_OPTION:
                        System.out.println("CASE 3 - QUITT");
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
            //lettre n'est pas dans le mot, +1 bonhomme
        }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        clavierPanel = new javax.swing.JPanel();
        jButt = new javax.swing.JButton();
        hButt = new javax.swing.JButton();
        kButt = new javax.swing.JButton();
        qButt = new javax.swing.JButton();
        lButt = new javax.swing.JButton();
        aButt = new javax.swing.JButton();
        zButt = new javax.swing.JButton();
        xButt = new javax.swing.JButton();
        wButt = new javax.swing.JButton();
        cButt = new javax.swing.JButton();
        sButt = new javax.swing.JButton();
        vButt = new javax.swing.JButton();
        eButt = new javax.swing.JButton();
        bButt = new javax.swing.JButton();
        tButt = new javax.swing.JButton();
        nButt = new javax.swing.JButton();
        rButt = new javax.swing.JButton();
        mButt = new javax.swing.JButton();
        yButt = new javax.swing.JButton();
        uButt = new javax.swing.JButton();
        iButt = new javax.swing.JButton();
        oButt = new javax.swing.JButton();
        dButt = new javax.swing.JButton();
        fButt = new javax.swing.JButton();
        gButt = new javax.swing.JButton();
        pButt = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        messageJeu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        nomJLabel = new javax.swing.JLabel();
        motCache = new javax.swing.JTextField();
        debutPartie = new javax.swing.JButton();
        paintBonhomme = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        resetMenu = new javax.swing.JMenu();
        startGame = new javax.swing.JMenuItem();
        infoMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        quitGameMenu = new javax.swing.JMenuItem();

        jButton4.setText("jButton1");

        jButton10.setText("jButton1");

        jButton15.setText("O");

        jButton22.setText("K");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jButt.setText("J");
        jButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtActionPerformed(evt);
            }
        });

        hButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        hButt.setText("H");
        hButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hButtActionPerformed(evt);
            }
        });

        kButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        kButt.setText("K");
        kButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButtActionPerformed(evt);
            }
        });

        qButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        qButt.setText("Q");
        qButt.setPreferredSize(new java.awt.Dimension(45, 19));
        qButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qButtActionPerformed(evt);
            }
        });

        lButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lButt.setText("L");
        lButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lButtActionPerformed(evt);
            }
        });

        aButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        aButt.setText("A");
        aButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aButtActionPerformed(evt);
            }
        });

        zButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        zButt.setText("Z");
        zButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zButtActionPerformed(evt);
            }
        });

        xButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        xButt.setText("X");
        xButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xButtActionPerformed(evt);
            }
        });

        wButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        wButt.setText("W");
        wButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wButtActionPerformed(evt);
            }
        });

        cButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        cButt.setText("C");
        cButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cButtActionPerformed(evt);
            }
        });

        sButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        sButt.setText("S");
        sButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sButtActionPerformed(evt);
            }
        });

        vButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        vButt.setText("V");
        vButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vButtActionPerformed(evt);
            }
        });

        eButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        eButt.setText("E");
        eButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eButtActionPerformed(evt);
            }
        });

        bButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        bButt.setText("B");
        bButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bButtActionPerformed(evt);
            }
        });

        tButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        tButt.setText("T");
        tButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tButtActionPerformed(evt);
            }
        });

        nButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        nButt.setText("N");
        nButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nButtActionPerformed(evt);
            }
        });

        rButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        rButt.setText("R");
        rButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rButtActionPerformed(evt);
            }
        });

        mButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        mButt.setText("M");
        mButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mButtActionPerformed(evt);
            }
        });

        yButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        yButt.setText("Y");
        yButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yButtActionPerformed(evt);
            }
        });

        uButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        uButt.setText("U");
        uButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uButtActionPerformed(evt);
            }
        });

        iButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        iButt.setText("I");
        iButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iButtActionPerformed(evt);
            }
        });

        oButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        oButt.setText("O");
        oButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oButtActionPerformed(evt);
            }
        });

        dButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        dButt.setText("D");
        dButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dButtActionPerformed(evt);
            }
        });

        fButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        fButt.setText("F");
        fButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fButtActionPerformed(evt);
            }
        });

        gButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        gButt.setText("G");
        gButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gButtActionPerformed(evt);
            }
        });

        pButt.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        pButt.setText("P");
        pButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pButtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout clavierPanelLayout = new javax.swing.GroupLayout(clavierPanel);
        clavierPanel.setLayout(clavierPanelLayout);
        clavierPanelLayout.setHorizontalGroup(
            clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clavierPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(qButt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wButt)
                .addGap(4, 4, 4)
                .addComponent(eButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oButt, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(clavierPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(clavierPanelLayout.createSequentialGroup()
                        .addComponent(zButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(xButt)
                        .addGap(10, 10, 10)
                        .addComponent(cButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(mButt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(clavierPanelLayout.createSequentialGroup()
                        .addComponent(aButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fButt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kButt)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lButt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clavierPanelLayout.setVerticalGroup(
            clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clavierPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clavierPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(zButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mButt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        messageJeu.setEditable(false);
        messageJeu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        messageJeu.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(messageJeu)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(messageJeu, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Score :");

        scoreLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        scoreLabel.setText("##");

        nomJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nomJLabel.setText("NomJoueur");

        motCache.setEditable(false);
        motCache.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        motCache.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        motCache.setText("*A*C*M*E*");

        debutPartie.setText("Générer");
        debutPartie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                debutPartieActionPerformed(evt);
            }
        });

        paintBonhomme = new javax.swing.JPanel(){
            @Override
            public void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                if (tentative >= 6)
                {
                    g.setColor(Color.red);
                    g.drawLine (148,210,188,150);
                }
                if (tentative >= 0)//debut
                {
                    g.drawLine(75, 0, 75, 210);
                    g.drawLine(75, 0, 175, 0);
                    g.drawLine(175, 0, 188, 55);
                }
                if (tentative >= 1)//tete
                {
                    g.fillOval (162, 5, 50, 50);
                }
                if (tentative >= 2)//corps
                {
                    g.drawLine (188, 55, 188, 150);
                }
                if (tentative >= 3)//bras gauche
                {
                    g.drawLine (148,110,188,90);
                }
                if (tentative >= 4)//bras droite
                {
                    g.drawLine (188,90,228,110);
                }
                if (tentative >= 5)
                {
                    g.drawLine (188,150,228,210);
                }

            }
        };

        javax.swing.GroupLayout paintBonhommeLayout = new javax.swing.GroupLayout(paintBonhomme);
        paintBonhomme.setLayout(paintBonhommeLayout);
        paintBonhommeLayout.setHorizontalGroup(
            paintBonhommeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        paintBonhommeLayout.setVerticalGroup(
            paintBonhommeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );

        resetMenu.setText("Menu");

        startGame.setText("Débuter le jeu");
        startGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startGameActionPerformed(evt);
            }
        });
        resetMenu.add(startGame);

        infoMenu.setText("À propos...");
        infoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoMenuActionPerformed(evt);
            }
        });
        resetMenu.add(infoMenu);

        jMenuItem1.setText("Accueil");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        resetMenu.add(jMenuItem1);

        quitGameMenu.setText("Quitter le jeu");
        quitGameMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitGameMenuActionPerformed(evt);
            }
        });
        resetMenu.add(quitGameMenu);

        jMenuBar1.add(resetMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(motCache)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(scoreLabel)
                                    .addGap(3, 3, 3))
                                .addComponent(debutPartie, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nomJLabel)))
                    .addComponent(paintBonhomme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clavierPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paintBonhomme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nomJLabel)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(scoreLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(debutPartie))
                    .addComponent(motCache, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(clavierPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void infoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoMenuActionPerformed
        JOptionPane.showMessageDialog(null, "Règles du jeu : \nEssaie de deviner le mot caché en utilisant les lettres de l'alphabet \navant que le petit bonhomme se fasse pendre. Sa vie est entre tes mains. \nTu as droit 6 erreurs avant d'être témoin d'une pendaison.\n1 point/lettre devinée.", "Règles du jeu", 1);
    }//GEN-LAST:event_infoMenuActionPerformed

    private void quitGameMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitGameMenuActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitGameMenuActionPerformed

    private void qButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qButtActionPerformed
        char saisit = 'q';
        System.out.println(motActif);
        testLettre(saisit);
        qButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit
        
    }//GEN-LAST:event_qButtActionPerformed

    private void wButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wButtActionPerformed
        char saisit = 'w';
        System.out.println(motActif);
        testLettre(saisit);
        wButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit
    }//GEN-LAST:event_wButtActionPerformed

    private void eButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eButtActionPerformed
        
              
        char saisit = 'e';
        System.out.println(motActif);
        testLettre(saisit);
        eButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_eButtActionPerformed

    private void rButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rButtActionPerformed
        char saisit = 'r';
        System.out.println(motActif);
        testLettre(saisit);
        rButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_rButtActionPerformed

    private void tButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tButtActionPerformed
        char saisit = 't';
        System.out.println(motActif);
        testLettre(saisit);
        tButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_tButtActionPerformed

    private void yButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yButtActionPerformed
        char saisit = 'y';
        System.out.println(motActif);
        testLettre(saisit);
        yButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_yButtActionPerformed

    private void uButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uButtActionPerformed
        char saisit = 'u';
        System.out.println(motActif);
        testLettre(saisit);
        uButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_uButtActionPerformed

    private void iButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iButtActionPerformed
        char saisit = 'i';
        System.out.println(motActif);
        testLettre(saisit);
        iButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_iButtActionPerformed

    private void oButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oButtActionPerformed
        char saisit = 'o';
        System.out.println(motActif);
        testLettre(saisit);
        oButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_oButtActionPerformed

    private void pButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pButtActionPerformed
        char saisit = 'p';
        System.out.println(motActif);
        testLettre(saisit);
        pButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_pButtActionPerformed

    private void aButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aButtActionPerformed
        char saisit = 'a';
        System.out.println(motActif);
        testLettre(saisit);
        aButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_aButtActionPerformed

    private void sButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sButtActionPerformed
        char saisit = 's';
        System.out.println(motActif);
        testLettre(saisit);
        sButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_sButtActionPerformed

    private void dButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dButtActionPerformed
        char saisit = 'd';
        System.out.println(motActif);
        testLettre(saisit);     
        dButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_dButtActionPerformed

    private void fButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fButtActionPerformed
        char saisit = 'f';
        System.out.println(motActif);
        testLettre(saisit);
        fButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_fButtActionPerformed

    private void gButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gButtActionPerformed
        char saisit = 'g';
        System.out.println(motActif);
        testLettre(saisit);     
        gButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_gButtActionPerformed

    private void hButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hButtActionPerformed
        char saisit = 'h';
        System.out.println(motActif);
        if (ges.checkLettre(saisit, motActif))
        testLettre(saisit);               hButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_hButtActionPerformed

    private void jButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtActionPerformed
        char saisit = 'j';
        System.out.println(motActif);
        testLettre(saisit);      
        jButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_jButtActionPerformed

    private void kButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButtActionPerformed
        char saisit = 'k';
        System.out.println(motActif);
        testLettre(saisit);
        kButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_kButtActionPerformed

    private void lButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lButtActionPerformed
        char saisit = 'l';
        System.out.println(motActif);
        testLettre(saisit);
        lButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_lButtActionPerformed

    private void zButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zButtActionPerformed
        char saisit = 'z';
        System.out.println(motActif);
        testLettre(saisit);    
        zButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_zButtActionPerformed

    private void xButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xButtActionPerformed
        char saisit = 'x';
        System.out.println(motActif);
        testLettre(saisit);     
        xButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_xButtActionPerformed

    private void cButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cButtActionPerformed
        char saisit = 'c';
        System.out.println(motActif);
        testLettre(saisit);     
        cButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_cButtActionPerformed

    private void vButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vButtActionPerformed
        char saisit = 'v';
        System.out.println(motActif);
        testLettre(saisit);
        vButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_vButtActionPerformed

    private void bButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bButtActionPerformed
        char saisit = 'b';
        System.out.println(motActif);
        testLettre(saisit);
        bButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_bButtActionPerformed

    private void nButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nButtActionPerformed
        char saisit = 'n';
        System.out.println(motActif);
        testLettre(saisit);      
        nButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_nButtActionPerformed

    private void mButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mButtActionPerformed
        char saisit = 'm';
        System.out.println(motActif);
        testLettre(saisit);      
        mButt.setEnabled(false);
        //envoyer la lettre a une méthode qui vérifie si la lettre se retrouve dans le mot choisit        // TODO add your handling code here:
    }//GEN-LAST:event_mButtActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        nomJLabel.setText(NomJoueurActif);        
        scoreLabel.setText(String.valueOf(enCours.getScore()));
        messageJeu.setText(setmessageJeu(0));  
        disableButt();
        
    }//GEN-LAST:event_formWindowOpened

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // aviser l'utilisateur qu'il perdera sa progression si il décide de recommencer la partie
         int a = JOptionPane.showConfirmDialog(null, "La réinitialisation du jeu entraînera la perte de votre progression. Souhaitez-vous poursuivre?", "Quitter la partie en cours?", 0, 2); 
            if(a==JOptionPane.YES_OPTION)
            {
                this.setVisible(false);
                this.dispose();
                accueilFrame acc = new accueilFrame();
                acc.setVisible(true);
              
        // attendre la réponse : oui = retourner au menu principal pour qu'il puisse changer de nom.
            }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void debutPartieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_debutPartieActionPerformed
        /* debuter la partie (créer un objet bonhomme et un objet mot
        ges.startGame();
        afficher le mot caché      
        */  ges.nextGame();       
            

            
            
                  
            String[] usedWord = new String[usedMot.size()];
            for (int y = 0; y < usedWord.length; y++)
            {
                usedWord[y] = usedMot.get(y);
            }
                String tryword = ges.startGame(usedWord);
                motActif = tryword;
                usedMot.add(motActif);
                String p ="";
                char[] lala = new char[motActif.length()];
                motActif.getChars(0, motActif.length(), lala , 0);
                for (int i = 0; i < lala.length; i++)
                {            
                    p += "*";            
                }
                motCache.setText(p);
                messageJeu.setText(setmessageJeu(4));
                enableButt();
                debutPartie.setEnabled(false);
                startGame.setEnabled(false);               
    }//GEN-LAST:event_debutPartieActionPerformed

    private void startGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startGameActionPerformed
            ges.nextGame();        
            String[] usedWord = new String[usedMot.size()];
            for (int y = 0; y < usedWord.length; y++)
            {
                usedWord[y] = usedMot.get(y);
            }
                String tryword = ges.startGame(usedWord);
                motActif = tryword;
                usedMot.add(motActif);
                String p ="";
                char[] lala = new char[motActif.length()];
                motActif.getChars(0, motActif.length(), lala , 0);
                for (int i = 0; i < lala.length; i++)
                {            
                    p += "*";            
                }
            motCache.setText(p);
            messageJeu.setText(setmessageJeu(4));
            enableButt();
            startGame.setEnabled(false);
            debutPartie.setEnabled(false);
    }//GEN-LAST:event_startGameActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(platformeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(platformeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(platformeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(platformeJeu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new platformeJeu().setVisible(true);
             
            }
        });
    }


   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aButt;
    private javax.swing.JButton bButt;
    private javax.swing.JButton cButt;
    private javax.swing.JPanel clavierPanel;
    private javax.swing.JButton dButt;
    private javax.swing.JButton debutPartie;
    private javax.swing.JButton eButt;
    private javax.swing.JButton fButt;
    private javax.swing.JButton gButt;
    private javax.swing.JButton hButt;
    private javax.swing.JButton iButt;
    private javax.swing.JMenuItem infoMenu;
    private javax.swing.JButton jButt;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton kButt;
    private javax.swing.JButton lButt;
    private javax.swing.JButton mButt;
    private javax.swing.JTextField messageJeu;
    private javax.swing.JTextField motCache;
    private javax.swing.JButton nButt;
    private javax.swing.JLabel nomJLabel;
    private javax.swing.JButton oButt;
    private javax.swing.JButton pButt;
    private javax.swing.JPanel paintBonhomme;
    private javax.swing.JButton qButt;
    private javax.swing.JMenuItem quitGameMenu;
    private javax.swing.JButton rButt;
    private javax.swing.JMenu resetMenu;
    private javax.swing.JButton sButt;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JMenuItem startGame;
    private javax.swing.JButton tButt;
    private javax.swing.JButton uButt;
    private javax.swing.JButton vButt;
    private javax.swing.JButton wButt;
    private javax.swing.JButton xButt;
    private javax.swing.JButton yButt;
    private javax.swing.JButton zButt;
    // End of variables declaration//GEN-END:variables
}
