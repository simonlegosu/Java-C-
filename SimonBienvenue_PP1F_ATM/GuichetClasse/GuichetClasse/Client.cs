using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GuichetClasse
{
    public class Client
    {
        string nom;
        string numeroNIP;

        public string Nom
        {
            get
            {
                return nom;
            }
            set
            {
                nom = value;
            }
        }

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
        public override string ToString()
        {
            return string.Format("{0} {1}", Nom, NumeroNIP);
        }
        //methode getnom get numeroNip a ajouter au besoin
        
    }
}
