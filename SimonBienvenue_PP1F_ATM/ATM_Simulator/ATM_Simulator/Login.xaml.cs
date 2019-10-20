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
using System.Windows.Navigation;
using System.Windows.Shapes;
using GuichetClasse;
using System.IO;

namespace ATM_Simulator
{
    /// <summary>
    /// Logique d'interaction pour MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public static GestionnaireGuichet gest = new GestionnaireGuichet();
        public static Client c = new Client();
        public static Banque b = new Banque();        
        
        int loginAttempts = 0;
        string pwMaster = "D001";
        string unMaster = "Korben Dallas";
        string nom;
        string nip;
        public static bool offline = false;
        
        

        public MainWindow()
        {            
            InitializeComponent();
        }

        private void accueilEXIT_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }

        private void accueilOK_Click(object sender, RoutedEventArgs e)
        {           
            if (saisitNIP.Password == pwMaster && saisitNom.Text == unMaster)
            {
                saisitNIP.Clear();
                saisitNom.Clear();
                Superviseur super = new Superviseur();
                super.ShowDialog();
            }
            else
            {
                if (offline)
                {
                    MessageBox.Show("Le guichet est présentement OFFLINE. Veuillez revenir plus tard.");
                    saisitNIP.Clear();
                    saisitNom.Clear();

                }
                nom = saisitNom.Text;
                nip = saisitNIP.Password;
                gest.LireClients();
                gest.ValiderUtilisateur(nom, nip);
                if (gest.ValiderUtilisateur(nom, nip))
                {
                    c.NumeroNIP = nip;
                    c.Nom = nom;
                    saisitNIP.Clear();
                    saisitNom.Clear();
                    Guichet guichet = new Guichet();
                    guichet.ShowDialog();

                }
                else
                {
                    saisitNIP.Clear();
                    saisitNom.Clear();

                    if (!offline && saisitNIP.IsEnabled == true && saisitNom.IsEnabled == true)
                    {
                        loginAttempts++;
                        string count = loginAttempts.ToString();
                        if (loginAttempts == 3)
                        {
                            MessageBox.Show("Trop de tentatives infructueuse. Veuillez communiquer avec votre service banquaire.", "Better luck next time! Essaie " + count + "/3");
                            saisitNIP.IsEnabled = false;
                            saisitNom.IsEnabled = false;
                        }
                        else
                        {                            
                            MessageBox.Show("Le nom d'utilisateur et/ou le numéro d'identification personnel est/sont invalide(s). Veuillez réessayer.", "Essaie " + count + "/3");
                        }
                    }

                }

            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            b.RemplirGuichet();
            if (offline)
            {
                if (saisitNIP.Password != pwMaster && saisitNom.Text != unMaster)
                {
                    MessageBox.Show("Le guichet est présentement OFFLINE. Veuillez revenir plus tard. ");
                }
            }

        }

        }
    }

