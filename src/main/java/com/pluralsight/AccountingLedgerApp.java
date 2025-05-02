package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AccountingLedgerApp {

    public static void main(String[] args) {
        //how do I keep this program running until the user exits
        Scanner theScanner = new Scanner(System.in);
        String sn;

        do {

            System.out.println("HOME SCREEN");
            System.out.println("D) Add Deposit");
            System.out.println("P) Make Payment (Debit)");
            System.out.println("L) Ledger");
            System.out.println("X EXIT ");
            System.out.println("please select an option");

            sn = theScanner.nextLine().toUpperCase();


            switch (sn) {
                case "D":
                    System.out.println("Make a deposit");

                    System.out.println("Enter the date (YYYY-MM-DD): ");
                    String depDate = theScanner.nextLine();

                    System.out.println("Enter the time (HH:MM:SS): ");
                    String depTime = theScanner.nextLine();

                    System.out.println("Enter description: ");
                    String depDesc = theScanner.nextLine();

                    System.out.println("Enter vendor: ");
                    String depVendor = theScanner.nextLine();

                    System.out.println("Enter amount: ");
                    double depAmount = Double.parseDouble(theScanner.nextLine());

                    Transactions deposit = new Transactions(depDate, depTime, depDesc, depVendor, depAmount);
                    TransactionFileHelper.saveTransactions(deposit);

                    System.out.println("Deposit saved");
                    break;


                case "P":
                    System.out.println("Make a payment");

                    System.out.println("Enter the date (YYYY-MM-DD): ");
                    String payDate = theScanner.nextLine();

                    System.out.println("Enter the time (HH:MM:SS): ");
                    String payTime = theScanner.nextLine();

                    System.out.println("Enter description: ");
                    String payDesc = theScanner.nextLine();

                    System.out.println("Enter vendor: ");
                    String payVendor = theScanner.nextLine();

                    System.out.println("Enter amount: ");
                    double payAmount = Double.parseDouble(theScanner.nextLine());

                    Transactions payment = new Transactions(payDate, payTime, payDesc, payVendor, payAmount);
                    TransactionFileHelper.saveTransactions(payment);

                    System.out.println("Payment saved");
                    break;

                case "L":
                    System.out.println("View ledger");
                    System.out.println("A) All Transactions");
                    System.out.println("D) Deposits only");
                    System.out.println("P) Payments Only");

                    System.out.println("Select ledger options");
                    String ledgerOption = theScanner.nextLine().toUpperCase();
                    // stored in ledger entry reads the list of transactions from the CSV through the file helper
                    List<Transactions> allTransactions = TransactionFileHelper.readTransactions();

                    if (ledgerOption.equals("A")) {
                        System.out.println("All Transactions:");
                        for (Transactions t : allTransactions) {
                            System.out.println(t.toCSV());
                        }
                    } else if (ledgerOption.equals("D")) {
                        System.out.println("Deposits:");
                        for (Transactions t : allTransactions) {
                            if (t.getAmount() > 0) {
                                System.out.println(t.toCSV());
                            }
                        }
                    } else if (ledgerOption.equals("P")) {
                        System.out.println("Payments: ");
                        for (Transactions t : allTransactions) {
                            if (t.getAmount() < 0) {
                                System.out.println(t.toCSV());
                            }
                        }
                    } else {
                        System.out.println("Invalid ledger option");
                    }

                    break;

                case "X":
                    System.out.println("THANK YOU");
                    break;

                default:
                    System.out.println("Invalid entry");

            }

        } while (!sn.equals("X"));

    }

}




