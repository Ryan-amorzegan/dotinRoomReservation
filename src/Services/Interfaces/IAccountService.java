package Services.Interfaces;

import Models.Person;

public interface IAccountService
{
    String register();
    Person login(String username, String password);
}
