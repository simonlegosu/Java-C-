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
using System.Data;
using System.Data.SqlClient;

namespace MultiLocation
{
    /// <summary>
    /// Logique d'interaction pour PaiementWindow.xaml
    /// </summary>
    public partial class PaiementWindow : Window
    {
        MultiLocEntities11 maloc;
        public PaiementWindow()
        {
            InitializeComponent();
        }

        private void quitPaiebutt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            maloc = new MultiLocEntities11();
            listPaiement.DataContext = maloc.tablePaiements;
            datepaietxtBox.Text = DateTime.Now.ToString();
        }

        private void listPaiement_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if ((tablePaiement)listPaiement.SelectedItem == null)
            {
                datePaietxtBlo.Text = "";
                montanttxtBlo.Text = "";
                idLoctxtBlo.Text = "";
                idPaietxtBlo.Text = "";
            }
            else
            {
                datePaietxtBlo.DataContext = Convert.ToString(((tablePaiement)listPaiement.SelectedItem).DatePaiement);
                montanttxtBlo.DataContext = Convert.ToString(((tablePaiement)listPaiement.SelectedItem).Montant);
                idLoctxtBlo.DataContext = Convert.ToString(((tablePaiement)listPaiement.SelectedItem).ID_Location);
                idPaietxtBlo.DataContext = Convert.ToString(((tablePaiement)listPaiement.SelectedItem).ID_Paiement);
            }
        }

        private void deletePaiement_Click(object sender, RoutedEventArgs e)
        {
            tablePaiement pDel = (tablePaiement)listPaiement.SelectedItem;
            string idpaiedel = pDel.ID_Paiement.ToString();
            maloc.tablePaiements.DeleteObject(pDel);
            maloc.SaveChanges();
            MessageBox.Show("Le paiement ID #" + idpaiedel + " a été annulé.");
        }

        private void quitefbutt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void clearEFbutt_Click(object sender, RoutedEventArgs e)
        {            
            montanttxtBox.Clear();
            idloctxtBox.Clear();
            idpaiementtxtBox.Clear();
        }

        private void effectPaiebutt_Click(object sender, RoutedEventArgs e)
        {
            bool pogne = true;
            try
            {
                tablePaiement newPai = new tablePaiement();
                newPai.DatePaiement = DateTime.Now;
                newPai.Montant = Convert.ToInt32(montanttxtBox.Text);
                newPai.ID_Location = Convert.ToInt32(idloctxtBox.Text);
                maloc.tablePaiements.AddObject(newPai);
                maloc.SaveChanges();
                
            }
            
            catch (Exception z)
            {
                pogne = false;
                MessageBox.Show(z.Message);
            }
            finally
            {
                montanttxtBox.Clear();
                idloctxtBox.Clear();
                if (pogne)
                {

                    MessageBox.Show("Paiement effectué avec succès!");
                }
                else 
                {
                    MessageBox.Show("Le paiement a échoué. Veuillez vérifier vos entrées de données et réessayez.");
                }

            }

        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
            PaiementWindow paiem = new PaiementWindow();
            paiem.ShowDialog();
        }


    }
}
