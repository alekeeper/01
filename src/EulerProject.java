

public class EulerProject {
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int fiboSum = 0;
        while (true) {
            int sum = a + b;
            a = b;
            b = sum;
            System.out.println(sum);

            if (sum % 2 == 0) {
                fiboSum = fiboSum + sum;
            } else if (sum >= 4000000) {
                break;
            }
        }
        System.out.println("Сумма: " + fiboSum);
    }
}





/*
        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 | i % 5 == 0) {
                System.out.println(i);
                sum = sum + i;
            }
        }
        System.out.println("Сумма: " + sum);
        */