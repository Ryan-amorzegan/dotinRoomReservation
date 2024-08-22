package Models;

import Data.AppDb;

import java.util.ArrayList;
import java.util.Objects;

import static Utilities.Reader.input;

public class Person
{
    static private int idInc = 0;
    private int id;
    private String username;
    private String password;

    public Person(String username, String password) {
        this.id = idInc;
        setUsername(username);
        setPassword(password);
        idInc++;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        boolean isGood = true;
        ArrayList<Person> people = AppDb.people;
        for (Person per:people) {
            if(per.username.equals(username)){
                isGood = false;
                return false;
            }
        }
        if(isGood){
            this.username = username;
        }
        return true;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Person personFactory() {
        Person person = new Client();
        person.id = idInc;
        System.out.println("Enter your username: ");
        person.setUsername(input.nextLine());
        System.out.println("Enter your password: ");
        person.setPassword(input.nextLine());
        idInc++;
        if(person.getUsername() != null){
            return person;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(username, person.username) && Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + id +
                ", name='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
