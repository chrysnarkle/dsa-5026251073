package lw01.unguided;

public class MotorcycleWash extends WashService {
    public MotorcycleWash(String id, int days, int unit) {
        super(id, days, unit);
    }

    @Override
    public int calculateCharge() {
        return ((getDays() * 15000) + 5000) * getUnit();
    }

    @Override
    public String label() {
        return "Motorcycle";
    }
} 
