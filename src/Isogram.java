import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Isogram {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //Scanner scanner = new Scanner(System.in);
        System.out.println("Please write an isogram word: ");
        String text = reader.readLine();

        char[] charArray = text.toCharArray();

        while (true) {
            for (int i = 0; i < text.length(); i++) {
                for (int j = 0; j < text.length(); j++) {
                    if (charArray[j] == text.charAt(i) && i != j) {
                        System.out.println("Not an isogram!");
                        return;
                    }
                }
            }
            System.out.println("ISOGRAM!");
            break;
        }
    }
}



