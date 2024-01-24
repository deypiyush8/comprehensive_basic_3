package org.example;

import java.util.Scanner;

public class IT_Calculator {
    public static void main(String[] args) {
        // Create variables
        double taxableIncome, taxPaidPerYear, taxPayablePerMonth;

        // Read TaxableIncome using Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Taxable Income: $");
        taxableIncome = scanner.nextDouble();

        // Calculate tax rates and tax amounts
        double taxRate;
        if (taxableIncome <= 25000) {
            taxRate = 0;
        } else if (taxableIncome <= 50000) {
            taxRate = 0.1;
        } else if (taxableIncome <= 75000) {
            taxRate = 0.2;
        } else {
            taxRate = 0.3;
        }

        // Calculate tax paid per year and tax payable per month
        taxPaidPerYear = taxableIncome * taxRate;
        taxPayablePerMonth = taxPaidPerYear / 12;

        // Print results
        System.out.println("\nTax Paid Per Year: $" + taxPaidPerYear);
        System.out.println("Tax Payable Per Month: $" + taxPayablePerMonth);

        // Close the scanner
        scanner.close();
    }
}

