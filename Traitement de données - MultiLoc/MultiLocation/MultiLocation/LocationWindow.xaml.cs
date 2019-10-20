using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using System.Data.Entity;


namespace MultiLocation
{
    /// <summary>
    /// Logique d'interaction pour LocationWindow.xaml
    /// </summary>
    public partial class LocationWindow : Window
    {
        MultiLocEntities11 maloc;
        public LocationWindow()
        {
            InitializeComponent();
            datedebutAjouttxtBox.Text = DateTime.Now.ToString();
            datefirstAjouttxtBox.Text = DateTime.Now.Date.AddDays(10).ToString();
        }

        private void quititButt_Click(object sender, RoutedEventArgs e)
        {
            this.Close();
        }

        private void clearAjoutButt_Click(object sender, RoutedEventArgs e)
        {
            datedebutAjouttxtBox.Clear();
            datefirstAjouttxtBox.Clear();
            montmensAjouttxtBox.Clear();
            nbmensAjouttxtB.Clear();
            nivAjouttxtBox.Clear();
            idclientAjouttxtBox.Clear();
            termeAjouttxtBox.Clear();
        }
        
        private void saveAjoutButt_Click(object sender, RoutedEventArgs e)
        {
            tableLocation newloc = new tableLocation();
            try
            {
               
                newloc.DateDebut = DateTime.Now;
                newloc.DatePremierPaiement = DateTime.Now.Date.AddDays(10);
                newloc.MontantMensuel = Convert.ToInt32(montmensAjouttxtBox.Text);
                newloc.NombrePaiementsMensuel = Convert.ToInt32(nbmensAjouttxtB.Text);
                newloc.NIV = nivAjouttxtBox.Text;
                newloc.ID_Client = Convert.ToInt32(idclientAjouttxtBox.Text);
                newloc.ID_Terme = Convert.ToInt32(termeAjouttxtBox.Text);

                
                maloc.tableLocations.AddObject(newloc);
                maloc.SaveChanges();
                

            }
            catch (Exception z)
            {
                MessageBox.Show(z.Message);
            }
            finally 
            {
                string idloc = newloc.ID_Location.ToString();
                            
                string message = ("Ajout réussit! ID de la nouvelle location : "+ idloc);
                montmensAjouttxtBox.Clear();
                nbmensAjouttxtB.Clear();
                nivAjouttxtBox.Clear();
                idclientAjouttxtBox.Clear();
                termeAjouttxtBox.Clear();
                if (idloc != "0")
                {
                MessageBox.Show(message, "Locations");
                }
                else
                {
                    MessageBox.Show("Échec de l'opération.");
                }
            }

        }

        private void saveModButt_Click(object sender, RoutedEventArgs e)
        {
            tableLocation modloc = (tableLocation)idlocCombox.SelectedItem;
            try
            {            
                modloc.DateDebut = Convert.ToDateTime(datedebutModtextB.Text); //ok
                modloc.DatePremierPaiement = Convert.ToDateTime(datefirstModtextB.Text); //ok
                modloc.MontantMensuel = Convert.ToInt32(montmensModtextB.Text); //ok
                modloc.NombrePaiementsMensuel = Convert.ToInt32(nbmensModtextB.Text);
                modloc.NIV = nivModtextB.Text;                              //ok
                modloc.ID_Client = Convert.ToInt16(idCliModtextB.Text);   //ok
                modloc.ID_Terme = Convert.ToInt16(termeModtextB.Text);       //ok             

                maloc.SaveChanges();
            }
            catch (Exception z)
            {
                MessageBox.Show(z.Message);
            }
            finally
            {
                string idloc = modloc.ID_Location.ToString();
                string message = ("La location ID " +idloc+ " a été modifiée. Vous pouvez poursuivre vos opérations.");
                MessageBox.Show(message);
            }

        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            maloc = new MultiLocEntities11();            
            idlocCombox.DataContext = maloc.tableLocations;
            
        }

        private void idlocCombox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            if ((tableLocation)idlocCombox.SelectedItem == null)
            {
                this.Close();
            }
            else
            {
                datedebutModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).DateDebut.ToString();
                datefirstModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).DatePremierPaiement.ToString();
                montmensModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).MontantMensuel.ToString();
                nbmensModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).NombrePaiementsMensuel.ToString();
                nivModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).NIV;
                idCliModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).ID_Client.ToString();
                termeModtextB.Text = ((tableLocation)idlocCombox.SelectedItem).ID_Terme.ToString();
            }
        }


    }
}
