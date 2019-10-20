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
    /// Logique d'interaction pour Medecin.xaml
    /// </summary>
    public partial class Medecin : Window
    {
        NLHospitalEntities3 hos;
        public Medecin()
        {
            InitializeComponent();
        }

        private void quitButt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void congeButt_Click(object sender, RoutedEventArgs e)
        {
            tblPatient patLit = ((tblAdmission)patconCombox.SelectedItem).tblPatient;
            tblAdmission conPat = (tblAdmission)patconCombox.SelectedItem;
            conPat.DateConge = Convert.ToDateTime(dateCongeDP.Text);
            tblLit conLit = ((tblAdmission)patconCombox.SelectedItem).tblLit;
            conLit.ID_Adm = null;
            patLit.Vacancy = false;

            hos.SaveChanges();
            DateTime start = conPat.DateAdmin;
            DateTime end = Convert.ToDateTime(dateCongeDP.Text);
            TimeSpan difference = end - start;
            MessageBox.Show("La date de congé a été assignée! Le patient aura séjourné pendant "+difference.TotalDays.ToString()+" jours.");
            this.Close();
            Medecin med = new Medecin();
            med.ShowDialog();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            hos = new NLHospitalEntities3();
            List<tblAdmission> congePat  = (from b in hos.tblAdmissions
                                     where b.DateConge == null
                                     select b).ToList();

            patconCombox.DataContext = congePat;
        }


        
    }
}
