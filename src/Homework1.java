

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1, num2;
        Pattern pt1, pt2;
        Matcher mt1, mt2;
        while (true) {
            //do {
            System.out.println("Enter first number: ");
            num1 = sc.nextLine().toUpperCase();
            pt1 = Pattern.compile("[^Ee0-9]*");
            mt1 = pt1.matcher(num1);
            if (num1.equals("E"))
                return;
            if (mt1.matches()) {
                System.out.println("It's not a number!");
                continue;
            }
            System.out.println("Enter second number: ");
            num2 = sc.nextLine().toUpperCase();
            pt2 = Pattern.compile("[^Ee0-9]*");
            mt2 = pt2.matcher(num2);
            if (num2.equals("E"))
                return;
            if (mt2.matches()) {
                System.out.println("It's not a number!");
                continue;
            }
            //} while (mt1.matches() | mt2.matches());
            int aa = Integer.parseInt(num1);
            int bb = Integer.parseInt(num2);
            for (int i = aa; i <= bb; i++) {
                if (i % 5 == 0) {
                    System.out.println("Divisible to \"5\": " + i + " .");
                }
            }
            System.out.println("To finish press \"E\"");
        }
    }
}
