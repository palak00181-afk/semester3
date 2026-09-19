package assignment.session_6;

public class CompanyEmployee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new CompanyEmployee("Divya", 65000);
        new CompanyEmployee("Arjun", 40000);
        new CompanyEmployee("Karthik", 55000);

        CompanyEmployee.printCompanyInfo();
    }
}