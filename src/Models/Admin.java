package Models;

public class Admin extends Person
{
    public Admin(String username, String password) {
        super(username,password);
    }

    @Override
    public String toString() {
        return "Admin{"+super.toString()+"}";
    }
}
