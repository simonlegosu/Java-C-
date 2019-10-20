using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GuichetClasse
{
    public class Compte
    {
        string numeroNIP;
        char typeCompte;
        string numeroCompte; 
        double soldeCompte; 
        public const double retraitMaximum = 1000; 
        public const double montantTransfertMaximum = 100000;

        public string NumeroNIP
        {
            get
            {
                return numeroNIP;
            }
            set
            {
                numeroNIP = value;
            }
        }

        public char TypeCompte
        {
            get
            {
                return typeCompte;
            }
            set
            {
                typeCompte = value;
            }
        }

        public string NumeroCompte
        {
            get
            {
                return numeroCompte;
            }
            set
            {
                numeroCompte = value;
            }
        }

        public double SoldeCompte
        {
            get
            {
                return soldeCompte;
            }
            set
            {
                soldeCompte = value;
            }
        }
        public override string ToString()
        {
            Convert.ToString(soldeCompte);
            Convert.ToString(typeCompte);
            string infoCompte = String.Format("{0},{1},{2},{3}", NumeroNIP, TypeCompte, NumeroCompte, SoldeCompte);
            return infoCompte;
        }
        
        public string AfficherSolde()
        {
            Convert.ToString(soldeCompte);
            Convert.ToString(typeCompte);
            string infoCompte = String.Format("\nCompte : {0} \n# Compte: {1} \nSolde : {2} $.", TypeCompte, NumeroCompte, SoldeCompte);
            return infoCompte;
        }   

    }
}
