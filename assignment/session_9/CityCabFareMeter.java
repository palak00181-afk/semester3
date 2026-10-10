package assignment.session_9;

import java.util.Scanner;

abstract class Cab {
    double distanceKm;
    String time;

    public Cab(double distanceKm, String time) {
        this.distanceKm = distanceKm;
        this.time = time;
    }

    public abstract double getRatePerKm();
    public abstract boolean allowsNightService();
    public abstract String getCabName();

    public boolean isNightServiceRejected() {
        return !allowsNightService() && time.equalsIgnoreCase("NIGHT");
    }

    public double calculateFare() {
        double rawFare = distanceKm * getRatePerKm();
        double fare = Math.max(100.0, rawFare);
        if (time.equalsIgnoreCase("NIGHT")) {
            fare *= 1.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double distanceKm, String time) {
        super(distanceKm, time);
    }
    @Override
    public double getRatePerKm() {
        return 10.0;
    }
    @Override
    public boolean allowsNightService() {
        return false;
    }
    @Override
    public String getCabName() {
        return "MINI";
    }
}

class SedanCab extends Cab {
    public SedanCab(double distanceKm, String time) {
        super(distanceKm, time);
    }
    @Override
    public double getRatePerKm() {
        return 14.0;
    }
    @Override
    public boolean allowsNightService() {
        return true;
    }
    @Override
    public String getCabName() {
        return "SEDAN";
    }
}

class SuvCab extends Cab {
    public SuvCab(double distanceKm, String time) {
        super(distanceKm, time);
    }
    @Override
    public double getRatePerKm() {
        return 18.0;
    }
    @Override
    public boolean allowsNightService() {
        return true;
    }
    @Override
    public String getCabName() {
        return "SUV";
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Cab[] trips = new Cab[n];
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double distance = scanner.nextDouble();
            String time = scanner.next();

            if (type.equalsIgnoreCase("MINI")) {
                trips[i] = new MiniCab(distance, time);
            } else if (type.equalsIgnoreCase("SEDAN")) {
                trips[i] = new SedanCab(distance, time);
            } else if (type.equalsIgnoreCase("SUV")) {
                trips[i] = new SuvCab(distance, time);
            }
        }
        scanner.close();

        for (Cab c : trips) {
            if (c.isNightServiceRejected()) {
                System.out.println(c.getCabName() + ": night service not available");
            } else {
                double fare = c.calculateFare();
                total += fare;
                System.out.printf("%s: %.2f\n", c.getCabName(), fare);
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}