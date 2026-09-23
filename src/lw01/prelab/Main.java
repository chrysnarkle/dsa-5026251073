// hasil pekerjaan sendiri
// package lw01.prelab;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.ArrayList;
// import java.util.List;
// import java.util.Scanner;

// public class Main {
//     public static void main(String[] args) {
//         List<PrintJob> jobs = new ArrayList<>();

//         try (Scanner scan = new Scanner(new File("src/lw01/prelab/jobs.txt"))) {
//             while (scan.hasNext()) {
//                 String type = scan.next();
//                 String id = scan.next();
//                 int pages = scan.nextInt();

//                 if (type.equals("MONO")) {
//                     jobs.add(new MonoPrint(id, pages));
//                 } else if (type.equals("COLOUR")) {
//                     jobs.add(new ColourPrint(id, pages));
//                 }
//             }
//         } catch (FileNotFoundException e) {
//             System.out.println("File tidak ditemukan, coba cek lagi yayyayay.");
//         }

//         for (PrintJob job : jobs) {
//             System.out.println(job.summary());
//         }

//     }
// }

// hasil pembahasan di kelas
package lw01.prelab;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        ArrayList<PrintJob> jobs = new ArrayList<PrintJob>();

        while (scanner.hasNext()) {
            String type = scanner.next();
            String id = scanner.next();
            int pages = scanner.nextInt();

            if (type == "MONO") {
                jobs.add(new MonoPrint(id, pages));
            } else if (type == "COLOUR") {
                jobs.add(new ColourPrint(id, pages));
            }
        }
        scanner.close();

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }

    }
}
