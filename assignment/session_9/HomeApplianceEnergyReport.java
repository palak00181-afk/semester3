package assignment.session_9;

import java.util.Scanner;

abstract class Appliance {
    double hours;
    boolean saverMode;

    public Appliance(double hours, boolean saverMode) {
        this.hours = hours;
        this.saverMode = saverMode;
    }

    public abstract double getPowerWatts();
    public abstract boolean supportsSaverMode();
    public abstract String getAppName();

    public boolean isSaverModeInvalid() {
        return saverMode && !supportsSaverMode();
    }

    public double calculateUnits() {
        double kw = getPowerWatts() / 1000.0;
        double units = kw * hours;
        if (saverMode && supportsSaverMode()) {
            units *= 0.75; // reduced by 25%
        }
        return units;
    }

    public double calculateCost() {
        return calculateUnits() * 8.0;
    }
}

class FridgeAppliance extends Appliance {
    public FridgeAppliance(double hours, boolean saverMode) {
        super(hours, saverMode);
    }
    @Override
    public double getPowerWatts() {
        return 150.0;
    }
    @Override
    public boolean supportsSaverMode() {
        return false;
    }
    @Override
    public String getAppName() {
        return "FRIDGE";
    }
}

class AcAppliance extends Appliance {
    public AcAppliance(double hours, boolean saverMode) {
        super(hours, saverMode);
    }
    @Override
    public double getPowerWatts() {
        return 1500.0;
    }
    @Override
    public boolean supportsSaverMode() {
        return true;
    }
    @Override
    public String getAppName() {
        return "AC";
    }
}

class TvAppliance extends Appliance {
    public TvAppliance(double hours, boolean saverMode) {
        super(hours, saverMode);
    }
    @Override
    public double getPowerWatts() {
        return 100.0;
    }
    @Override
    public boolean supportsSaverMode() {
        return false;
    }
    @Override
    public String getAppName() {
        return "TV";
    }
}

class WasherAppliance extends Appliance {
    public WasherAppliance(double hours, boolean saverMode) {
        super(hours, saverMode);
    }
    @Override
    public double getPowerWatts() {
        return 500.0;
    }
    @Override
    public boolean supportsSaverMode() {
        return true;
    }
    @Override
    public String getAppName() {
        return "WASHER";
    }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }
        int n = scanner.nextInt();
        Appliance[] apps = new Appliance[n];

        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            double hours = scanner.nextDouble();
            boolean saver = false;
            if (scanner.hasNext("SAVER")) {
                saver = true;
                scanner.next(); // consume 'SAVER' string
            }

            if (name.equalsIgnoreCase("FRIDGE")) {
                apps[i] = new FridgeAppliance(hours, saver);
            } else if (name.equalsIgnoreCase("AC")) {
                apps[i] = new AcAppliance(hours, saver);
            } else if (name.equalsIgnoreCase("TV")) {
                apps[i] = new TvAppliance(hours, saver);
            } else if (name.equalsIgnoreCase("WASHER")) {
                apps[i] = new WasherAppliance(hours, saver);
            }
        }
        scanner.close();

        double totalCost = 0;
        for (Appliance a : apps) {
            if (a.isSaverModeInvalid()) {
                System.out.println(a.getAppName() + ": saver mode not supported");
            } else {
                double units = a.calculateUnits();
                double cost = a.calculateCost();
                totalCost += cost;
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", a.getAppName(), units, cost);
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}