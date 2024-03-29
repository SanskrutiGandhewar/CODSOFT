package ATMInterface;

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
	        if (amount > 0) {
	            balance += amount;
	            System.out.println("Deposit successful. Your new balance is: $" + balance);
	        } else {
	            System.out.println("Invalid amount. Please enter a positive amount.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal successful. Your new balance is: $" + balance);
	        } else if (amount <= 0) {
	            System.out.println("Invalid amount. Please enter a positive amount.");
	        } else {
	            System.out.println("Insufficient funds. Your current balance is: $" + balance);
	        }
	    }
	}

	public class ATMInterface {
	    private BankAccount userAccount;

	    public ATMInterface(BankAccount userAccount) {
	        this.userAccount = userAccount;
	    }

	    public void displayMenu() {
	        System.out.println("Welcome to the ATM Interface");
	        System.out.println("1. Check Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdraw");
	        System.out.println("4. Exit");
	    }

	    public void processOption(int choice) {
	        Scanner scanner = new Scanner(System.in);

	        switch (choice) {
	            case 1:
	                checkBalance();
	                break;
	            case 2:
	                System.out.print("Enter the amount to deposit: $");
	                double depositAmount = scanner.nextDouble();
	                userAccount.deposit(depositAmount);
	                break;
	            case 3:
	                System.out.print("Enter the amount to withdraw: $");
	                double withdrawAmount = scanner.nextDouble();
	                userAccount.withdraw(withdrawAmount);
	                break;
	            case 4:
	                System.out.println("Thank you for using the ATM. Goodbye!");
	                System.exit(0);
	            default:
	                System.out.println("Invalid option. Please choose a valid option.");
	        }
	    }

	    private void checkBalance() {
	        System.out.println("Your balance is: $" + userAccount.getBalance());
	    }

	    public static void main(String[] args) {
	        BankAccount userAccount = new BankAccount(1000.0); // Initial balance
	        ATMInterface atm = new ATMInterface(userAccount);

	        while (true) {
	            atm.displayMenu();

	            Scanner scanner = new Scanner(System.in);
	            System.out.print("Select an option (1-4): ");
	            int choice = scanner.nextInt();

	            atm.processOption(choice);
	        }
	    }
	}
