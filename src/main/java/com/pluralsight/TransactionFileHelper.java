package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionFileHelper {

   //we are going to name the csv file here so we can move it around and reassign it later
    private static final String NameFile  = "transactions.csv";

    public static List<Transactions> readTransactions () {
        List<Transactions> transactions = new ArrayList<>();


        try (BufferedReader coach = new BufferedReader(new FileReader(NameFile))) {
            String line;
            while ((line = coach.readLine()) != null) {
                transactions.add(Transactions.fromCSV(line));
            }

        } catch (IOException e) {
            System.out.println("Error reading transaction: " + e.getMessage());
        }


        return transactions;

    }

            public static void saveTransactions (Transactions transactions) {
            try (PrintWriter leo = new PrintWriter(new FileWriter(NameFile, true))) {
                leo.println(transactions.toCSV());
            } catch (IOException e) {
                System.out.println("Error saving transaction: ");

            }

        }
    }

