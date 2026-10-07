package lw03.unguided;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanreg = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        Scanner scanch = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        Set<String> studentids = new LinkedHashSet<>();

        while (scanreg.hasNextLine()) {
            String id = scanreg.nextLine();
                studentids.add(id);
            }
    
        List<String> checkins = new ArrayList<>();
        List<String> result = new ArrayList<>();

        int successfulCheckins = 0;
        int rejectedCheckins = 0;  

        while (scanch.hasNextLine()) {          
            String checkin = scanch.nextLine();

            if(!studentids.contains(checkin)) {
                result.add(checkin + ": Rejected (not registered)");
                rejectedCheckins++;
            } else if (checkins.contains(checkin)) {
                result.add(checkin + ": Rejected (already checked in)");
                rejectedCheckins++;
            } else {
                result.add(checkin + ": Checked in");
                checkins.add(checkin);
                successfulCheckins++;
            }
        }
        scanch.close();
        scanreg.close();

        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + studentids.size());
        System.out.println("Successful check-ins: " + successfulCheckins);
        System.out.println("Absent students: " + (studentids.size() - successfulCheckins));
        System.out.println("Rejected attempts: " + rejectedCheckins);
    }
}