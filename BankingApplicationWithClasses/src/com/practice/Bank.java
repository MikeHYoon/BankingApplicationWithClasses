package com.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Bank {
    private static double[] balance = {0.0, 0.0};

    public static int selectBankAccount() {
        //Asks the user to select which account they would like to access
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select a Bank account: Checking (1), Savings (2), Terminate (0): ");
        int option = scanner.nextInt();
        if(option<0 || option>2) //Returns an error message if the input is invalid
            System.out.println("Invalid input, please try again.");
        return option; //returns the user's input
    }

    public static int operationInput() {
        //Asks the user to select which operation they would like to perform
        Scanner scanner4 = new Scanner(System.in);
        System.out.print("Please select an operation: Deposit (1), Withdraw (2), Check Checking Balance (3), Terminate (0): ");
        int option2 = scanner4.nextInt();
        if(option2<0 || option2>3) //Returns an error message if the input is invalid
            System.out.println("Invalid input, please try again.");
        return option2; //returns the user's input
    }

    public static void Deposit(int input){
        //Asks the user how much they would like to deposit
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Please enter the amount you would like to Deposit: (Example format: 16.32 = $16.32): ");
        double deposit = scanner2.nextDouble();
        if (deposit < 1.00) { //Returns an error message if the input is less than $1
            System.out.println("You must deposit at least $1, please try again");
        } else {
            balance[input] = balance[input] + deposit;
            System.out.println("Deposit Successful");
        }
    }

    public static void Withdraw(int input){
        //Asks the user how much they would like to withdraw
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Please enter the amount you like to Withdraw: (Example format: 17.55 = $17.55): ");
        double withdraw = scanner3.nextDouble();
        if (withdraw > balance[input]) { //Returns an error message if the withdraw request is greater than the balance
            System.out.println("You do not have enough balance to withdraw this amount, please try again.");
        } else {
            balance[input] = balance[input] - withdraw;
            System.out.println("Withdraw Successful");
        }
    }

    public static void getBalance(int input){
        //prints the balance of the selected bank account
        String currency = NumberFormat.getCurrencyInstance().format(balance[input]);
        System.out.println("Your current Checking balance is " + currency);
    }
}
