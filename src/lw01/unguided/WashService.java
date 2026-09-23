package lw01.unguided;

public abstract class WashService implements Billable {
    private String id;
    private int days;
    private int unit;

    protected WashService(String id, int days, int unit) {
        if (days <= 0) {
            throw new IllegalArgumentException("Hari harus lebih dari 0 (nol).");
        }

        if (unit <= 0) {
            throw new IllegalArgumentException("Unit harus lebih dari 0 (nol).");
        }

        this.id = id;
        this.days = days;
        this.unit = unit;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public int getUnit() {
        return unit;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Hari harus lebih dari 0 (nol).");            
        }

        if (unit <= 0) {
            throw new IllegalArgumentException("Unit harus lebih dari 0 (nol).");
        }

        return days * calculateCharge();
    }

    public String label() {
        return "Wash";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();        
    }
}
