
package aubergefdl;
import java.util.*;
import java.text.DecimalFormat;


public class Ventes {
    
    public static final double STEP1 = 2500;
    public static final double STEP2 = 4250;
    public static final double STEP3 = 7000;
    
    public static final double TAUX1 = 0.015;
    public static final double TAUX2 = 0.025;
    public static final double TAUX3 = 0.05;           

    private int semaine;
    private double sale;
    private double commission;
    private int numEmp;
    private String name;
    
     public String getNom() 
        {
            return name;
        }  
        public void setNom(String nom) 
        {
            this.name = nom;
        }
    
    public int getnumeroEmp() 
        {
            return numEmp;
        }  
        public void setnumeroEmp(int newNumeroEmp) 
        {
            this.numEmp = newNumeroEmp;
        }
    
    public int getSemaine()
        {
            return semaine;
        }
        
    public void setSemaine(int sem)
        {
            this.semaine = sem;
        }    
    
    public double getVente()
        {
            return sale;
        }
        
    public void setVente(double vente)
        {
            this.sale = vente;
        }
    
    public double getCommission()
        {
            return commission;
        }
        
    public void setCommission(double vente)
        {
            if (vente > STEP1)
            {                
                if (vente > STEP2)
                {
                    if (vente > STEP3)
                    {
                        double v = vente - STEP3;
                        this.commission = (STEP1 * TAUX1) + ((STEP2 - STEP1) * TAUX2) + (v * TAUX3);
                    }
                    else
                    {
                        double v = vente - STEP2;
                        this.commission = (STEP1 * TAUX1) + (v * TAUX2);
                    }               
                }
                else
                {
                    this.commission = vente * TAUX1;                   
                }
            }
            else
            {
            this.commission = 0;
            }
        }
    
            @Override
            public String toString()
            {
            String semaineout = String.valueOf(semaine);
            String comm = String.valueOf(commission);
            String vent = String.valueOf(sale);
            String idEmp = String.valueOf(numEmp);
            String  nom = name;
            String infoVente = (idEmp +"  "+ vent + "  "+ comm + "  " + semaineout + "  " + nom);
            return infoVente;
            }
    
}
