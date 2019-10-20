
package aubergefdl;


public class Employe 
{
    private int numeroEmp;
    private String nom;    
    private String departement;

    

    //GETSET valeurs entré par lutilisateur
        //getset numero employé
        public int getnumeroEmp() 
        {
            return numeroEmp;
        }  
        public void setnumeroEmp(int newNumeroEmp) 
        {
            this.numeroEmp = newNumeroEmp;
        }
        //getset nom
        public String getNom()
        {
            return nom;
        }
        public void setNom(String newNom)
        {
            this.nom = newNom;
        }

        public String getDepart()
        {
            return this.departement;
        }
        public void setDepart(String choice)
        {

            switch(choice) 
            {
              case "REST":
                this.departement = "Restaurant"; 
                break;
              case "MAIN": //maintenance
                this.departement = "Maintenance"; 
                break;
              case "COMM"://commis-paysagiste
                this.departement = "Commis/Paysagiste"; 
                break;
              case "VENT"://vendeur
                this.departement = "Ventes";
                break;
            }
        }

            @Override
            public String toString()
            {
            String id = String.valueOf(numeroEmp);
            String infoEmp = (id +"     "+ nom + "     " + departement);
            return infoEmp;
            }
        

        
        
        
        
        
        
       

    
    
}

