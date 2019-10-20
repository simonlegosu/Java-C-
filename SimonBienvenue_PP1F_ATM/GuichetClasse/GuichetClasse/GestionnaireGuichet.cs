using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.IO;

namespace GuichetClasse
{
    public class GestionnaireGuichet
    {         
      List<Compte> comptex = new List<Compte>();
      List<string> users = new List<string>();
      List<string> pass = new List<string>();
      int lireComptes = 0;

        public bool ValiderUtilisateur(string nom, string nip)
        {                   
                if (users.Contains(nom) && pass.Contains(nip) && Array.IndexOf(users.ToArray(), nom) == Array.IndexOf(pass.ToArray(), nip))
                {
                    
                    return true;
                }
                else
                {
                    return false;
                }            
        }

        public bool RetraitCheque(double montant, string nip)
        {
            foreach (Compte cop in comptex)
            {
                if (nip == cop.NumeroNIP && cop.TypeCompte == 'C')
                {
                    if (montant > cop.SoldeCompte)
                    {
                        return false;
                    }
                    else
                    {
                        try
                        {
                            string tempFile = Path.GetTempFileName();
                            using (var sr = new StreamReader("Comptes.txt"))
                            using (var sw = new StreamWriter(tempFile))
                            {
                                string line;
                                while ((line = sr.ReadLine()) != null)
                                {
                                    if (line != cop.ToString())
                                    {
                                        sw.WriteLine(line);
                                    }
                                }
                                sr.Close();
                                sw.Close();
                            }
                            File.Delete("Comptes.txt");
                            File.Move(tempFile, "Comptes.txt");

                            cop.SoldeCompte = cop.SoldeCompte - montant;                            

                            using (StreamWriter final = File.AppendText("Comptes.txt"))
                            {
                                final.Write(cop.ToString());
                                final.Close();
                            }                            
                        }
                        catch (IOException)
                        {
                            return false;
                        }
                        return true;                        
                    }
                }
            }
            return false;
        }
        

        public bool RetraitEpargne(double montant, string nip)
        {
            foreach (Compte cop in comptex)
            {
                if (nip == cop.NumeroNIP && cop.TypeCompte == 'E')
                {
                    if (montant > cop.SoldeCompte)
                    {
                        return false;
                    }
                    else
                    {
                        try
                        {
                        string tempFile = Path.GetTempFileName();
                        using (var sr = new StreamReader("Comptes.txt"))
                        using (var sw = new StreamWriter(tempFile))
                        {
                            string line;

                            while ((line = sr.ReadLine()) != null)
                            {
                                if (line != cop.ToString())
                                {
                                    sw.WriteLine(line);
                                }
                            }
                            sr.Close();
                            sw.Close();
                        }
                        File.Delete("Comptes.txt");
                        File.Move(tempFile, "Comptes.txt");
                        cop.SoldeCompte -= montant;                        

                        using ( StreamWriter final = File.AppendText("Comptes.txt"))
                        {
                            final.Write(cop.ToString());
                            final.Close();
                        }
                        }
                        catch (IOException)
                        {
                            return false;
                        }
                        return true;                       
                    }
                }
            }
            return false;
        }

        public bool DepotCheque(double montant, string nip)
        {
            foreach (Compte cop in comptex)
            {
                if (nip == cop.NumeroNIP && cop.TypeCompte == 'C')
                {                    
                    try
                    {
                    string tempFile = Path.GetTempFileName();
                    using (var sr = new StreamReader("Comptes.txt"))
                    using (var sw = new StreamWriter(tempFile))
                    {
                        string line;

                        while ((line = sr.ReadLine()) != null)
                        {
                            if (line != cop.ToString())
                            {
                                sw.WriteLine(line);
                            }
                        }
                        sr.Close();
                        sw.Close();
                    }
                    File.Delete("Comptes.txt");
                    File.Move(tempFile, "Comptes.txt");
                    cop.SoldeCompte += montant;                    

                    using (StreamWriter final = File.AppendText("Comptes.txt"))
                    {
                        final.Write(cop.ToString());
                        final.Close();
                    }
                    }
                    catch (IOException)
                    {
                        return false;
                    }
                    return true;
                    
                }
            }
            return false;
        }

        public bool DepotEpargne(double montant, string nip)
        {
            foreach (Compte cop in comptex)
            {
                if (nip == cop.NumeroNIP && cop.TypeCompte == 'E')
                {
                    try
                    {
                    string tempFile = Path.GetTempFileName();
                    using (var sr = new StreamReader("Comptes.txt"))
                    using (var sw = new StreamWriter(tempFile))
                    {
                        string line;

                        while ((line = sr.ReadLine()) != null)
                        {
                            if (line != cop.ToString())
                            {
                                sw.WriteLine(line);
                            }
                        }
                        sr.Close();
                        sw.Close();
                    }
                    File.Delete("Comptes.txt");
                    File.Move(tempFile, "Comptes.txt");
                    cop.SoldeCompte += montant;
                    

                    using (StreamWriter final = File.AppendText("Comptes.txt"))
                    {
                        final.Write(cop.ToString());
                        final.Close();
                    }
                    }
                    catch (IOException)
                    {
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }

        public bool PaiementFacture(double montant, string nip)
        {
            foreach (Compte cop in comptex)
            {
                if (nip == cop.NumeroNIP && cop.TypeCompte == 'C')
                {
                    if (cop.SoldeCompte >= montant)
                    {
                        try
                        {
                        string tempFile = Path.GetTempFileName();
                        using (var sr = new StreamReader("Comptes.txt"))
                        using (var sw = new StreamWriter(tempFile))
                        {
                            string line;
                            while ((line = sr.ReadLine()) != null)
                            {
                                if (line != cop.ToString())
                                {
                                    sw.WriteLine(line);
                                }
                            }
                            sr.Close();
                            sw.Close();
                        }
                        File.Delete("Comptes.txt");
                        File.Move(tempFile, "Comptes.txt");                       
                        cop.SoldeCompte -= (montant + Cheque.fraisPaiementFacture);                                             

                        using (StreamWriter final = File.AppendText("Comptes.txt"))
                        {
                            final.Write(cop.ToString());
                            final.Close();
                        }
                        }
                        catch (IOException)
                        {
                            return false;
                        }
                        return true;
                    }
                }
            }
            return false;
           
        }

        public bool TransfertFonds(double montant, string nip, char typeCompte, char versCompte)
        {
            
                foreach (Compte cop in comptex)
                {                    
                    if (nip == cop.NumeroNIP && cop.TypeCompte == typeCompte)
                    {
                        if (cop.SoldeCompte >= montant)
                        {
                            foreach (Compte butt in comptex.Where(butt => nip == butt.NumeroNIP && butt.TypeCompte == versCompte))
                            {                                
                                    try
                                    {
                                        string tempFile = Path.GetTempFileName();
                                        using (var sr = new StreamReader("Comptes.txt"))
                                        using (var sw = new StreamWriter(tempFile))
                                        {
                                            string line;

                                            while ((line = sr.ReadLine()) != null)
                                            {
                                                if (line != cop.ToString())
                                                {
                                                    if (line != butt.ToString())
                                                    {                                                
                                                        sw.WriteLine(line);
                                                    }                                                
                                                }
                                            }
                                            sr.Close();
                                            sw.Close();
                                        }
                                        File.Delete("Comptes.txt");
                                        File.Move(tempFile, "Comptes.txt");


                                        

                                        using (StreamWriter final = File.AppendText("Comptes.txt"))
                                        {
                                            butt.SoldeCompte += montant;
                                            cop.SoldeCompte -= montant;
                                            final.WriteLine(cop.ToString());
                                            final.WriteLine(butt.ToString());
                                            final.Close();
                                        }
                                    }
                                    catch (IOException)
                                    {
                                        return false;
                                    }
                                    return true;                                 
                            }
                            
                        }
                        
                    }
                }
                return false;
                
        
            
    }

        public string AfficheSoldeCompte(string nip, char typeCompte)
        {
            string s = "";

                foreach (Compte c in comptex.Where(c => c.NumeroNIP == nip && c.TypeCompte == typeCompte))
                {
                    s = c.AfficherSolde();                        
                }
            
            return s;  
        }

        public void LireClients()
        {
            StreamReader readerClit = new StreamReader("Clients.txt");
            string line = "";
            while ((line = readerClit.ReadLine()) != null)
            {
                string[] components = line.Split(",".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
                users.Add(components[0]);
                pass.Add(components[1]);
            }
            readerClit.Close();
            
            
        }


        public void LireComptes()
        {
            if (lireComptes == 0)
            {

                StreamReader readerComp = new StreamReader("Comptes.txt");
                string line = "";
                while ((line = readerComp.ReadLine()) != null)
                {
                    Compte co = new Compte();
                    string[] details = line.Split(",".ToCharArray(), StringSplitOptions.RemoveEmptyEntries);
                    if (details.Length >= 4)
                    {
                        try
                        {
                            co.NumeroNIP = details[0];
                            co.TypeCompte = char.Parse(details[1]);
                            co.NumeroCompte = details[2];
                            co.SoldeCompte = double.Parse(details[3]);
                            comptex.Add(co);
                        }
                        catch (IndexOutOfRangeException){}
                        catch (FormatException){}

                    }
                }
                readerComp.Close();
                lireComptes++;
            }

        }

        public string ImprimerComptes()
        {
            string p = "";
            foreach (Compte c in comptex)
            {
                p += c.AfficherSolde() + "\n";
            }
            return p; 
        }

        public bool PayerEpargne()
        {
            foreach (Compte c in comptex.Where(c => c.TypeCompte == 'E'))
            {

                    string tempFile = Path.GetTempFileName();
                    using (var sr = new StreamReader("Comptes.txt"))
                    using (var sw = new StreamWriter(tempFile))
                    {
                        string line;

                        while ((line = sr.ReadLine()) != null)
                        {
                            if (line != c.ToString())
                            {
                                sw.WriteLine(line);
                            }
                        }
                        sr.Close();
                        sw.Close();
                    }
                    File.Delete("Comptes.txt");
                    File.Move(tempFile, "Comptes.txt");
                    
                    c.SoldeCompte += (c.SoldeCompte * Epargne.tauxInteret / 365 / 100);
                    c.SoldeCompte = Math.Round(c.SoldeCompte, 2);
                   
                    using (StreamWriter final = File.AppendText("Comptes.txt"))
                    {
                        final.Write(c.ToString());
                        final.Close();
                    }
                      
                    
            }
            return true;                  
        }


    }
}
