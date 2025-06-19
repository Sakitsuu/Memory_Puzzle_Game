package my_class;

import java.util.Arrays;

public class Login {

    String[][] credentials;

    public Login() {

        DataBaseManagement db = new DataBaseManagement();
        db.loadDB("database.csv");
        credentials = db.getDB();

        // System.out.println(Arrays.deepToString(credentials));

    }

    public boolean successLogIn(String username, String password) {

        for (String[] c : credentials) {
            if (c[0].equals(username) && c[1].equals(password)) {
                return true;
            }
        }

        return false;

    }
}
