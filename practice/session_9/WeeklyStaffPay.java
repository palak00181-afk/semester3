package practice.session_9;

import java.util.Scanner;

abstract class Staff {
    String name;
    public Staff(String name) {
        this.name = name;
    }
    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    double weeklySalary;
    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }
    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    double hours, rate;
    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }
    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * rate * 1.5);
        }
    }
}

class InternStaff extends Staff {
    double stipend;
    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }
    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Staff[] staffList = new Staff[n];
        double totalPayroll = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();
            if (type.equalsIgnoreCase("FULLTIME")) {
                double salary = scanner.nextDouble();
                staffList[i] = new FullTimeStaff(name, salary);
            } else if (type.equalsIgnoreCase("HOURLY")) {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staffList[i] = new HourlyStaff(name, hours, rate);
            } else if (type.equalsIgnoreCase("INTERN")) {
                double stipend = scanner.nextDouble();
                staffList[i] = new InternStaff(name, stipend);
            }
        }
        scanner.close();

        for (Staff s : staffList) {
            double pay = s.calculatePay();
            totalPayroll += pay;
            System.out.printf("%s: %.2f\n", s.name, pay);
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
    }
}