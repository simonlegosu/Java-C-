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
    /// Logique d'interaction pour Guichet.xaml
    /// </summary>
    public partial class Guichet : Window
    {
        int pointPlus = 0;
        int deciTrack = 0;
        bool valid = true;

        public Guichet()
        {
            InitializeComponent();

        }

        private void quitterGuichet_Click(object sender, RoutedEventArgs e)
        {
            
            this.Close();
           
        }

        private void number1_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "1";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }

        }

        private void number2_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "2";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number3_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "3";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number4_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "4";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number5_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text += "5";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number6_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "6";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number7_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "7";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number8_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "8";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number9_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }
            saisitGuichet.Text = saisitGuichet.Text + "9";
            if (pointPlus == 0)
            {
                numberPoint.IsEnabled = true;
            }
            else
            {
                deciTrack++;
                numberPoint.IsEnabled = false;
                if (deciTrack == 2)
                {
                    number1.IsEnabled = false;
                    number2.IsEnabled = false;
                    number3.IsEnabled = false;
                    number4.IsEnabled = false;
                    number5.IsEnabled = false;
                    number6.IsEnabled = false;
                    number7.IsEnabled = false;
                    number8.IsEnabled = false;
                    number9.IsEnabled = false;
                    number0.IsEnabled = false;
                }
            }
        }

        private void number0_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text == "" && valid == false)
            {
                valid = true;
            }

            if (saisitGuichet.Text == "0" || saisitGuichet.Text == "0.0")
            {
                ClearAll();
                saisitGuichet.Text = "0";
            }
            else
            {
                saisitGuichet.Text = saisitGuichet.Text + "0";
                if (pointPlus == 0)
                {
                    numberPoint.IsEnabled = true;
                }
                else
                {
                    deciTrack++;
                    numberPoint.IsEnabled = false;
                    if (deciTrack == 2)
                    {
                        number1.IsEnabled = false;
                        number2.IsEnabled = false;
                        number3.IsEnabled = false;
                        number4.IsEnabled = false;
                        number5.IsEnabled = false;
                        number6.IsEnabled = false;
                        number7.IsEnabled = false;
                        number8.IsEnabled = false;
                        number9.IsEnabled = false;
                        number0.IsEnabled = false;
                    }
                }
            }
        }

        private void numberPoint_Click(object sender, RoutedEventArgs e)
        {
            if (saisitGuichet.Text != "")
            {
                saisitGuichet.Text = saisitGuichet.Text + ".";
                pointPlus++;
                numberPoint.IsEnabled = false;
            }
            else
            {
                MessageBox.Show("Veuillez entrer au moins un chiffre avant d'utiliser la touche 'Point'", "Erreur!");
            }
        }

        private void clear_Click(object sender, RoutedEventArgs e)
        {
            ClearAll();
        }

        private void submitGuichet_Click(object sender, RoutedEventArgs e)
        {
          try
           {

                if (depotRadio.IsChecked == false && retraitRadio.IsChecked == false && transfertRadio.IsChecked == false && paiementRadio.IsChecked == false)
                {
                    MessageBox.Show("Veuillez choisir le type de transaction que vous désirez effectuer.");
                    valid = false;
                    ClearAll();
                }

                if (depotRadio.IsChecked == true & chequeRadio.IsChecked == true)
                {
                    double montantDepCh = double.Parse(saisitGuichet.Text);
                    if (valid)
                    {
                        if (MainWindow.gest.DepotCheque(montantDepCh, MainWindow.c.NumeroNIP) == false)
                        {
                            MessageBox.Show("Une erreur bizarre s'est produite.", "L'opération a échoué.");
                            ClearAll();
                        }
                        else
                        {
                            MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'C'), "Le depot a marché");
                            ClearAll();
                        }
                    }
                }

                if (depotRadio.IsChecked == true & epargneRadio.IsChecked == true)
                {
                    double montantDepEp = Convert.ToDouble(saisitGuichet.Text);
                    if (valid)
                    {
                        if (MainWindow.gest.DepotEpargne(montantDepEp, MainWindow.c.NumeroNIP) == false)
                        {
                            MessageBox.Show("Une erreur bizarre s'est produite.", "L'opération a échoué.");
                            ClearAll();
                        }
                        else
                        {
                            MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'E'), "Le depot a marché");
                            ClearAll();
                        }
                    }
                }




                if (retraitRadio.IsChecked == true & chequeRadio.IsChecked == true)
                {
                    double montantRetCh = Convert.ToDouble(saisitGuichet.Text);

                    if (montantRetCh > Compte.retraitMaximum)
                    {
                        MessageBox.Show("Le retrait maximale est de 1000$.", "Erreur!");
                        ClearAll();
                        valid = false;
                    }

                    if (montantRetCh % 10 != 0)
                    {
                        MessageBox.Show("Ce guichet remet des billets de 10$. Veuillez saisir un multiple de 10 et réessayez!");
                        ClearAll();
                        valid = false;
                    }


                    if (montantRetCh > MainWindow.b.CashGuichet)
                    {
                        MessageBox.Show("Ya pas assez d'argent dans le guichet. Vous pouvez présentement retirer jusqu'à " + MainWindow.b.ToString());
                        ClearAll();
                        valid = false;
                    }

                    if (valid)
                    {

                        if (MainWindow.gest.RetraitCheque(montantRetCh, MainWindow.c.NumeroNIP) == false)
                        {
                            MessageBox.Show("Fonds insuffisants pour compléter la transaction.", "L'opération a échoué.");
                            ClearAll();
                        }
                        else
                        {
                            MainWindow.b.CashGuichet -= montantRetCh;
                            MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'C'), "Le retrait a marché");
                            ClearAll();
                        }
                    }

                }

                if (retraitRadio.IsChecked == true & epargneRadio.IsChecked == true)
                {
                    double montantRetEp = Convert.ToDouble(saisitGuichet.Text);
                    if (montantRetEp > Compte.retraitMaximum)
                    {
                        MessageBox.Show("Le retrait maximale est de 1000$.", "Erreur!");                       
                        valid = false;
                        ClearAll();
                    }

                    if (montantRetEp % 10 != 0)
                    {
                        MessageBox.Show("Ce guichet remet des billets de 10$. Veuillez saisir un multiple de 10 et réessayez!");                        
                        valid = false;
                        ClearAll();
                    }


                    if (montantRetEp > MainWindow.b.CashGuichet)
                    {
                        MessageBox.Show("Ya pas assez d'argent dans le guichet. Vous pouvez présentement retirer jusqu'à " + MainWindow.b.ToString());                        
                        valid = false;
                        ClearAll();
                    }


                    if (valid)
                    {
                        if (MainWindow.gest.RetraitEpargne(montantRetEp, MainWindow.c.NumeroNIP) == false)
                        {
                            MessageBox.Show("Fonds insuffisants pour compléter la transaction.", "L'opération a échoué.");
                            ClearAll();
                        }
                        else
                        {
                            MainWindow.b.CashGuichet -= montantRetEp;
                            MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'E'), "Le retrait à marché");
                            ClearAll();
                        }
                    }
                }
                ////             TRANSFERT TRANSFERT TRANSFERTTRANSFERTTRANSFERT
                if (transfertRadio.IsChecked == true)
                {

                    if (chequeRadio.IsChecked == true)
                    {

                        double montantTrCh = Convert.ToDouble(saisitGuichet.Text);
                        if (montantTrCh > Compte.montantTransfertMaximum)
                        {                            
                            MessageBox.Show("Le montant maximal de transfert est de 100 000$.", "Erreur!");
                            ClearAll();
                            valid = false;
                        }


                        if (valid)
                        {
                            if (MainWindow.gest.TransfertFonds(montantTrCh, MainWindow.c.NumeroNIP, 'C', 'E') == false)
                            {
                                MessageBox.Show("Vous n'avez pas les fonds nécessaires dans votre compte Chèques pour effectuer le transfert!", "L'opération a échoué.");
                                ClearAll();
                            }
                            else
                            {
                                MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'E') + MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'C'), "Transfert réussit!");
                                ClearAll();
                            }
                        }
                    }




                    if (epargneRadio.IsChecked == true)
                    {
                        double montantTrEp = Convert.ToDouble(saisitGuichet.Text);
                        if (montantTrEp > Compte.montantTransfertMaximum)
                        {
                            
                            MessageBox.Show("Le montant maximal de transfert est de 100 000$.", "Erreur!");
                            ClearAll();
                            valid = false;
                        }


                        if (valid)
                        {
                            if (MainWindow.gest.TransfertFonds(montantTrEp, MainWindow.c.NumeroNIP, 'E', 'C') == false)
                            {
                                MessageBox.Show("Vous n'avez pas les fonds nécessaires dans votre compte Épargne pour effectuer le transfert!", "L'opération a échoué.");
                                ClearAll();

                            }
                            else
                            {
                                MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'C') + MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'E'), "Transfert réussit!");
                                ClearAll();
                            }
                        }
                    }
                }
                // PAIEMENT FACTURE PAIEMENT FACTURE PAIEMENT FACTURE PAIEMENT FACTURE PAIEMENT FACTURE 
                if (paiementRadio.IsChecked == true)
                {
                    if (epargneRadio.IsChecked == true)
                    {
                        MessageBox.Show("Veuillez sélectionner votre compte Chèques pour effectuer cette opération", "L'opération a échoué.");
                        ClearAll();
                    }

                    if (chequeRadio.IsChecked == true)
                    {
                        double montantPaiement = Convert.ToDouble(saisitGuichet.Text);
                        if (montantPaiement > Cheque.montantFactureMaximum)
                        {
                            
                            MessageBox.Show("Le montant maximal de paiement de facture est de 10 000$.", "Erreur!");
                            ClearAll();
                            valid = false;
                        }

                        if (valid)
                        {
                            if (MainWindow.gest.PaiementFacture(montantPaiement, MainWindow.c.NumeroNIP))
                            {
                                MessageBox.Show(MainWindow.gest.AfficheSoldeCompte(MainWindow.c.NumeroNIP, 'C'), "Paiement de facture réussit!");
                                ClearAll();
                            }
                            else
                            {
                                MessageBox.Show("Fonds insuffisants pour compléter la transaction.", "L'opération a échoué.");
                                ClearAll();
                            }
                        }
                    }
                

                }
            }
            catch (Exception)
           {
                
                MessageBox.Show("Je ne comprends pas pourquoi mon code ne peut prendre des nombres décimaux...");
                ClearAll();
                valid = false;
           }
        }

        private void Window_Loaded(object sender, RoutedEventArgs e)
        {
            if (MainWindow.b.CashGuichet == 0)
            {
                retraitRadio.IsEnabled = false;
            }
            MainWindow.gest.LireComptes();
        }

        private void ClearAll()
        {
            valid = true;
            deciTrack = 0;
            pointPlus = 0;
            saisitGuichet.Clear();
            numberPoint.IsEnabled = true;
            number1.IsEnabled = true;
            number2.IsEnabled = true;
            number3.IsEnabled = true;
            number4.IsEnabled = true;
            number5.IsEnabled = true;
            number6.IsEnabled = true;
            number7.IsEnabled = true;
            number8.IsEnabled = true;
            number9.IsEnabled = true;
            number0.IsEnabled = true;
            submitGuichet.IsEnabled = false;
        }

        private void paiementRadio_Checked(object sender, RoutedEventArgs e)
        {
            chequeRadio.Content = "Payer avec compte Chèques";
            epargneRadio.Content = "Épargne";
            epargneRadio.IsEnabled = false;
        }

        private void transfertRadio_Checked(object sender, RoutedEventArgs e)
        {
            chequeRadio.Content = "Chèques vers Épargne";
            epargneRadio.Content = "Épargne vers Chèques";
            epargneRadio.IsEnabled = true;
        }

        private void retraitRadio_Checked(object sender, RoutedEventArgs e)
        {
            chequeRadio.Content = "Chèques";
            epargneRadio.Content = "Épargne";
            epargneRadio.IsEnabled = true;
        }

        private void depotRadio_Checked(object sender, RoutedEventArgs e)
        {
            chequeRadio.Content = "Chèques";
            epargneRadio.Content = "Épargne";
            epargneRadio.IsEnabled = true;
        }

        private void saisitGuichet_TextChanged(object sender, TextChangedEventArgs e)
        {
            submitGuichet.IsEnabled = true;

        }
        }
    }

