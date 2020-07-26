package com.practice;

public class Main extends Bank {

    public static void main(String[] args) {
        int option = 1; //variable for the initial and later user input
        int option2; //variable for the second input
        //Create a new Bank instance
        Bank bank = new Bank();
        while (option != 0) {
            //Asks the user to select either their Checking or Savings account
            option = selectBankAccount();
            //If Checking is selected, checks the following options afterwards
            //1 = deposit, 2 = withdraw, 3 = check balance, 4 = transfer money
            if (option == 1) {
                option2 = operationInput();
                if (option2 == 1) {
                    bank.Deposit(0);
                }
                if (option2 == 2) {
                    bank.Withdraw(0);
                }
                if (option2 == 3) {
                    bank.getBalance(0);
                }
                if (option2 == 4) {
                    bank.transferMoney(0);
                }
            }
            //If Savings is selected, checks the following options afterwards
            //1 = deposit, 2 = withdraw, 3 = check balance, 4 = transfer money
            if (option == 2) {
                option2 = operationInput();
                if (option2 == 1) {
                    bank.Deposit(1);
                }
                if (option2 == 2) {
                    bank.Withdraw(1);
                }
                if (option2 == 3) {
                    bank.getBalance(1);
                }
                if (option2 == 4) {
                    bank.transferMoney(1);
                }
            }
            //If Transfer is selected, checks the following options afterwards
            //3 = check balance, 4 = transfer money
            if (option == 3) {
                option2 = operationInput();
                if (option2 == 1 || option2 == 2) {
                    System.out.println("Cannot perform a deposit or withdraw with a transfer account, please try again.");
                }
                else if (option2 == 3) {
                    bank.getBalance(2);
                }
                else if (option2 == 4) {
                    bank.transferMoney(2);
                }
            }
        }
    }
}
