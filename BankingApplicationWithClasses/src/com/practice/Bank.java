package com.practice;

import java.text.NumberFormat;
import java.util.Scanner;

public class Bank {
    private static double[] balance = {0.0, 0.0, 0.0};

    public static int selectBankAccount() {
        //Asks the user to select which account they would like to access
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please select a Bank account: Checking (1), Savings (2), Transfer (3), Terminate (0): ");
        int option = scanner.nextInt();
        if(option<0 || option>3) //Returns an error message if the input is invalid
            System.out.println("Invalid input, please try again.");
        return option; //returns the user's input
    }

    public static int operationInput() {
        //Asks the user to select which operation they would like to perform
        Scanner scanner4 = new Scanner(System.in);
        System.out.print("Please select an operation: Deposit (1), Withdraw (2), Check Balance (3), Transfer Money (4), Terminate (0): ");
        System.out.println("NOTE: You can only transfer money and check the balance for a transfer account!");
        int option2 = scanner4.nextInt();
        if(option2<0 || option2>4) //Returns an error message if the input is invalid
            System.out.println("Invalid input, please try again.");
        return option2; //returns the user's input
    }

    public static void Deposit(int input){
        //Asks the user how much they would like to deposit
        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Please enter the amount you would like to Deposit (Example format: 16.32 = $16.32): ");
        double deposit = scanner2.nextDouble();
        if (deposit < 1.00) { //Returns an error message if the input is less than $1
            System.out.println("You must deposit at least $1, please try again.");
        } else {
            balance[input] = balance[input] + deposit;
            System.out.println("Deposit Successful.");
        }
    }

    public static void Withdraw(int input){
        //Asks the user how much they would like to withdraw
        Scanner scanner3 = new Scanner(System.in);
        System.out.print("Please enter the amount you like to Withdraw (Example format: 17.55 = $17.55): ");
        double withdraw = scanner3.nextDouble();
        if (withdraw > balance[input]) { //Returns an error message if the withdraw request is greater than the balance
            System.out.println("You do not have enough balance to withdraw this amount, please try again.");
        } else {
            balance[input] = balance[input] - withdraw;
            System.out.println("Withdraw Successful.");
        }
    }

    public static void getBalance(int input){
        //prints the balance of the selected bank account
        String currency = NumberFormat.getCurrencyInstance().format(balance[input]);
        System.out.println("Your current balance is " + currency + ".");
    }

    public static void transferMoney(int input){
        //function that transfers money from one account to another
        //first checks if the account the user wants to transfer from has no balance
        if(balance[input] == 0.0){
            System.out.println("You cannot perform a transfer with a $0 balance, please deposit some money first.");
        }
        else {
            Scanner scanner5 = new Scanner(System.in);
            System.out.print("Please select the account you would like to transfer to (1 for Checkings, 2 for Savings, 3 for Transfer): ");
            int input2 = scanner5.nextInt();
            if (input2-1 == input) //checks if the account they want to transfer to is the same account they are accessing
                System.out.println("You cannot transfer money to the same account, please try again.");
            else if (input2 == 1) {
                Scanner scanner6 = new Scanner(System.in);
                System.out.print("Please enter the amount you would like to transfer to your Checkings account (Example format: 17.55 = $17.55): ");
                double input3 = scanner6.nextDouble();
                if(input3 > balance[input]){ //checks if the requested transfer amount is greater than the balance
                    System.out.println("You do not have enough to transfer this amount, please try again.");
                }
                else { //amount is removed the accessed account and increased in the requested account
                    balance[input] = balance[input] - input3;
                    balance[input2-1] = balance[input2-1] + input3;
                    System.out.println("Transfer Successful.");
                }
            } else if (input2 == 2) {
                Scanner scanner6 = new Scanner(System.in);
                System.out.print("Please enter the amount you would like to transfer to your Savings account (Example format: 17.55 = $17.55): ");
                double input3 = scanner6.nextDouble();
                if(input3 > balance[input]){
                    System.out.println("You do not have enough to transfer this amount, please try again.");
                }
                else {
                    balance[input] = balance[input] - input3;
                    balance[input2-1] = balance[input2-1] + input3;
                    System.out.println("Transfer Successful.");
                }
            } else if (input2 == 3) {
                Scanner scanner6 = new Scanner(System.in);
                System.out.print("Please enter the amount you would like to transfer to your Transfer account (Example format: 17.55 = $17.55): ");
                double input3 = scanner6.nextDouble();
                if(input3 > balance[input]){
                    System.out.println("You do not have enough to transfer this amount, please try again.");
                }
                else {
                    balance[input] = balance[input] - input3;
                    balance[input2-1] = balance[input2-1] + input3;
                    System.out.println("Transfer Successful.");
                }
            }
        }
    }
}
