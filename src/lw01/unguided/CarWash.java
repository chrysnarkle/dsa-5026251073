package lw01.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int unit) {
        super(id, days, unit);
    }

    @Override 
    public int calculateCharge() {
        int days = getDays();
        int unit = getUnit();
        int biaya;

        if (days <= 3) {
            biaya = days * 35000;
        } else {
            biaya = (3 * 35000) + ((days - 3) * 25000);
        }
        return (biaya + 15000) * unit;
    }

    @Override
    public String label() {
        return "Car";
    }
}
