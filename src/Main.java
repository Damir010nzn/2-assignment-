import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AccountList list = new AccountList();
        MyStack history = new MyStack(20);

        // Task 4 - Bill Payment Queue
        MyQueue billQueue = new MyQueue(20);

        // Task 5 - Account Opening Request Queue
        MyQueue accountRequests = new MyQueue(20);

        int choice;

        do {

            System.out.println("\n1 Add Account");
            System.out.println("2 Show Accounts");
            System.out.println("3 Deposit");
            System.out.println("4 Withdraw");
            System.out.println("5 Last Transaction");
            System.out.println("6 Undo Transaction");
            System.out.println("7 Add Bill Payment");
            System.out.println("8 Process Bill Payment");
            System.out.println("9 Show Bill Queue");
            System.out.println("10 Add Account Request");
            System.out.println("11 Process Account Request");
            System.out.println("12 Show Account Requests");
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
                sc.nextLine();

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
                    sc.nextLine();

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
                    sc.nextLine();

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

            // Task 4 - Add bill payment
            else if (choice == 7) {
                System.out.print("Enter bill name: ");
                String bill = sc.nextLine();

                billQueue.enqueue(bill);
                System.out.println("Added: " + bill);
            }

            // Task 4 - Process next bill
            else if (choice == 8) {
                System.out.println("Processing: " + billQueue.dequeue());
            }

            // Task 4 - Show bill queue
            else if (choice == 9) {
                System.out.println("Bill Queue:");
                billQueue.show();
            }

            // Task 5 - Add account opening request
            else if (choice == 10) {
                System.out.print("Enter username for account request: ");
                String requestName = sc.nextLine();

                accountRequests.enqueue(requestName);
                System.out.println("Account request added for: " + requestName);
            }

            // Task 5 - Process account request
            else if (choice == 11) {
                String requestName = accountRequests.dequeue();

                if (!requestName.equals("Queue is empty")) {

                    String accNo = "ACC" + (list.size + 1);
                    BankAccount newAcc = new BankAccount(accNo, requestName, 0);

                    list.addAccount(newAcc);

                    System.out.println("Processed account request for: " + requestName);
                }

                else {
                    System.out.println("No account requests");
                }
            }

            // Task 5 - Show pending requests
            else if (choice == 12) {
                System.out.println("Pending Account Requests:");
                accountRequests.show();
            }

        } while (choice != 0);
    }
}