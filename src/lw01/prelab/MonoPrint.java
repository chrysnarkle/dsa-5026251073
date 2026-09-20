package lw01.prelab;

public class MonoPrint extends PrintJob {
    public MonoPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        return getPages() * 500;
    }

    @Override 
    public String label() {
        return "Mono";
    }
}
