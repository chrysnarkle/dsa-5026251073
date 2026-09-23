package lw01.prelab;

public class MonoPrint extends PrintJob {
    public MonoPrint(String id, int pages) {
        super(id, pages);
    }

    @Override
    public int calculateCharge() {
        return getPages() * 500; //masukkin harga si monoprint, seperti yg di state di soal
    }

    @Override 
    public String label() {
        return "Mono"; //masukin info kalo apa yang di print ini itu mono
    }
}
