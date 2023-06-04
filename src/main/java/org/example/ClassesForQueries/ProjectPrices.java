package org.example.ClassesForQueries;

public class ProjectPrices {
    private String name;
    private String project_prices;

    public ProjectPrices(String name, String project_prices) {
        this.name = name;
        this.project_prices = project_prices;
    }

    @Override
    public String toString() {
        return "ProjectPrices{" +
                "name='" + name + '\'' +
                ", project_prices='" + project_prices + '\'' +
                '}';
    }
}
