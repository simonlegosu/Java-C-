package aubergefdl;
import java.util.*;

public class gestion {
    
    private int semaine;
    private double retraite;
    private double assemp;
    
    public double getRetraite()
        {
            return retraite;
        }
        
    public void setRetraite(double ret)
        {
            this.retraite += ret;
        }
    public double getAssemp()
        {
            return assemp;
        }
        
    public void setAssemp(double ass)
        {
            this.assemp += ass;
        }    
    
    
    public int getSemaine()
        {
            return semaine;
        }
        
    public void setSemaine(int sem)
        {
            this.semaine = sem;
        }
    
    ArrayList<Employe> Emp = new ArrayList<Employe>();
    public void AjouterEmp(String nom, String depart, int num)
    {
        Employe emp = new Employe();
        emp.setNom(nom);
        emp.setnumeroEmp(num);
        emp.setDepart(depart);        
        Emp.add(emp);
    }
    
    public String AfficherEmp()
    {
        String s = "";
        for (Employe e : Emp) 
        {
            s += e.toString() + "\n";
        }
        System.out.print(s);
        return s;        
    }   

        
    ArrayList<Paye> Pay = new ArrayList<>();
    
    public void AjouterPaye(int num, int heures, String depart, double comm, String nom )
    {
        Paye pay = new Paye();
        pay.setnumeroEmp(num);
        pay.setHeures(heures);
        
        pay.setSalaireBrut(heures, depart, comm, nom);
        pay.setImpotFederal(pay.getSalaireBrut());
        pay.setImpotProvincial(pay.getSalaireBrut());
        pay.setRegimeRetraite(pay.getSalaireBrut());
        pay.setassEmploiEMP(pay.getSalaireBrut());
        pay.setassEmploiBOSS(pay.getSalaireBrut());
         
        
        pay.setDepart(depart);
        System.out.print("ajouter paye " + depart + " " + String.valueOf(pay.getSalaireBrut())+"\n");
        pay.setSalaireNet(pay.getSalaireBrut(), pay.getImpotFederal(), pay.getImpotProvincial(), pay.getRegimeRetraite(), pay.getassEmploiEMP());
        setRetraite(pay.getRegimeRetraite());
        setAssemp(pay.getassEmploiBOSS());
        Pay.add(pay);
    }
    
    public String AfficherPaye()
    {
        String s = "";
        for (Paye p : Pay)
        {
            s += p.toString() + "\n";
        }        
        return s;
    }
    
    ArrayList<Ventes> Ven = new ArrayList<>();
    
    public void AjouterVente(double vente, int semaine, int id, String nom)
    {
        Ventes ve = new Ventes();
        ve.setCommission(vente);
        ve.setVente(vente);
        ve.setSemaine(semaine);
        ve.setnumeroEmp(id);
        ve.setNom(nom);
        System.out.print("ajouter vente " + String.valueOf(id) + " " + String.valueOf(vente)+"\n");
        Ven.add(ve);        
    }
    
    public String AfficherVente()
    {
        String s = "";
        for (Ventes v : Ven)
        {
            s += v.toString() + "\n";
        }        
        return s;
    }
    


    
    

}
