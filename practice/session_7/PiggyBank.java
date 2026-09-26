package practice.session_7;

public class PiggyBank {
    private final String id;
    private double savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("Deposited: " + amount + " | Current Savings: " + this.savings);
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Amount must be positive.");
        } else if (amount > this.savings) {
            System.out.println("Withdrawal of " + amount + " rejected: Insufficient savings (Current: " + this.savings + ").");
        } else {
            this.savings -= amount;
            System.out.println("Withdrew: " + amount + " | Current Savings: " + this.savings);
        }
    }

    public double getSavings() {
        return this.savings;
    }

    public String getId() {
        return this.id;
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}