package lab9;

public class TestNewException {
    public static void main(String[] args) {
        Account account1 = new Account("5834590458903458904", 334, "Ędward Ącki");
        Account account2 = new Account("8349054893403403321", 5544, "Papa John");
        transferCash(account1, account2, 500);
    }

    public static void transferCash(Account from, Account to, int amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println("Nie można dokonać przelewu: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Stan konta: " + from.getBalance());
        }
    }
}

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }

    public InsufficientBalanceException(Number requested) {
        super("Niewystarczające środki na koncie (kwota zapytana: " + requested + ")");
    }
}

class Account {
    private String accountNumber;
    private int balance;
    private String owner;

    public Account(String accountNumber, int balance, String owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwner() {
        return owner;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(amount);
        }
        balance -= amount;
    }
}