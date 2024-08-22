package Models;

public class Client extends Person
{
    private int balance;

    public Client(){

    }

    public Client(String username, String password, int balance) {
        super(username,password);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" + super.toString()+
                "balance=" + balance +
                '}';
    }
}
