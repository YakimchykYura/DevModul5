package org.example;

import org.example.ClassesForQueries.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    private String readFile(String query) {
        StringBuilder string = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(query));
            String line;
            while ((line = reader.readLine()) != null) {
                string.append(" ").append(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
       return string.toString();
    }

    List<MaxProjectCountClient> findMaxProjectsClient() {
        String query = readFile("src/sql/find_max_projects_client.sql");
        System.out.println(query);
        List<MaxProjectCountClient> list = new ArrayList<>();
        try (PreparedStatement prStatement = Database.getInstance().getCONNECTION().prepareStatement(query)){
        ResultSet result = prStatement.executeQuery();

        while (result.next()) {
            MaxProjectCountClient countClient = new MaxProjectCountClient(result.getString("name"), result.getInt("project_count"));
            list.add(countClient);
        }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    List<LongestProject>  findLongestProject() {
        String query = readFile("src/sql/find_longest_project.sql");
        List<LongestProject> list = new ArrayList<>();
        try (PreparedStatement prStatement = Database.getInstance().getCONNECTION().prepareStatement(query)) {
            ResultSet result = prStatement.executeQuery();

            while (result.next()) {
                LongestProject longestProject = new LongestProject(result.getInt("ID"), result.getInt("months"));
                list.add(longestProject);
            }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    List<MaxSalaryWorker> findMaxSalaryWorker() {
        String query = readFile("src/sql/find_max_salary_worker.sql");
        List<MaxSalaryWorker> list = new ArrayList<>();
        try (PreparedStatement selectFindMaxSalaryWorker = Database.getInstance().getCONNECTION().prepareStatement(query)) {
            ResultSet result = selectFindMaxSalaryWorker.executeQuery();
            while (result.next()) {
                MaxSalaryWorker maxSalary = new MaxSalaryWorker(result.getString("name"), result.getInt("salary"));
                list.add(maxSalary);
            }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
    List<YoungestEldestWorker> findYoungestEldestWorker() {
        String query = readFile("src/sql/find_youngest_eldest_workers.sql");
        List<YoungestEldestWorker> list = new ArrayList<>();
        try (PreparedStatement prStatement = Database.getInstance().getCONNECTION().prepareStatement(query)) {
            ResultSet result = prStatement.executeQuery();

            while (result.next()) {
                YoungestEldestWorker worker = new YoungestEldestWorker(result.getString("type"),
                        result.getString("name"),
                        result.getString("birthday"));
                list.add(worker);
            }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0));
        return list;
    }
    List<ProjectPrices> findProjectPrices() {
        String query = readFile("src/sql/print_project_prices.sql");
        System.out.println(query);
        List<ProjectPrices> list = new ArrayList<>();
        try (PreparedStatement prStatement = Database.getInstance().getCONNECTION().prepareStatement(query)) {
            ResultSet result = prStatement.executeQuery();

            while (result.next()) {
                ProjectPrices projectPrices = new ProjectPrices(result.getString("name"),
                        result.getString("project_prices"));
                list.add(projectPrices);
            }
            Database.getInstance().closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
