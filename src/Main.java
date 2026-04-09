import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AccountList list = new AccountList();
        MyStack history = new MyStack(20);

        int choice;

        do {

            System.out.println("\n1 Add Account");
            System.out.println("2 Show Accounts");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Last Transaction");
            System.out.println("6 Undo Transaction");
            System.out.println("0 Exit");

            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Account number: ");
                String accNo = sc.nextLine();

                System.out.print("Username: ");
                String name = sc.nextLine();

                System.out.print("Balance: ");
                double bal = sc.nextDouble();

                BankAccount acc = new BankAccount(accNo, name, bal);
                list.addAccount(acc);
            }

            else if (choice == 2) {
                list.showAccounts();
            }

            else if (choice == 3) {

                System.out.print("Username: ");
                String name = sc.nextLine();

                BankAccount acc = list.findByUsername(name);

                if (acc != null) {

                    System.out.print("Deposit: ");
                    double money = sc.nextDouble();

                    acc.balance += money;

                    history.push("Deposit " + money + " to " + name);

                    System.out.println("New balance: " + acc.balance);
                }

                else {
                    System.out.println("User not found");
                }
            }

            else if (choice == 4) {

                System.out.print("Username: ");
                String name = sc.nextLine();

                BankAccount acc = list.findByUsername(name);

                if (acc != null) {

                    System.out.print("Withdraw: ");
                    double money = sc.nextDouble();

                    if (acc.balance >= money) {

                        acc.balance -= money;

                        history.push("Withdraw " + money + " from " + name);

                        System.out.println("New balance: " + acc.balance);
                    }

                    else {
                        System.out.println("Not enough money");
                    }
                }

                else {
                    System.out.println("User not found");
                }
            }

            else if (choice == 5) {
                System.out.println("Last: " + history.peek());
            }

            else if (choice == 6) {
                System.out.println("Undo: " + history.pop());
            }

        } while (choice != 0);
    }
}