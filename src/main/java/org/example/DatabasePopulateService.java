package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabasePopulateService {
    public static void main(String[] args) {

        PreparedStatement populateService = null;

        try {
            BufferedReader reader1 = new BufferedReader(new FileReader("src/sql/populate_db.sql"));
            String line;
            int c = 0;
            String[] query = new String[22];
            while ((line = reader1.readLine()) != null) {
                    query[c] = line;
                    c++;
            }
            for (String s : query) {
                populateService = Database.getInstance().getCONNECTION().prepareStatement(s);
                populateService.execute();
            }

            Database.getInstance().closeConnection();
            populateService.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
