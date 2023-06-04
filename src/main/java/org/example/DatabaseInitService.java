package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitService {
    public static void main(String[] args) {

        PreparedStatement createTable = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/sql/init_db.sql"));
            String line;
            StringBuilder string = new StringBuilder(" ");
            int c = 0;
            String[] query = new String[4];
            while ((line = reader.readLine()) != null) {
                string.append(" ").append(line);
                if (line.equals(")")) {
                    query[c] = string.toString();
                    string = new StringBuilder(" ");
                    c++;
                }
            }

            for (String s : query) {
                createTable = Database.getInstance().getCONNECTION().prepareStatement(s);
                createTable.execute();
            }

            Database.getInstance().getCONNECTION().close();
            createTable.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
