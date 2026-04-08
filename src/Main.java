import java.util.*;

class BankAccount {
    String accNo, name;
    double balance;

    BankAccount(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedList<BankAccount> accounts = new LinkedList<>();
        Stack<String> history = new Stack<>();
        Queue<String> bills = new LinkedList<>();
        Queue<BankAccount> requests = new LinkedList<>();

        BankAccount[] arr = {
                new BankAccount("A1", "Almaz", 150000),
                new BankAccount("A2", "Nill", 220000),
                new BankAccount("A3", "Damir", 180000)
        };

        for (BankAccount a : arr) accounts.add(a);

        int ch;
        do {
            System.out.println("\n1-Bank  2-ATM  3-Admin  4-Exit");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                int b;
                do {
                    System.out.println("\n1-Request Account 2-Add Account 3-Show Accounts 4-Search 5-Deposit 6-Withdraw 7-Add Bill 8-History 9-Back");
                    b = sc.nextInt();
                    sc.nextLine();

                    if (b == 1) {
                        System.out.print("Acc No: ");
                        String no = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Balance: ");
                        double bal = sc.nextDouble();
                        sc.nextLine();
                        requests.add(new BankAccount(no, name, bal));
                        System.out.println("Request added");
                    }

                    else if (b == 2) {
                        System.out.print("Acc No: ");
                        String no = sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Balance: ");
                        double bal = sc.nextDouble();
                        sc.nextLine();
                        accounts.add(new BankAccount(no, name, bal));
                        System.out.println("Account added");
                    }

                    else if (b == 3) {
                        for (BankAccount a : accounts)
                            System.out.println(a.name + " - " + a.balance);
                    }

                    else if (b == 4) {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        for (BankAccount a : accounts)
                            if (a.name.equalsIgnoreCase(name))
                                System.out.println("Found: " + a.name + " - " + a.balance);
                    }

                    else if (b == 5) {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Deposit: ");
                        double x = sc.nextDouble();
                        sc.nextLine();
                        for (BankAccount a : accounts)
                            if (a.name.equalsIgnoreCase(name)) {
                                a.balance += x;
                                history.push("Deposit " + x + " to " + a.name);
                                System.out.println("New balance: " + a.balance);
                            }
                    }

                    else if (b == 6) {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Withdraw: ");
                        double x = sc.nextDouble();
                        sc.nextLine();
                        for (BankAccount a : accounts)
                            if (a.name.equalsIgnoreCase(name)) {
                                if (a.balance >= x) {
                                    a.balance -= x;
                                    history.push("Withdraw " + x + " from " + a.name);
                                    System.out.println("New balance: " + a.balance);
                                } else System.out.println("Not enough money");
                            }
                    }

                    else if (b == 7) {
                        System.out.print("Bill name: ");
                        String bill = sc.nextLine();
                        bills.add(bill);
                        history.push("Bill added: " + bill);
                        System.out.println("Added: " + bill);
                    }

                    else if (b == 8) {
                        System.out.println("History: " + history);
                        if (!history.isEmpty()) System.out.println("Last: " + history.peek());
                    }

                } while (b != 9);
            }

            else if (ch == 2) {
                int a;
                do {
                    System.out.println("\n1-Balance 2-Withdraw 3-Back");
                    a = sc.nextInt();
                    sc.nextLine();

                    if (a == 1) {
                        System.out.print("Enter name; ");
                        String name = sc.nextLine();
                        for (BankAccount x : accounts)
                            if (x.name.equalsIgnoreCase(name))
                                System.out.println("Balance: " + x.balance);
                    }

                    else if (a == 2) {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Withdraw: ");
                        double x = sc.nextDouble();
                        sc.nextLine();
                        for (BankAccount acc : accounts)
                            if (acc.name.equalsIgnoreCase(name)) {
                                if (acc.balance >= x) {
                                    acc.balance -= x;
                                    history.push("ATM withdraw " + x + " from " + acc.name);
                                    System.out.println("New balance: " + acc.balance);
                                } else System.out.println("Not enough money");
                            }
                    }

                } while (a != 3);
            }

            else if (ch == 3) {
                int ad;
                do {
                    System.out.println("\n1-Show Requests 2-Process Request 3-Show Bills 4-Process Bill 5-Undo Last 6-Back");
                    ad = sc.nextInt();
                    sc.nextLine();

                    if (ad == 1) System.out.println("Requests: " + requests.size());

                    else if (ad == 2) {
                        if (!requests.isEmpty()) {
                            BankAccount x = requests.poll();
                            accounts.add(x);
                            System.out.println("Processed: " + x.name);
                        } else System.out.println("No requests");
                    }

                    else if (ad == 3) System.out.println("Bills: " + bills);

                    else if (ad == 4) {
                        if (!bills.isEmpty()) System.out.println("Processing: " + bills.poll());
                        else System.out.println("No bills");
                    }

                    else if (ad == 5) {
                        if (!history.isEmpty()) System.out.println("Undo: " + history.pop());
                        else System.out.println("No history");
                    }

                } while (ad != 6);
            }

        } while (ch != 4);
    }
}