

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Homework2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String horizontalString = new String(), verticalString = new String();
        boolean inputIsIncorrect = true;
        Pattern pattern = Pattern.compile("\\D*");

        while (inputIsIncorrect) {
            System.out.println("Enter amount of rows in matrix: ");
            horizontalString = scanner.nextLine();
            Matcher matcherHorizontal = pattern.matcher(horizontalString);

            System.out.println("Enter amount of columns in matrix: ");
            verticalString = scanner.nextLine();
            Matcher matcherVertical = pattern.matcher(verticalString);

            if (matcherHorizontal.matches())
                System.out.println("Wrong symbol of rows! Enter a positive number!");
            else if (matcherVertical.matches())
                System.out.println("Wrong symbol of columns! Enter a positive number!");
            else {
                break;
            }
        }

        int horizontalInt = Integer.parseInt(horizontalString);
        int verticalInt = Integer.parseInt(verticalString);

        String[][] array = new String[horizontalInt][verticalInt];
        for (int i = 0; i < horizontalInt; i++) {
            for (int j = 0; j < verticalInt; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("\n");

        String rowString = new String(), columnString = new String();
        Matcher matcherRow, matcherColumn;
        int rowInt, columnInt;

        while (inputIsIncorrect) {
            System.out.println("Enter index of row you want to rewrite: ");
            rowString = scanner.nextLine();
            matcherRow = pattern.matcher(rowString);

            System.out.println("Enter index of column you want to rewrite: ");
            columnString = scanner.nextLine();
            matcherColumn = pattern.matcher(columnString);

            if (matcherRow.matches() | matcherColumn.matches()) {
                System.out.println("Wrong symbol! Enter a positive number!");
            } else if (!matcherRow.matches() | !matcherColumn.matches()) {
                rowInt = Integer.parseInt(rowString);
                columnInt = Integer.parseInt(columnString);

                if (rowInt >= horizontalInt | columnInt >= horizontalInt) {
                    System.out.println("Index of row/column should be less than value of row!");
                } else {
                    break;
                }
            } else {
                    break;
                }
            }

        rowInt = Integer.parseInt(rowString);
        columnInt = Integer.parseInt(columnString);

        Scanner scannerLine = new Scanner(System.in);
        System.out.println("Enter a value you want to rewrite: ");
        String value = scannerLine.nextLine();

        array[rowInt][columnInt] = value;

        for (int i = 0; i < horizontalInt; i++) {
            for (int j = 0; j < verticalInt; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}