package com.pluralsight;

public class Transactions {

    private String date;
    private String time;
    private String description;
    private String vendor;
    private double amount;

    //shows how it will print out the info in the CSV file
    public Transactions(String date, String time, String description, String vendor, double amount) {
        this.date = date;
        this.time = time;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String toCSV() {
        return date + "|" + time + "|" + description + "|" + vendor + "|" + amount;
    }

    // this will help us build a transaction from a line in the CSV
    public static Transactions fromCSV(String csvLine) {
        String[] parts = csvLine.split("\\|");

        return new Transactions(
                parts[0],
                parts[1],
                parts[2],
                parts[3],
                Double.parseDouble(parts[4])
        );
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
