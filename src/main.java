

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i, j;
        String horizontal, vertical;
        Pattern pt1 = Pattern.compile("[^1-9]*");
        Matcher mt, mt2;

        do {
            System.out.println("Enter amount of rows in matrix: ");
            horizontal = sc.nextLine();
            mt = pt1.matcher(horizontal);
            if (mt.matches())
                System.out.println("Please enter a positive number.");
        } while (mt.matches());

        do {
            System.out.println("Enter amount of columns in matrix: ");
            vertical = sc.nextLine();
            mt2 = pt1.matcher(vertical);
            if (mt2.matches())
                System.out.println("Please enter a positive number.");
        } while (mt2.matches());

        int h = Integer.parseInt(horizontal);
        int v = Integer.parseInt(vertical);

        String[][] array = new String[h][v];
        for (i = 0; i < h; i++) {
            for (j = 0; j < v; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        String row, column;
        Pattern pt2 = Pattern.compile("\\D*");
        Matcher mt3, mt4;
        //int r, c;

        do {
            System.out.println("Enter index of row you want to rewrite: ");
            row = sc.nextLine();
            mt3 = pt2.matcher(row);
            if (mt3.matches())
                System.out.println("Please enter a positive number.");
            if (Integer.parseInt(row) >= h)
                System.out.println("Index of row can't be equal or bigger than amount of rows.");
        } while (mt3.matches() | Integer.parseInt(row) >= h);

        do {
            System.out.println("Enter index of column you want to rewrite: ");
            column = sc.nextLine();
            mt4 = pt2.matcher(column);
            if (mt4.matches())
                System.out.println("Please enter a positive number.");
            if (Integer.parseInt(column) >= v)
                System.out.println("Index of row can't be equal or bigger than amount of rows.");
        } while (mt4.matches() | Integer.parseInt(column) >= v);

        //r = Integer.parseInt(row);
        //c = Integer.parseInt(column);
        //if (r >= h)
        //    System.out.println("Index of row can't be equal or bigger than amount of rows.");
        //if (c >= v)
        //    System.out.println("Index of column can't be equal or bigger than amount of columns.");

        System.out.println("Enter a value you want to rewrite: ");
        String value = sc.nextLine();

        array[Integer.parseInt(row)][Integer.parseInt(column)] = value;

        for (
                int ii = 0;
                ii < h; ii++) {
            for (int jj = 0; jj < v; jj++) {
                System.out.print(array[ii][jj] + " ");
            }
            System.out.println(" ");
        }
    }
}
