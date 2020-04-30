package database;

import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT";
    private static final String USER = "root";
    private static final String PASSWORD = "qwer1Qwert";

    private final String createDepartmentsSQLScript =
            "CREATE TABLE departments"
                    + "("
                    + "id       smallint(100) NOT NULL AUTO_INCREMENT,"
                    + "name     varchar(100)  NOT NULL,"
                    + "director varchar(100) NOT NULL,"
                    + "PRIMARY KEY (id)"
                    + ");";

    private final String createStaffSQLScript =
            "CREATE TABLE staff"
                    + "("
                    + "id         smallint(100)  NOT NULL AUTO_INCREMENT,"
                    + "name       varchar(100)   NOT NULL,"
                    + "salary     mediumint(100) NOT NULL,"
                    + "department smallint(100)  NOT NULL,"
                    + "PRIMARY KEY (id)"
                    + ");";

    private String insertDepartment(String name, String director) {
        return "INSERT INTO departments (name, director)"
                + "VALUES ('" + name + "', '" + director + "');";
    }

    private String insertStaff(String name, int department, int salary) {
        return "INSERT INTO staff(name, department, salary)"
                + "VALUES('" + name + "'," + department + "," + salary + ");";
    }

    public void printStaffFromDepartmentSortedByAttribute(int departmentId, String attribute) {
        String staffQuerySQLScript =
                "SELECT staff.*, departments.id "
                        + "FROM departments, staff "
                        + "WHERE departments.id = '" + departmentId + "' "
                        + "AND departments.id = staff.department "
                        + "ORDER BY " + attribute;
        System.out.println("Sort all staff by " + attribute);
        printQueryResult(staffQuerySQLScript);
    }

    public void printStaffWithHigherSalary(String name) {
        String staffQuerySQLScript =
                "SELECT * FROM staff "
                        + "WHERE staff.salary > "
                        + "(SELECT staff.salary "
                        + "FROM staff "
                        + "WHERE name = '" + name + "')";
        System.out.println("Higher salary than " + name);
        printQueryResult(staffQuerySQLScript);
    }

    public void printStaffInformation(String name) {
        String staffQuerySQLScript =
                "SELECT salary FROM staff "
                        + "WHERE staff.name = '" + name + "'";

        String directorQuerySQLScript =
                "SELECT staff.name, staff.salary " +
                        "FROM staff " +
                        "WHERE staff.department IN " +
                        "(SELECT departments.id FROM departments " +
                        "WHERE departments.director = '" + name + "') " +
                        "ORDER BY name";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery(staffQuerySQLScript);

            if (resultSet.next()) {
                System.out.println("Name of employer: " + name + ", salary: " + resultSet.getInt(1));
                return;
            }
            resultSet = statement.executeQuery(directorQuerySQLScript);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void printQueryResult(String staffQuerySQLScript) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            ResultSet resultSet = statement.executeQuery(staffQuerySQLScript);
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1)
                        + " " + resultSet.getString(2)
                        + " " + resultSet.getInt(3));
            }
            System.out.println("______________________");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDatabase() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();) {
            Class.forName("com.mysql.jdbc.Driver");
            statement.executeUpdate(createDepartmentsSQLScript);
            statement.executeUpdate(createStaffSQLScript);
            statement.executeUpdate(insertDepartment("Heroes", "Krevan Amaakir"));
            statement.executeUpdate(insertDepartment("Sizium", "Lames Talanseya"));
            statement.executeUpdate(insertDepartment("Valium", "Yakin Elleanollis"));
            statement.executeUpdate(insertStaff("Red Zimmerman", 1, 10000));
            statement.executeUpdate(insertStaff("Orphey  de Kray", 1, 15000));
            statement.executeUpdate(insertStaff("In Ling", 1, 20000));
            statement.executeUpdate(insertStaff("He Nuo", 2, 3000));
            statement.executeUpdate(insertStaff("He Shen", 2, 40000));
            statement.executeUpdate(insertStaff("Sizi Tenno", 2, 50000));
            statement.executeUpdate(insertStaff("Shi Zimmerman", 3, 1000));
            statement.executeUpdate(insertStaff("Frag Gradwill", 3, 37000));
            statement.executeUpdate(insertStaff("Man Yane", 3, 12000));
            System.out.println("Database is updated.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
