package lw01.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();

        try (Scanner scan = new Scanner(new File("src/lw01/prelab/jobs.txt"))) {
            while (scan.hasNext()) {
                String type = scan.next();
                String id = scan.next();
                int pages = scan.nextInt();

                if (type.equals("MONO")) {
                    jobs.add(new MonoPrint(id, pages));
                } else if (type.equals("COLOUR")) {
                    jobs.add(new ColourPrint(id, pages));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File tidak ditemukan, coba cek lagi yayyayay.");
        }

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }

    }
}
