package database;

public class Main {

//use databaseHelper.updateDatabase(); to create tables and insert data

    public static void main(String args[]) {
        DatabaseHelper databaseHelper = new DatabaseHelper();
        databaseHelper.printStaffFromDepartmentSortedByAttribute(1, "salary");
        databaseHelper.printStaffFromDepartmentSortedByAttribute(1, "name");
        databaseHelper.printStaffWithHigherSalary("Red Zimmerman");
        databaseHelper.printStaffInformation("Sizi Tenno");
        databaseHelper.printStaffInformation("Krevan Amaakir");
    }
}

