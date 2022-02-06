

import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VectorClass {
    public static void main(String[] args) {
        Vector vector = new Vector(1,1);
        Scanner scanner = new Scanner(System.in);
        String amountString;

        while (true) {
            System.out.println("Enter amount of elements in vector: ");
            amountString = scanner.nextLine();
            Pattern pattern = Pattern.compile("\\D*");
            Matcher matcher = pattern.matcher(amountString);
            if (matcher.matches()) {
                System.out.println("Wrong symbol! You should enter a positive number.");
            } else {
                break;
            }
        }
        int amountInt = Integer.parseInt(amountString);
        vector.ensureCapacity(amountInt);

        for (int i = 1; i <= amountInt; i++) {
            vector.add("test");
        }
        System.out.println("Content: " + vector);
        System.out.println("Capacity: " + vector.capacity());
        System.out.println("Size: " + vector.size());
    }
}