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
using System.Data.SqlClient;
using System.Data.OleDb;


namespace NLHospital
{
    /// <summary>
    /// Logique d'interaction pour Patient.xaml
    /// </summary>
    public partial class Patient : Window
    {
        NLHospitalEntities3 hos;
        public Patient()
        {
            InitializeComponent();
        }

        private void quitbutt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            Admission sion = new Admission();
            sion.ShowDialog();
            
        }

        private void clearinfoButt_Click(object sender, RoutedEventArgs e)
        {
            recherchePattxtB.Clear();

            nomaddPattxtB.Clear();
            prenomaddPattxtB.Clear();
            telePattxtB.Clear();
            adressePattxtB.Clear();
            assPattxtB.Clear();
            nomparPattxtB.Clear();
            prenomparPattxtB.Clear();
            teleparPattxtB.Clear();
            datenais.Text = "";
        }

        private void recherchepatButt_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                string findPat = recherchePattxtB.Text;
                List<tblPatient> patientfind = hos.tblPatients.ToList();
                int cnt = 0;
                foreach (tblPatient pf in patientfind)
                    if (pf.Nom == findPat)
                    {
                        MessageBox.Show("Le ID du patient recherché est : " + pf.ID_Patient.ToString());
                        recherchePattxtB.Clear();
                        break;
                    }
                    else
                    {                        
                        cnt++;
                    }
                if (cnt == patientfind.Count)
                {
                    MessageBox.Show(findPat + " est un nom de patient invalide. Veuillez vérifier l'orthographe et réessayer.");
                }

            }
            catch (Exception z)
            {
                MessageBox.Show(z.Message);
            }
            finally
            {
                recherchePattxtB.Clear();
            }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            hos = new NLHospitalEntities3();
        }
         
        private void creepatButt_Click(object sender, RoutedEventArgs e)
        {
            try
            {
                tblPatient newpat = new tblPatient();
                newpat.Nom = nomaddPattxtB.Text;
                newpat.Prenom = prenomaddPattxtB.Text;
                newpat.Telephone = telePattxtB.Text;
                newpat.Adresse = adressePattxtB.Text;
                if (assPattxtB.Text == "")
                {
                    newpat.Assurance = null;
                }
                else
                {
                    newpat.Assurance = assPattxtB.Text;
                }
                newpat.Nom_Parent = nomparPattxtB.Text;
                newpat.Prenom_Parent = prenomparPattxtB.Text;
                newpat.Telephone_Parent = teleparPattxtB.Text;
                newpat.DateNaissance = Convert.ToDateTime(datenais.Text);

                hos.tblPatients.AddObject(newpat);
                hos.SaveChanges();
                MessageBox.Show("Nouveau patient ajouté avec succès! Le ID du nouveau patient est : " + newpat.ID_Patient.ToString());
            }
            catch (Exception z)
            {
                MessageBox.Show(z.Message);
            }
            finally
            {
                nomaddPattxtB.Clear();
                prenomaddPattxtB.Clear();
                telePattxtB.Clear();
                adressePattxtB.Clear();
                assPattxtB.Clear();
                nomparPattxtB.Clear();
                prenomparPattxtB.Clear();
                teleparPattxtB.Clear();
                datenais.Text = "";
            }
        }
            
            
                            
            
            

        }
    }

