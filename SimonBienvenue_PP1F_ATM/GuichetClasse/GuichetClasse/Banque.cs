using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace GuichetClasse
{
    public class Banque : Compte
    {
        const double montantMaximum = 20000;
        const double montantRemplissage = 5000;
        double cashGuichet;

        public double CashGuichet
        {
            get
            {
                return cashGuichet;
            }
            set
            {
                cashGuichet = value;
            }
        }

        public bool RemplirGuichet()
        {
            if ((montantMaximum - cashGuichet) >= montantRemplissage)
            {
                cashGuichet += montantRemplissage;
                return true;
            }
            return false;
        }

        public override string ToString()
        {
            Convert.ToString(cashGuichet);
            string infoCompte = String.Format("{0} $", CashGuichet);
            return infoCompte;
        }        
    }

}
