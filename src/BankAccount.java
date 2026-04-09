public class BankAccount {

    String accountNumber;
    String username;
    double balance;

    public BankAccount(String accountNumber, String username, double balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

    public void show() {
        System.out.println(username + " - Balance: " + balance);
    }
}