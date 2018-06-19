package com.chetan.javaPractice;

import java.util.ArrayList;

public class BankDemo {

    static MyBank myBank = new MyBank();
    public static void main(String[] args) {

        myBank.addBranch("branch1");

        myBank.addCustomer("branch1","Rohit Suradkar", 100.0);
        myBank.addCustomer("branch1","chetan lawakar", 200.0);
        myBank.addCustomer("branch1","Prathmesh Marathe", 300.0);

        myBank.addTransaction("branch1","Prathmesh Marathe", 100.0);
        myBank.addTransaction("branch1","Prathmesh Marathe", 300.0);
        myBank.addTransaction("branch1","Prathmesh Marathe", -301.0);
        myBank.displayBalance("branch1","Prathmesh Marathe");

        myBank.displayCustomers("branch1",true,true);

    }
}

class MyBank {

    private ArrayList<Branch> branchArrayList;

    public MyBank() {
        branchArrayList = new ArrayList<Branch>();
    }

    private Branch searchBranch(String branchName){
        for(Branch branch : branchArrayList) {
            if(branch.getBranchName().equalsIgnoreCase(branchName)){
                return branch;
            }
        }
        return null;
    }

    public boolean addBranch(String branchName) {
        if(searchBranch(branchName) == null) {
            branchArrayList.add(new Branch(branchName));
            return true;
        }
        return false;
    }

    public boolean addTransaction(String branchName, String customerName, double transactionAamount) {
        Branch branch = (searchBranch(branchName));
        if(branch == null) {
            System.out.println("Branch " + branchName +" does not exist");
            return false;
        } else if (branch.addTransaction(customerName,transactionAamount)) {
            System.out.println("Transaction of amount " + transactionAamount + " added successfully");
            return true;
        } else {
            return false;
        }

    }

    public boolean addCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = searchBranch(branchName);
        if(branch == null) {
            System.out.println("Branch " + branchName + " does not exist. Please add branch first");
            return false;
        } else if (branch.addNewCustomer(customerName,initialAmount)) {
            System.out.println("Customer got added successfully");
            return true;
        } else {
            return false;
        }
    }

    public void displayBalance(String branchName, String customerName) {
        Branch branch = searchBranch(branchName);
        if(branch == null) {
            System.out.println("Branch " + branchName + " does not exist");
        } else {
            branch.displayBalance(customerName);
        }
    }

    public void displayCustomers(String branchName, boolean balnaceInfoRequired,boolean transactiosInfoRequired) {
        System.out.println("==========================================================");
        for(Branch branch : branchArrayList) {
            if(branch.getBranchName().equalsIgnoreCase(branchName)) {
                System.out.println("Customers for Branch " + branchName + " are listed below : ");
                branch.displayCustomers(balnaceInfoRequired,transactiosInfoRequired);
            } else {
                System.out.println("Branch Name" + branchName + " not exist..!!");
            }
        }

        System.out.println("==========================================================");
    }
}


class Branch {
    private String branchName = new String();
    private ArrayList<Customer> customerArrayList;

    public Branch(String branchName) {
        this.branchName = branchName;
        this.customerArrayList = new ArrayList<Customer>();
    }

    public String getBranchName() {
        return branchName;
    }

    private Customer searchCustomer (String customerName) {
        for(Customer c : customerArrayList) {
            if(c.getcustomerName().equalsIgnoreCase(customerName)) {
                return c;
            }
        }
        return null;
    }

    public void displayBalance(String customerName) {
        Customer customer = searchCustomer(customerName);
        if(customer == null) {
            System.out.println("Customer with name" + customerName + "does not exist..!!");
        } else {
            customer.displyBalance();
        }

    }

    public void displayCustomers(boolean balaceInfoRequired, boolean transactionsInfoRequired) {
        for(int i = 0; i < customerArrayList.size() ; i++) {
            Customer customer = customerArrayList.get(i);
            System.out.println("Customer [ " + (i+1) +" ] :" +
                    "\n Customer Name: " + customer.getcustomerName());
            if(balaceInfoRequired) {
                customer.displyBalance();
            }

            if(transactionsInfoRequired) {
                customer.displyTransactions();
            }

            System.out.println("\n");
        }
    }

    public boolean addNewCustomer (String customenrName, double initialAmount) {
        if(searchCustomer(customenrName) == null) {
            customerArrayList.add(new Customer(customenrName, initialAmount));
            return true;
        } else {
            System.out.println("Custome with CustomenrName" + customenrName + " is already exist." +
                    "So can not add new customer with same Customenr Name.");
            return false;
        }

    }

    public boolean addTransaction (String customerName, double transactionAmount) {

        Customer customer = searchCustomer(customerName);
        if(customer == null) {
            System.out.println("Custome with customerName" + customerName + " is not exist."
            + " Failded to add transaction");
            return false;
        } else {
            return customer.addTransaction(transactionAmount);
        }

    }

}

class Customer {

    private String customerName = new String();
    private double balance;
    private ArrayList<Double> transactions;


    public Customer(String customerName, double balance) {
        this.customerName = customerName;
        this.balance = balance;
        this.transactions  = new ArrayList<Double>();
    }

    public void displyBalance() {
        System.out.println("Balance : " + this.balance);
    }

    public void displyTransactions() {
        for(int i = 0; i < transactions.size();i++) {
            System.out.println("transaction [ " + (i+1) + " ] : " + transactions.get(i));
        }
    }

    public void setcustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getcustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return this.transactions;
    }

    public boolean addTransaction(double value) {
        if((this.balance + value ) < 0d) {
            System.out.println("Resulting balance after adding" + value + " is negative. So this transaction can not be done");
            return false;
        } else {
            this.transactions.add(value);
            this.balance = balance + value;
            return true;
        }
    }

}