public class AccountList {

    BankAccount[] accounts = new BankAccount[10];
    int size = 0;

    public void addAccount(BankAccount acc) {
        accounts[size] = acc;
        size++;
        System.out.println("Account added successfully");
    }

    public void showAccounts() {
        if (size == 0) {
            System.out.println("No accounts");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            accounts[i].show();
        }
    }

    public BankAccount findByUsername(String name) {

        for (int i = 0; i < size; i++) {

            if (accounts[i].username.equals(name)) {
                return accounts[i];
            }
        }

        return null;
    }
}