package assignment.session_9;

import java.util.Scanner;

abstract class Student {
    String name;
    static final double TUITION_FEE = 40000.0;
    static final double TRANSPORT_FEE = 12000.0;

    public Student(String name) {
        this.name = name;
    }

    public abstract double calculateBaseFee();
    public abstract boolean usesBus();
    public abstract String getTypeName();

    public double calculateTotalFee() {
        double fee = calculateBaseFee();
        if (usesBus()) {
            fee += TRANSPORT_FEE;
        }
        return fee;
    }
}

class DayScholar extends Student {
    public DayScholar(String name) {
        super(name);
    }
    @Override
    public double calculateBaseFee() {
        return TUITION_FEE;
    }
    @Override
    public boolean usesBus() {
        return true;
    }
    @Override
    public String getTypeName() {
        return "DAY_SCHOLAR";
    }
}

class Hosteller extends Student {
    public Hosteller(String name) {
        super(name);
    }
    @Override
    public double calculateBaseFee() {
        return TUITION_FEE + 60000.0;
    }
    @Override
    public boolean usesBus() {
        return false;
    }
    @Override
    public String getTypeName() {
        return "HOSTELLER";
    }
}

class ScholarStudent extends Student {
    public ScholarStudent(String name) {
        super(name);
    }
    @Override
    public double calculateBaseFee() {
        return TUITION_FEE * 0.5;
    }
    @Override
    public boolean usesBus() {
        return true;
    }
    @Override
    public String getTypeName() {
        return "SCHOLAR";
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Student[] students = new Student[n];
        double totalCollected = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equalsIgnoreCase("DAY_SCHOLAR")) {
                students[i] = new DayScholar(name);
            } else if (type.equalsIgnoreCase("HOSTELLER")) {
                students[i] = new Hosteller(name);
            } else if (type.equalsIgnoreCase("SCHOLAR")) {
                students[i] = new ScholarStudent(name);
            }
        }
        scanner.close();

        for (Student s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f\n", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}