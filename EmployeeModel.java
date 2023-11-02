package application;

public class EmployeeModel {
    private static String employeeId;

    public static String getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(String id) {
        employeeId = id;
    }
}