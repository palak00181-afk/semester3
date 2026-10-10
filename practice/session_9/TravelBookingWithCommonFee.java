package practice.session_9;

import java.util.Scanner;

abstract class TravelBooking {
    double distanceKm;
    static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();
    public abstract String getModeName();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return distanceKm * 2.0;
    }
    @Override
    public String getModeName() {
        return "BUS";
    }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return distanceKm * 1.5;
    }
    @Override
    public String getModeName() {
        return "TRAIN";
    }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }
    @Override
    public double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }
    @Override
    public String getModeName() {
        return "FLIGHT";
    }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        TravelBooking[] bookings = new TravelBooking[n];

        for (int i = 0; i < n; i++) {
            String mode = scanner.next();
            double distance = scanner.nextDouble();
            if (mode.equalsIgnoreCase("BUS")) {
                bookings[i] = new BusBooking(distance);
            } else if (mode.equalsIgnoreCase("TRAIN")) {
                bookings[i] = new TrainBooking(distance);
            } else if (mode.equalsIgnoreCase("FLIGHT")) {
                bookings[i] = new FlightBooking(distance);
            }
        }
        scanner.close();

        for (TravelBooking b : bookings) {
            double totalFare = b.calculateTotalFare();
            System.out.printf("%s: %.2f\n", b.getModeName(), totalFare);
        }
    }
}