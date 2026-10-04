package lw03.prelab;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        problem1();
        problem2();
        problem3();
    }

    public static void problem1() {
        System.out.println("===== Problem 1 =====");

        List<String> playlist = new ArrayList<>();

        Scanner scan = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(" ", 2);
            String command = parts[0];

            if (command.equals("ADD")) {
                playlist.add(parts[1]);
            } else if (command.equals("INSERT")) {
                String[] insertParts = parts[1].split(" ", 2);
                int index = Integer.parseInt(insertParts[0]);
                playlist.add(index, insertParts[1]);
            } else if (command.equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        scan.close();

        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

    public static void problem2() {
        System.out.println("===== Problem 2 =====");

        Set<String> participants = new LinkedHashSet<>();
        int duplicateCount = 0;

        Scanner scan = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (scan.hasNextLine()) {
            String name = scan.nextLine();
            if (!participants.add(name)) {
                duplicateCount++;
            }
        }

        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate registrations: " + duplicateCount);
    }

    public static void problem3() {
        System.out.println("===== Problem 3 =====");

        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;

        Scanner scan = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] parts = line.split(" ", 2);
            String command = parts[0];

            if (command.equals("ADD")) {
                String[] stockParts = parts[1].split(" ", 2);
                String itemName = stockParts[0];
                int quantity = Integer.parseInt(stockParts[1]);
                stock.put(itemName, stock.getOrDefault(itemName, 0) + quantity);
            } else if (command.equals("SELL")) {
                String[] sellParts = parts[1].split(" ", 2);
                String itemName = sellParts[0];
                int quantity = Integer.parseInt(sellParts[1]);

                if (stock.containsKey(itemName) && stock.get(itemName) >= quantity) {
                    stock.put(itemName, stock.get(itemName) - quantity);
                } else {
                    failedSales++;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : stock.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Failed sales: " + failedSales);

        scan.close();
    }
}
