
import java.util.*;

class BankingSystem {
    private HashMap<String, Double> accounts = new HashMap<>();
    private TreeMap<Double, List<String>> balanceSortedAccounts = new TreeMap<>();
    private Queue<String> withdrawalQueue = new LinkedList<>();

    public void createAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
        balanceSortedAccounts.computeIfAbsent(balance, k -> new ArrayList<>()).add(accountNumber);
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double newBalance = accounts.get(accountNumber) + amount;
            updateBalance(accountNumber, newBalance);
            System.out.println("Deposited Successfully.");
        } else {
            System.out.println("Account Not Found.");
        }
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
            System.out.println("Withdrawal Request Added.");
        } else {
            System.out.println("Account Not Found.");
        }
    }

    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            String accountNumber = withdrawalQueue.poll();
            if (accounts.containsKey(accountNumber)) {
                double currentBalance = accounts.get(accountNumber);
                if (currentBalance >= 100) {
                    double newBalance = currentBalance - 100;
                    updateBalance(accountNumber, newBalance);
                    System.out.println("Processed withdrawal of 100 for account: " + accountNumber);
                } else {
                    System.out.println("Insufficient balance for account: " + accountNumber);
                }
            }
        }
    }

    public void displayAccountsSortedByBalance() {
        for (Map.Entry<Double, List<String>> entry : balanceSortedAccounts.entrySet()) {
            for (String account : entry.getValue()) {
                System.out.println(account + " -> " + entry.getKey());
            }
        }
    }

    private void updateBalance(String accountNumber, double newBalance) {
        double oldBalance = accounts.get(accountNumber);
        List<String> accountsAtOldBalance = balanceSortedAccounts.get(oldBalance);
        accountsAtOldBalance.remove(accountNumber);
        if (accountsAtOldBalance.isEmpty()) {
            balanceSortedAccounts.remove(oldBalance);
        }
        accounts.put(accountNumber, newBalance);
        balanceSortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);
    }
}

public class BankingSystemDemo {
    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Request Withdrawal");
            System.out.println("4. Process Withdrawals");
            System.out.println("5. Display Accounts Sorted by Balance");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNum = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double bal = scanner.nextDouble();
                    bank.createAccount(accNum, bal);
                    System.out.println("Account Created.");
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    String depAcc = scanner.nextLine();
                    System.out.print("Enter Amount to Deposit: ");
                    double amount = scanner.nextDouble();
                    bank.deposit(depAcc, amount);
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    String withAcc = scanner.nextLine();
                    bank.requestWithdrawal(withAcc);
                    break;
                case 4:
                    bank.processWithdrawals();
                    break;
                case 5:
                    bank.displayAccountsSortedByBalance();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}



