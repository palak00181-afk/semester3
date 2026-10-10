package practice.session_9;

import java.util.Scanner;

abstract class Connection {
    int units;
    public Connection(int units) {
        this.units = units;
    }
    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }
    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Connection[] connections = new Connection[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            int units = scanner.nextInt();
            if (type.equalsIgnoreCase("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equalsIgnoreCase("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equalsIgnoreCase("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }
        scanner.close();

        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f\n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f\n", total);
    }
}