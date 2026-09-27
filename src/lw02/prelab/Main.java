package lw02.prelab;

import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner scan = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (scan.hasNext()) {
            String name = scan.next();
            String type = scan.next();
            String amount = scan.next();
            transactions.add(new String[]{name, type, amount});
        }

        for (String[] t : transactions) {
            String name = t[0];
            if (findCustomer(customers, name) == null) {
                customers.add(new String[]{name, "0"});
            }
        }

        queue.addAll(transactions);

        while(!queue.isEmpty()) {
            String [] t = queue.poll();
            String name = t[0];
            String type = t[1];
            int amount = Integer.parseInt(t[2]);
        
            String[] customer = findCustomer(customers, name);
            int balance = Integer.parseInt(customer[1]);

            if (type.equals("DEPOSIT")) {
                balance = balance + amount;
                customer[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    failed.push(t);
                } else {
                    balance = balance - amount;
                    customer[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String [] c : customers) {
            System.out.println(c[0] + " : " + c[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!failed.isEmpty()) {
            String[] t = failed.pop();
            System.out.println(t[0] + " " + t[1] + " " +t[2]);
        }

        scan.close();
    }

    private static String[] findCustomer(LinkedList<String[]> customers, String name) {
        for (String[] c : customers) {
            if (c[0].equals(name)) {
                return c;
            }
        }
        return null;
    }
}
