package lw01.unguided;

import java.util.ArrayList;
import java.util.Scanner;

// import java.util.List;
// import java.io.FileNotFoundException;
// import java.io.File;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("washes.txt"));
        ArrayList<WashService> services = new ArrayList<WashService>();

        while (scan.hasNext()) {
            String type = scan.next();
            String id = scan.next();
            int days = scan.nextInt();
            int unit = scan.nextInt();

            if (type.equals("CAR")) {
                services.add(new CarWash(id, days, unit));
            } else if (type.equals("MOTORCYCLE")) {
                services.add(new MotorcycleWash(id, days, unit));
            }
        }
        scan.close();

        for (WashService wash : services) {
            System.out.println(wash.summary());
        }
    }
    
}



// public class Main {
//     public static void main(String[] args) {
//         List<WashService> services = new ArrayList<>();

//         try (Scanner scan = new Scanner(new File("src/lw01/unguided/washes.txt"))) {
//             while (scan.hasNext()) {
//                 String type = scan.next();
//                 String id = scan.next();
//                 int days = scan.nextInt();
//                 int unit = scan.nextInt();

//                 if (type.equals("CAR")) {
//                     services.add(new CarWash(id, days, unit));
//                 } else if (type.equals("MOTORCYCLE")) {
//                     services.add(new MotorcycleWash(id, days, unit));
//                 }
//             }
//         } catch (FileNotFoundException e) {
//             System.out.println("File tidak ditemukan, coba cek lagi yayyayay.");
//         }
//     }
// }
