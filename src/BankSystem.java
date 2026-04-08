import java.util.*;

public class BankSystem {
    LinkedList<BankAccount> accounts = new LinkedList<>();
    Stack<String> history = new Stack<>();
    Queue<String> bills = new LinkedList<>();
    Queue<BankAccount> requests = new LinkedList<>();

    public BankSystem() {
        BankAccount[] arr = {
                new BankAccount("A1", "Ali", 150000),
                new BankAccount("A2", "Sara", 220000),
                new BankAccount("A3", "Damir", 180000)
        };

        for (BankAccount a : arr) {
            accounts.add(a);
        }
    }

    public void requestAccount(String no, String name, double bal) {
        requests.add(new BankAccount(no, name, bal));
        System.out.println("Request added");
    }

    public void addAccount(String no, String name, double bal) {
        accounts.add(new BankAccount(no, name, bal));
        System.out.println("Account added");
    }

    public void showAccounts() {
        for (BankAccount a : accounts) {
            System.out.println(a.name + " - " + a.balance);
        }
    }

    public void searchAccount(String name) {
        for (BankAccount a : accounts) {
            if (a.name.equalsIgnoreCase(name)) {
                System.out.println("Found: " + a.name + " - " + a.balance);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void deposit(String name, double x) {
        for (BankAccount a : accounts) {
            if (a.name.equalsIgnoreCase(name)) {
                a.balance += x;
                history.push("Deposit " + x + " to " + a.name);
                System.out.println("New balance: " + a.balance);
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void withdraw(String name, double x) {
        for (BankAccount a : accounts) {
            if (a.name.equalsIgnoreCase(name)) {
                if (a.balance >= x) {
                    a.balance -= x;
                    history.push("Withdraw " + x + " from " + a.name);
                    System.out.println("New balance: " + a.balance);
                } else {
                    System.out.println("Not enough money");
                }
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void checkBalance(String name) {
        for (BankAccount a : accounts) {
            if (a.name.equalsIgnoreCase(name)) {
                System.out.println("Balance: " + a.balance);
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void atmWithdraw(String name, double x) {
        for (BankAccount a : accounts) {
            if (a.name.equalsIgnoreCase(name)) {
                if (a.balance >= x) {
                    a.balance -= x;
                    history.push("ATM withdraw " + x + " from " + a.name);
                    System.out.println("New balance: " + a.balance);
                } else {
                    System.out.println("Not enough money");
                }
                return;
            }
        }
        System.out.println("Account not found");
    }

    public void addBill(String bill) {
        bills.add(bill);
        history.push("Bill added: " + bill);
        System.out.println("Bill added");
    }

    public void showHistory() {
        System.out.println("History: " + history);
        if (!history.isEmpty()) {
            System.out.println("Last: " + history.peek());
        }
    }
}