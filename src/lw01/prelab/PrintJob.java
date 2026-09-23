package lw01.prelab;

public abstract class PrintJob implements Chargeable { //implement menandakan kalo printjob itu nyambung ke chargeable
    private String id; //karena pake tanda min, jadi ya dibikin private
    private int pages;

    protected PrintJob(String id, int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Jumlah halaman harus lebih dari 0 (nol).");
        } //kalau halaman yang dipesan kurang dari nol, maka kirimkan pesan illegal kalo "woy gaboleh!"

        //inisiasi yang tadi yang line 4 5 yang private itu
        this.id = id;
        this.pages = pages;
    }

    public String getId() { //buat ngambil info id yang line 4 5 yang private itu, jadi meski private dia ttp bisa ngambil
        return id;
    }

    public int getPages() { //buat ngambil info pages yang line 4 5 yang private itu, jadi meski private dia ttp bisa ngambil
        return pages;
    }

    @Override //harus di override, kalo gak nanti error
    public abstract int calculateCharge(); //karena di docs itu italic, italic = abstract. jadi dibikin abstract int trus kosongan aja ceunah teh

    public int calculateCharge(int copies) {
        if (copies <= 0) {
            throw new IllegalArgumentException("Jumlah copy harus lebih dari 0 (nol).");
        } //persis kayak yang di line 10. kalau halaman yang dipesan kurang dari nol, maka kirimkan pesan illegal kalo "woy gaboleh!"

        return copies * calculateCharge();
    }

    public String label() {
        return "Print";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
