package aubergefdl;
import java.text.DecimalFormat;

public class Paye 
{
//CONSTANTES
    //salaire employ
    public static final double TAUXRESTO = 8.50;
    public static final double TAUXMAINTENANCE = 12.50;
    public static final double TAUXCOMMIS = 15.75;
    public static final double TAUXVENTE = 15.00;
    public static final double TAUXHEURESSUP = 1.5;
    //impot
    public static final double TAUXIMPOTFED1 = 0.16;
    public static final double TAUXIMPOTFED2 = 0.22;
    public static final double TAUXIMPOTPROV1 = 0.0605;
    public static final double TAUXIMPOTPROV2 = 0.0725;
    //assurance/retraite
    public static final double TAUXREGRETRAITE = 0.0495;
    public static final double TAUXASSEMP_EMP = 0.0198;
    public static final double TAUXASSEMP_BOSS = 0.0277;
    
    private int numEmp;
    private String name;
    private String depart;
    private int heures;
    private int semaine;
    private double salaireBrut;
    private double impotFed;
    private double impotProv;
    private double retraiteCanada;
    private double assEmploiEMP;
    private double assEmploiBOSS;
    private double salaireNet; 
    private int heuresSupp;

        public String getDepart() 
        {
            return depart;
        }  
        public void setDepart(String dep) 
        {
            this.depart = dep;
        }
        
    
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
            //getset heures
        public int getHeures() 
        {
            return heures;
        }  
        public void setHeures(int HeuresWorked) 
        {
            this.heures = HeuresWorked;
        }
        
        public int getSemaine() 
        {
            return semaine;
        }  
        public void setSemaine(int HeuresWorked) 
        {
            this.heures = HeuresWorked;
        }
        
        
        public double getSalaireBrut()
        {
            return salaireBrut;
        }
        public void setSalaireBrut(int HeuresWorked, String depart, double comm, String nom)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");            
            double money;
            this.name = nom;
            this.heures = HeuresWorked;
            int ot;
            switch(depart)
            {
                case "Restaurant":                //resto
                if (HeuresWorked <= 44)
                {   
                   money = Paye.TAUXRESTO * HeuresWorked;
                   this.salaireBrut = Double.parseDouble(formatter.format(money));
                   break;
                }
                else
                {
                    ot = HeuresWorked - 44;
                    money = (Paye.TAUXRESTO * 44) + ((Paye.TAUXRESTO * TAUXHEURESSUP) * ot);
                    this.salaireBrut = Double.parseDouble(formatter.format(money));
                    this.heuresSupp = ot;
                    break;
                }
                
              case "Maintenance": //maintenance
                if (HeuresWorked <= 44)
                {
                money = Paye.TAUXMAINTENANCE * HeuresWorked; 
                this.salaireBrut = Double.parseDouble(formatter.format(money));
                break;
                }
                else
                {
                    ot = HeuresWorked - 44;
                    money = (Paye.TAUXMAINTENANCE * 44) + ((Paye.TAUXMAINTENANCE * TAUXHEURESSUP)* ot);
                    this.salaireBrut = Double.parseDouble(formatter.format(money));
                    this.heuresSupp = ot;
                    break;
                }
                
              case "Commis/Paysagiste"://commis-paysagiste
                if (HeuresWorked <= 44)
                {
                money = Paye.TAUXCOMMIS * HeuresWorked;
                this.salaireBrut = Double.parseDouble(formatter.format(money));
                break;
                }
                else
                {
                    ot = HeuresWorked - 44;
                    money = (Paye.TAUXCOMMIS * 44) + ((Paye.TAUXCOMMIS * TAUXHEURESSUP)* ot);
                    this.salaireBrut = Double.parseDouble(formatter.format(money));
                    this.heuresSupp = ot;
                    break;
                }
              case "Ventes"://vendeur
                money = (Paye.TAUXVENTE * HeuresWorked) + comm; //ajouter commision avec methode lalala 
                this.salaireBrut = Double.parseDouble(formatter.format(money));
                break;

            }           
        }
        
        public double getImpotFederal()
        {
            return impotFed;
        }
        
        public void setImpotFederal(double salaire)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double salaireannuel = salaire * 52;            
            double salformat;
            
            if (salaireannuel <= 35000)           
            {
                salformat = salaire * Paye.TAUXIMPOTFED1;
                this.impotFed = Double.parseDouble(formatter.format(salformat));
            }
            if (salaireannuel > 35000)
            {
                double federal1 = (35000 * Paye.TAUXIMPOTFED1)/52;
                double fedannuel = salaireannuel - 35000;
                double federal2 = (fedannuel * Paye.TAUXIMPOTFED2)/52;
                salformat = federal1 + federal2;
                this.impotFed = Double.parseDouble(formatter.format(salformat));
                
            }
            
        }
        
        public double getImpotProvincial() 
        {
            return impotProv;
        }
        
        public void setImpotProvincial(double salaire)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double salaireannuel = salaire * 52;
            double salformat;
            
            if (salaireannuel <= 35000)
            {
                salformat = salaire * Paye.TAUXIMPOTPROV1;
                this.impotProv = Double.parseDouble(formatter.format(salformat));
            }
            if (salaireannuel > 35000)
            {
                double provincial1 = (35000 * Paye.TAUXIMPOTPROV1)/52;
                double provannuel = salaireannuel - 35000;
                double provincial2 = (provannuel * Paye.TAUXIMPOTPROV2)/52;
                salformat = provincial1 + provincial2;
                this.impotProv = Double.parseDouble(formatter.format(salformat));
            }
            
        }

        public double getRegimeRetraite() 
        {
            return retraiteCanada;
        }
        
        public void setRegimeRetraite(double salaire)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double regimeformat;
            regimeformat = salaire * Paye.TAUXREGRETRAITE;
            this.retraiteCanada = Double.parseDouble(formatter.format(regimeformat));
            
        }
        public double getassEmploiEMP() 
        {
            return assEmploiEMP;
        }
        
        public void setassEmploiEMP(double salaire)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double regimeformat;
            regimeformat = salaire * Paye.TAUXASSEMP_EMP;
            this.assEmploiEMP = Double.parseDouble(formatter.format(regimeformat));            
            
        }
        public double getassEmploiBOSS() 
        {
            return assEmploiBOSS;
        }
        
        public void setassEmploiBOSS(double salaire)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double regimeformat;
            regimeformat = salaire * Paye.TAUXASSEMP_BOSS;
            this.assEmploiBOSS = Double.parseDouble(formatter.format(regimeformat));
            
        }
        public double getSalaireNet() 
        {
            return salaireNet;
        }
        
        public void setSalaireNet(double salBrut, double impFed, double impProv, double retraite, double assurance)
        {
            DecimalFormat formatter = new DecimalFormat("#0.00");
            double salNet;
            salNet  = salBrut - impFed - impProv - retraite - assurance;
            this.salaireNet = Double.parseDouble(formatter.format(salNet));     
        }       
        
        public int getHeuSupp()
        {            
            return this.heuresSupp;            
        }
                
        public void setHeuSupp(int ot)
        {            
            this.heuresSupp = ot;            
        }

        
        
        
            @Override
            public String toString()
            {
                String nom = name;
                String idEmp = String.valueOf(numEmp);
                String hour = String.valueOf(heures);
                String ot = String.valueOf(heuresSupp);
                String semaineout = String.valueOf(semaine);
                String salB = String.valueOf(salaireBrut);
                String impF = String.valueOf(impotFed);
                String impP = String.valueOf(impotProv);
                String retC = String.valueOf(retraiteCanada);
                String assE = String.valueOf(assEmploiEMP);
                String assB = String.valueOf(assEmploiBOSS);
                String salN = String.valueOf(salaireNet);
                String departement = depart;
                
                String infoPaye = (idEmp +"  "+ nom +"  "+ hour + "  "+ ot + "  " + semaineout + "  " +salB + "  " + impF + "  " + impP + "  " + retC + "  " + assE + "  " + assB + "  " + salN + "  " + departement);
                return infoPaye;
            }
    
}
