package Models;

public class Officer extends Person
{
    public Officer(String username, String password) {
        super(username,password);
    }

    @Override
    public String toString() {
        return "Officer{"+super.toString()+"}";
    }
}
