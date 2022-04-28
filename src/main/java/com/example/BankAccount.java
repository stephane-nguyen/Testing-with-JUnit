package com.example;

public class BankAccount {
    private double balance;
    private double minimumBalance;
    boolean isActive = true; 
    String bankHolderName;

    /* CONSTRUCTORS */
    public BankAccount(double balance, double minimumBalance) {
        this.balance = balance;
        this.minimumBalance = minimumBalance;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public double getMinimumBalance() {
        return this.minimumBalance;
    }
    
    public boolean isActive(){
        return isActive;
    }

    public String getBankHolderName(){
        return this.bankHolderName;
    }

    public void setBankHolderName(String holderName){
        this.bankHolderName = holderName;
    }

    /* METHODS */
    public double withdraw(double amount) {
        if (balance - amount > minimumBalance) {
            balance -= amount;
            return amount;
        } else {
            throw new RuntimeException();
        }
    }

    public double deposit(double amount) {
        return balance += amount;
    }
}
