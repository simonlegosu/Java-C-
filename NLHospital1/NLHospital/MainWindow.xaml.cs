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

namespace NLHospital
{
    /// <summary>
    /// Logique d'interaction pour MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void loginadmButt_Click(object sender, RoutedEventArgs e)
        {
            Administrateur adm = new Administrateur();
            adm.ShowDialog();
        }

        private void loginmedButt_Click(object sender, RoutedEventArgs e)
        {
            Medecin med = new Medecin();
            med.ShowDialog();
        }

        private void loginPrepButt_Click(object sender, RoutedEventArgs e)
        {
            Admission sion = new Admission();
            sion.ShowDialog();
        }

        private void quitButt_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
