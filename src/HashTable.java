package Package01;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        Hashtable table = new Hashtable(10);
        Scanner scanner = new Scanner(System.in);
        String lastName = "", name = "", age = "";
        boolean inputIsNotEqualsE = true;

        while (inputIsNotEqualsE) {
            System.out.println("Enter 1 to add, 2 to delete, 3 to list, E to exit: ");
            String menu = scanner.next().toUpperCase();

            if (menu.equals("1")) {
                System.out.println("Enter last name: ");
                lastName = scanner.next();
                System.out.println("Enter name: ");
                name = scanner.next();
                System.out.println("Enter age: ");
                age = scanner.next();
                table.put(lastName, lastName + " " + name + ", " + age);
            } else if (menu.equals("2")) {
                System.out.println("Enter last name you want to delete: ");
                String delete = scanner.next();
                if (table.containsKey(delete)) {
                    System.out.println(table.replace(delete, delete + " " + name + ", " + age, "empty"));
                    //System.out.println(table.remove(delete, delete + " " + name + ", " + age));
                } else {
                    System.out.println("Not found!");
                }
            } else if (menu.equals("3")) {
                Enumeration elements = table.elements();
                while (elements.hasMoreElements()) {
                    System.out.println(elements.nextElement());
                }
            } else if (menu.equals("E")) {
                break;
            }
        }
    }
}

