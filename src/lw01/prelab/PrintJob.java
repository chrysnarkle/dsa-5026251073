package lw01.prelab;

public abstract class PrintJob implements Chargeable {
    private String id;
    private int pages;

    protected PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Jumlah halaman harus lebih dari 0 (nol).");
        }

        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Jumlah copy harus lebih dari 0 (nol).");
        }
        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
