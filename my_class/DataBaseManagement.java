package my_class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataBaseManagement {

    private String path_csv;
    private String[][] credential;

    public DataBaseManagement() {
        
    }

    public void loadDB(String path) {
        path_csv = path;
    }

    public String[][] getDB() {

        try {

            List<String> lines = Files.readAllLines(Paths.get(path_csv));

            credential = new String[lines.size()][];
            for (String line : lines) {
                credential[lines.indexOf(line)] = line.split(",");
            }

        } catch (Exception e) {
        }

        return credential;
    }

    public void setDB(String username, String password) {

        try {

            FileWriter file_writer = new FileWriter(path_csv, true);
            BufferedWriter buffer_writer = new BufferedWriter(file_writer);

            buffer_writer.write(username + "," + password);
            buffer_writer.newLine();

            buffer_writer.flush();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

}