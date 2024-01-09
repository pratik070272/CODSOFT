import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: $" + balance);
            return true;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit(amount);
                break;
            case 3:
                withdraw(amount);
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public void checkBalance() {
        System.out.println("Available Balance: $" + userAccount.getBalance());
    }

    private void deposit(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount. Please enter a non-negative value.");
            return;
        }

        userAccount.deposit(amount);
        System.out.println("Deposit successful. Updated balance: $" + userAccount.getBalance());
    }

    private void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid amount. Please enter a non-negative value.");
            return;
        }

        userAccount.withdraw(amount);
    }
}

public class ATMExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount userAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(userAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice (1-4): ");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Consume the invalid input
                continue;
            }

            if (choice == 4) {
                break;
            }

            if (choice >= 1 && choice <= 3) {
                if (choice == 1) {
                    atm.checkBalance();
                } else {
                    System.out.print("Enter amount: ");
                    double amount;
                    try {
                        amount = scanner.nextDouble();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number.");
                        scanner.nextLine(); // Consume the invalid input
                        continue;
                    }

                    atm.performTransaction(choice, amount);
                }
            } else {
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }

        scanner.close();
    }
}
