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
    /// Logique d'interaction pour Administrateur.xaml
    /// </summary>
    public partial class Administrateur : Window
    {
        NLHospitalEntities3 hos;
        public Administrateur()
        {
            InitializeComponent();
        }

        private void supprimermdButt_Click(object sender, RoutedEventArgs e)
        {
            tblMedecin medDel = (tblMedecin)meddeleteListBox.SelectedItem;
            string nomdel =  medDel.Prenom +" "+ medDel.Nom;
            hos.tblMedecins.DeleteObject(medDel);
            hos.SaveChanges();
            MessageBox.Show("Le médecin " + nomdel + " a été supprimé.");
        }

        private void quitButt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void quitbutt_Click_1(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void ajoutMedbutt_Click(object sender, RoutedEventArgs e)
        {
            tblMedecin newmed = new tblMedecin();
            try
            {
                newmed.Nom = nommedTxtB.Text;
                newmed.Prenom = prenommedTxtB.Text;
                newmed.ID_Departement = ((tblDepartement)departajmedCombox.SelectedItem).ID_Departement;
                newmed.DateEmbauche = Convert.ToDateTime(dateembauche.Text);
                newmed.Telephone = telemedTxtB.Text;
                newmed.Adresse = adrmedTxtB.Text;

                hos.tblMedecins.AddObject(newmed);
                hos.SaveChanges();

                MessageBox.Show("Nouveau médecin ajouté avec succès! ID Medecin : " + newmed.ID_Medecin.ToString());

            }
            catch (Exception z)
            {
                MessageBox.Show(z.Message);
            }
            finally
            {
                
                nommedTxtB.Clear();
                prenommedTxtB.Clear();
                dateembauche.Text = "";
                telemedTxtB.Clear();
                adrmedTxtB.Clear();
            }

        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            hos = new NLHospitalEntities3();
            meddeleteListBox.DataContext = hos.tblMedecins;
            departajmedCombox.DataContext = hos.tblDepartements;
        }



    }
}
