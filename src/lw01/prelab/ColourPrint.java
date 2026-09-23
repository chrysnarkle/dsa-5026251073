package lw01.prelab;

public class ColourPrint extends PrintJob {
    public ColourPrint(String id, int pages) {
        super(id, pages);
    }

    @Override 
    public int calculateCharge() {
        int pages = getPages();
        int biaya;

        if (pages <=10) {
            biaya = pages * 1500; //kalo pages kurang dari 10, maka harganya 1500 per pages
        } else {
            biaya = (10 * 1500) + ((pages - 10) * 1000); //kalo pages lebih dari 10, ambil yang 10 dulu, kaliin sama 1500, trus sisanya dihargain 1000 per pages
        }

        return biaya + 2000;
    }

    @Override 
    public String label() {
        return "Colour"; //ngasi label kalo apa yg di printini tuh yang colour
    }
}
