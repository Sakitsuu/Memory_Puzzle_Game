package my_class;

import java.util.Arrays;

public class Register {

    StringValidationV2 sv;
    DataBaseManagement db;

    public Register() {
        db = new DataBaseManagement();
        db.loadDB("database.csv");

        sv = new StringValidationV2();

    }

    public boolean isUserNameValid(String username) {

        boolean isValid = sv.isUserNameValid(username)
                && sv.isStringGreater(username, 6)
                && sv.isStringLesser(username, 20)
                && !sv.isStringHasUpper(username)
                && !sv.isStringHasNum(username)
                && !sv.isStringHasSpecialChar(username)
                && !sv.isStringHasSpace(username);

        return isValid;
    }

    public boolean isPasswordValid(String password) {

        boolean isValid = sv.isStringGreater(password, 6)
                && sv.isStringLesser(password, 20)
                && sv.isStringHasUpper(password)
                && sv.isStringHasLower(password)
                && sv.isStringHasNum(password)
                && sv.isStringHasSpecialChar(password)
                && sv.hasTwoLower(password)
                && !sv.isStringHasSpace(password);

        return isValid;
    }

    public boolean isRegisterSuccess(String username, String password, String verify_password) {

        if (isUserNameValid(username) && isPasswordValid(password) && password.equals(verify_password)) {
            db.setDB(username, password);
            return true;
        } else {
            return false;
        }

    }

}