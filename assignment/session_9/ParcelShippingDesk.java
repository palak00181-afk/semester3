package assignment.session_9;

import java.util.Scanner;

abstract class Parcel {
    double weightKg, declaredValue;
    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }
    public abstract double calculateCharge();
    public abstract double calculateInsurance();
    public abstract String getTypeName();
}

class StandardParcel extends Parcel {
    public StandardParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 40.0 + (weightKg * 10.0);
    }
    @Override
    public double calculateInsurance() {
        return 0.0;
    }
    @Override
    public String getTypeName() {
        return "STANDARD";
    }
}

class ExpressParcel extends Parcel {
    public ExpressParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 80.0 + (weightKg * 15.0);
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
    @Override
    public String getTypeName() {
        return "EXPRESS";
    }
}

class FragileParcel extends Parcel {
    public FragileParcel(double weightKg, double declaredValue) {
        super(weightKg, declaredValue);
    }
    @Override
    public double calculateCharge() {
        return 40.0 + (weightKg * 10.0) + 50.0;
    }
    @Override
    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
    @Override
    public String getTypeName() {
        return "FRAGILE";
    }
}

public class ParcelShippingDesk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            if (type.equalsIgnoreCase("STANDARD")) {
                parcels[i] = new StandardParcel(weight, value);
            } else if (type.equalsIgnoreCase("EXPRESS")) {
                parcels[i] = new ExpressParcel(weight, value);
            } else if (type.equalsIgnoreCase("FRAGILE")) {
                parcels[i] = new FragileParcel(weight, value);
            }
        }
        scanner.close();

        for (Parcel p : parcels) {
            double charge = p.calculateCharge();
            double insurance = p.calculateInsurance();
            double total = charge + insurance;
            grandTotal += total;
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getTypeName(), charge, insurance, total);
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}