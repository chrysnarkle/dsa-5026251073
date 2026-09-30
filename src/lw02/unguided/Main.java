package lw02.unguided;

import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();

        LinkedList<String[]> foods = new LinkedList<>();
        foods.add(new String[]{"Bakso", "2"});
        foods.add(new String[]{"Sate", "1"});
        foods.add(new String[]{"Soto", "2"});

        LinkedList<String[]> drinks = new LinkedList<>();
        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        Scanner scan = new Scanner(Main.class.getResourceAsStream("orders.txt"));
        while (scan.hasNext()) {
            String[] order = new String[4];
            order[0] = scan.next();
            order[1] = scan.next();
            order[2] = scan.next();
            order[3] = scan.next();
            orders.add(order);
        }
        scan.close();

        Queue<String[]> queue = new LinkedList<>();
        LinkedList<String[]> successOrders = new LinkedList<>();
        Stack<String[]> failedOrders = new Stack<>();
        for (int i = 0; i < orders.size(); i++) {
            queue.add(orders.get(i));
        }

        String[] order = queue.poll();
        while (order != null) {
            String[] food = null;
            String[] drink = null;
            boolean available = true;

            if (!order[1].equals("-")) {
                food = findItem(foods, order[1]);
                if (food == null || Integer.parseInt(food[1]) <= 0) {
                    available = false;
                }
            }

            if (!order[2].equals("-")) {
                drink = findItem(drinks, order[2]);
                if (drink == null || Integer.parseInt(drink[1]) <= 0) {
                    available = false;
                }
            }

            if (available) {
                if (food != null) {
                    food[1] = String.valueOf(Integer.parseInt(food[1]) - 1);
                }
                if (drink != null) {
                    drink[1] = String.valueOf(Integer.parseInt(drink[1]) - 1);
                }
                successOrders.add(order);
            } else {
                failedOrders.push(order);
            }
            order = queue.poll();
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (int i = 0; i < successOrders.size(); i++) {
            String[] o = successOrders.get(i);
            System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (int i = 0; i < foods.size(); i++) {
            String[] f = foods.get(i);
            System.out.println(f[0] + " : " + f[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (int i = 0; i < drinks.size(); i++) {
            String[] d = drinks.get(i);
            System.out.println(d[0] + " : " + d[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        int failedCount = failedOrders.size();
        for (int i = 0; i < failedCount; i++) {
            String[] o = failedOrders.pop();
            System.out.println(o[0] + " " + o[1] + " " + o[2] + " " + o[3]);
        }
    }

    private static String[] findItem(LinkedList<String[]> list, String name) {
        for (int i = 0; i < list.size(); i++) {
            String[] item = list.get(i);
            if (item[0].equals(name)) {
                return item;
            }
        }
        return null;
    }
}