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

namespace MultiLocation
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

        private void locationButt_Click(object sender, RoutedEventArgs e)
        {
            
            LocationWindow locat = new LocationWindow();
            locat.ShowDialog();
        }

        private void paiementButt_Click(object sender, RoutedEventArgs e)
        {
            
            PaiementWindow paiem = new PaiementWindow();
            paiem.ShowDialog();
        }

        private void quitButt_Click(object sender, RoutedEventArgs e)
        {
            Environment.Exit(0);
        }
    }
}
