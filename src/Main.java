import Data.AppDb;

public class Main {
    public static void main(String[] args) {
        AppDb.SeedDatabase();
        App app = new App();
        app.start();
    }
}