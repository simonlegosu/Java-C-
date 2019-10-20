using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace NLHospital
{
    /// <summary>
    /// Logique d'interaction pour Admission.xaml
    /// </summary>
    public partial class Admission : Window
    {
        NLHospitalEntities3 hos;
        public Admission()
        {
            InitializeComponent();
        }

        private void quitButt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void pataddrechButt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            Patient pat = new Patient();
            pat.ShowDialog();
            
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            hos = new NLHospitalEntities3();
            
            chambreadmCombox.DataContext = hos.tblChambres;
            perkadmCombox.DataContext = hos.tblPerks;



            List<tblLit> litrestant = (from z in hos.tblLits
                                       where z.ID_Adm == null
                                       select z).ToList();

            if (litrestant.Count == 0)
            {
                MessageBox.Show("L'hôpital est présentement à pleine capacité. Veuillez réessayer plus tard.");
                idpatadmCombox.IsEnabled = false;
                depadmCombox.IsEnabled = false;
                medadmCombox.IsEnabled = false;
                chambreadmCombox.IsEnabled = false;
                perkadmCombox.IsEnabled = false;
                idlitCombox.IsEnabled = false;
            }
            else 
            {
                List<tblPatient> patav = (from p in hos.tblPatients
                                          where p.Vacancy == false
                                          select p).ToList();

                idpatadmCombox.DataContext = patav;
            }
            
            
        }

        private void valideradmButt_Click(object sender, RoutedEventArgs e)
        {
                tblPatient patLit = (tblPatient)idpatadmCombox.SelectedItem;
                tblLit assLit = (tblLit)idlitCombox.SelectedItem;
                tblAdmission newadm = new tblAdmission();
                newadm.ID_Patient = ((tblPatient)idpatadmCombox.SelectedItem).ID_Patient;
                newadm.ID_Departement = ((tblDepartement)depadmCombox.SelectedItem).ID_Departement;
                newadm.ID_Medecin = ((tblMedecin)medadmCombox.SelectedItem).ID_Medecin;
                newadm.ID_Chambre = ((tblChambre)chambreadmCombox.SelectedItem).ID_Type;
                newadm.ID_Perk = ((tblPerk)perkadmCombox.SelectedItem).ID_Perk;
                newadm.ID_Lit = ((tblLit)idlitCombox.SelectedItem).ID_Lit;
                assLit.ID_Adm = newadm.ID_Adm;
                newadm.DateAdmin = DateTime.Now;
                patLit.Vacancy = true;

                hos.tblAdmissions.AddObject(newadm);
                hos.SaveChanges();
                MessageBox.Show("L'admission a été enregistré avec succès! Le ID d'admission est : " + newadm.ID_Adm.ToString() + " et le lit assigné est le " + newadm.ID_Lit.ToString() + ".");

                this.Close();
                Admission sion = new Admission();
                sion.ShowDialog();
            
        }

        private void idpatadmCombox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            int birthday = ((tblPatient)idpatadmCombox.SelectedItem).DateNaissance.Year;
            int age = DateTime.Now.Year - birthday;
            if (age > 16)
            {                
                List<tblDepartement> majeurDep = (from d in hos.tblDepartements
                                                  where d.ID_Departement != 2                                                       
                                                  select d).ToList();
               
                depadmCombox.DataContext = majeurDep;
            }
            else
            {                
                List<tblDepartement> mineurDep = (from a in hos.tblDepartements
                                                  where a.ID_Departement == 2 || a.ID_Departement == 1                                                       
                                                  select a).ToList();

                depadmCombox.DataContext = mineurDep;
            }

        }

        private void depadmCombox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            
            List<tblMedecin> medDep = (from c in ((tblDepartement)depadmCombox.SelectedItem).tblMedecins
                                       where c.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                       select c).ToList();

            medadmCombox.DataContext = medDep;

        }

       private void chambreadmCombox_SelectionChanged(object sender, SelectionChangedEventArgs e)
       {
            List<tblLit> litdispo = (from b in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                    where b.ID_Adm==null
                                    where b.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                    where b.ID_Chambre == ((tblChambre)chambreadmCombox.SelectedItem).ID_Type
                                    select b).ToList();

            if (litdispo.Count != 0)
            {
                idlitCombox.DataContext = litdispo;
            }
            //choix(3) 
            #region

            if (litdispo.Count == 0 && ((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 3) //choix standard(3) pleine
            {
                List<tblLit> litdispo2 = (from q in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                          where q.ID_Adm == null
                                          where q.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                          where q.ID_Chambre == 2
                                          select q).ToList();

                if (litdispo2.Count != 0)
                {
                    idlitCombox.DataContext = litdispo2;
                    MessageBox.Show("Il ne reste plus de lits dans une chambre standard. Vous pouvez sélectionner un lit dans une chambre semi-privée sans frais supplémentaire!");
                }
                else
                {
                    if ((((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 3)) //choix standard(3) pleine + semi-privé(2) pleine
                    {
                        List<tblLit> litdispo3 = (from t in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                                  where t.ID_Adm == null
                                                  where t.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                                  where t.ID_Chambre == 1
                                                  select t).ToList();

                        if (litdispo3.Count != 0)
                        {
                            idlitCombox.DataContext = litdispo3;
                            MessageBox.Show("Il ne reste que des chambres privées dans ce département. Vous pouvez choisir une chambre privée sans frais supplémentaire!");
                        }
                        else
                        {
                            if (((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 3) //choix(2) département plein
                            {
                                List<tblLit> litdispo4 = (from q in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                                          where q.ID_Adm == null
                                                          select q).ToList();

                                if (litdispo4.Count != 0)
                                {
                                    idlitCombox.DataContext = litdispo4;
                                    MessageBox.Show("Il ne reste plus de lits dans ce département. Vous pouvez sélectionner un lit dans un autre département.");
                                }
                            }
                        }
                    }
                }
            }

            #endregion
            //choix(2)
            #region

            if ((litdispo.Count == 0) && ((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 2)     //choix(2) semi-privé(2) pleine
            {
                List<tblLit> litdispo3 = (from t in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                          where t.ID_Adm == null
                                          where t.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                          where t.ID_Chambre == 1
                                          select t).ToList();

                if (litdispo3.Count != 0)
                {
                    idlitCombox.DataContext = litdispo3;
                    MessageBox.Show("Il ne reste que des chambres semi-privées dans ce département. Vous pouvez choisir une chambre privée sans frais supplémentaire!");
                }
                else
                {


                    if (((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 2)  //choix(2) privée(1) pleine
                    {

                        List<tblLit> litremplacement = (from g in hos.tblLits
                                                        where g.ID_Adm == null
                                                        where g.ID_Chambre == 3
                                                        select g).ToList();
                        if (litremplacement.Count != 0)
                        {
                            idlitCombox.DataContext = litremplacement;
                            MessageBox.Show("Il n'y a plus de lit dans une chambre privée de disponible dans le département sélectionné. Nous vous invitons à choisir un lit dans une chambre standard.");
                        }
                        else
                        {
                            if (((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 2) //choix(2) département plein
                            {
                                List<tblLit> litdispo2 = (from q in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                                          where q.ID_Adm == null
                                                          select q).ToList();
                                idlitCombox.DataContext = litdispo2;
                                MessageBox.Show("Il ne reste plus de lits dans ce département. Vous pouvez sélectionner un lit dans un autre département.");
                            }
                        }
                    }
                }
            }             
           
            #endregion
           //choix(1)
           #region
            if ((litdispo.Count == 0) && ((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 1) //choix(1) pleine
            {
               List<tblLit> litdispo2 = (from q in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                         where q.ID_Adm == null
                                         where q.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                         where q.ID_Chambre == 2
                                         select q).ToList();

               if (litdispo2.Count != 0)
               {
                   idlitCombox.DataContext = litdispo2;
                   MessageBox.Show("Il ne reste plus de lits dans une chambre privée. Vous pouvez sélectionner un lit dans une chambre semi-privée.");
               }
               else
               {
                   if (((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 1)  //choix(1) semi privée(2) pleine
                   {

                       List<tblLit> litremplacement = (from g in hos.tblLits
                                                       where g.ID_Adm == null
                                                       where g.ID_Departement == ((tblDepartement)depadmCombox.SelectedItem).ID_Departement
                                                       where g.ID_Chambre == 3
                                                       select g).ToList();
                       if (litremplacement.Count != 0)
                       {
                           idlitCombox.DataContext = litremplacement;
                           MessageBox.Show("Il n'y a plus de lit dans une chambre privée de disponible dans le département sélectionné. Nous vous invitons à choisir un lit dans une chambre standard.");
                       }
                       else
                       {
                           if (((tblChambre)chambreadmCombox.SelectedItem).ID_Type == 1) //choix(1) département plein
                           {
                               List<tblLit> litdispo5 = (from q in ((tblDepartement)depadmCombox.SelectedItem).tblLits
                                                         where q.ID_Adm == null
                                                         select q).ToList();
                               idlitCombox.DataContext = litdispo5;
                               MessageBox.Show("Il ne reste plus de lits dans ce département. Vous pouvez sélectionner un lit dans un autre département.");
                           }
                       }
                   }
               }
 
            }



           #endregion







       }



       



  
    }
}
