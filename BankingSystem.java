import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private int accNo;
    private String name;
    private double balance;
    private ArrayList<String> history = new ArrayList<>();

    // Constructor
    BankAccount(int accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;

        history.add("Account created with balance: " + balance);
    }

    // Deposit Method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            history.add("Deposited: " + amount);
            System.out.println("Amount Deposited Successfully.");
        } else {
            System.out.println("Invalid Amount.");
        }
    }

    // Withdraw Method
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: " + amount);
            System.out.println("Withdrawal Successful.");
        } else {
            System.out.println("Insufficient Balance.");
        }
    }

    // Display Balance
    void showBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display Account Details
    void showDetails() {
        System.out.println("\n----- Account Details -----");
        System.out.println("Account Number : " + accNo);
        System.out.println("Account Holder : " + name);
        System.out.println("Balance        : " + balance);
    }

    // Transaction History
    void showHistory() {
        System.out.println("\n----- Transaction History -----");

        for (String s : history) {
            System.out.println(s);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount user = new BankAccount(accNo, name, balance);

        int choice;

        do {
            System.out.println("\n====== BANK MENU ======");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Deposit Amount: ");
                    double dep = sc.nextDouble();
                    user.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter Withdrawal Amount: ");
                    double wd = sc.nextDouble();
                    user.withdraw(wd);
                    break;

                case 3:
                    user.showBalance();
                    break;

                case 4:
                    user.showDetails();
                    break;

                case 5:
                    user.showHistory();
                    break;

                case 6:
                    System.out.println("Thank You for Using Banking System.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}