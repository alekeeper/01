

public class If {
    public static void main(String[] args) {

        // сокращённый вариант оператора if

        int a, b = 4, c = 3, d = 5;
        a = (b<c)|(b==d) ? d : c;

        System.out.println(a);

    }
}
