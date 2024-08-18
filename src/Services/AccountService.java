package Services;

import Data.AppDb;
import Models.Client;
import Models.Person;
import Services.Interfaces.IAccountService;

public class AccountService implements IAccountService
{

    @Override
    public String register() {
        Person newPerson = Person.personFactory();

        if(newPerson == null){
            return "A User with that username Already Exist";
        }
        AppDb.people.add(newPerson);
        return "Registered Successfully";
    }

    @Override
    public Person login(String username, String password) {
        Person loggedInUser = null;
        for (Person person:AppDb.people) {
            if(person.getUsername().equals(username) && person.getPassword().equals(password)){
                loggedInUser = person;
            }
        }
        return loggedInUser;
    }
}
