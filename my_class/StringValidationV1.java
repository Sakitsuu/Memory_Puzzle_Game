package my_class;

import java.util.Arrays;

public class StringValidationV1 {

    String[] usernames;

    public StringValidationV1() {

        DataBaseManagement db = new DataBaseManagement();
        db.loadDB("database.csv");
        String[][] credential = db.getDB();

        usernames = new String[credential.length];
        for (int i = 0; i < credential.length; i++) {
            usernames[i] = credential[i][0];
        }

        // System.out.println(Arrays.deepToString(usernames));
    }

    public boolean isUserNameValid(String username) {

        for (String user : usernames) {
            if (user.equals(username)) {
                return false;
            }
        }

        return true;
    }

    public boolean isStringGreater(String string) {
        return string.length() >= 6;
    }

    public boolean isStringGreater(String string, int length) {
        return string.length() >= length;
    }

    public boolean isStringLesser(String string) {
        return string.length() <= 20;
    }

    public boolean isStringLesser(String string, int length) {
        return string.length() <= length;
    }

}