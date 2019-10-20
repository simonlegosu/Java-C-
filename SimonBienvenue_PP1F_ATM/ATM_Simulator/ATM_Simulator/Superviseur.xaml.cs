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
using GuichetClasse;

namespace ATM_Simulator
{
    /// <summary>
    /// Logique d'interaction pour Superviseur.xaml
    /// </summary>
    public partial class Superviseur : Window
    {
        public static Banque b = new Banque();
        public Superviseur()
        {
            InitializeComponent();
        }

        private void button5_Click(object sender, RoutedEventArgs e)
        {
            
            this.Close();           
            
        }

        private void printInfo_Click(object sender, RoutedEventArgs e)
        {                       
            MessageBox.Show(MainWindow.gest.ImprimerComptes());
        }

        private void offline_Click(object sender, RoutedEventArgs e)
        {
            if (!MainWindow.offline)
            {
                status.Text = "Le service est OFFLINE.";
                MainWindow.offline = true;
                MessageBox.Show("Le guichet est maintenant hors fonction.");
            }
            else 
            {
                status.Text = "Le service est ONLINE.";
                MainWindow.offline = false;
                MessageBox.Show("Le guichet est maintenant en fonction.");
            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            cashGuichet.Text = MainWindow.b.ToString();            
            MainWindow.gest.LireComptes();
            if (!MainWindow.offline)
            {
                status.Text = "Le service est ONLINE.";
            }
            else
            {
                status.Text = "Le service est OFFLINE.";                
            }
        }

        private void interetEpargne_Click(object sender, RoutedEventArgs e)
        {
            if (MainWindow.gest.PayerEpargne()) 
            {
                MessageBox.Show("L'intérêt de l'épargne a été payé!");
            }
        }

        private void remplirGuichet_Click(object sender, RoutedEventArgs e)
        {
            if (MainWindow.b.RemplirGuichet() == false)
            {
                MessageBox.Show("Le guichet est déjà assez remplit!", "Échec!");
            }
            else
            {
                cashGuichet.Text = MainWindow.b.ToString();
                MessageBox.Show("Vous venez d'ajouter 5000$ au guichet.", "Réussite!");
            }
        }


    }
}
