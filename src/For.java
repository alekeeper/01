package Package01;

import java.util.HashSet;

// пример с кратким написанием цикла for

public class For {
    public static void main(String[] args) {
        HashSet<Object> hset = new HashSet<>();
        int a = 2, b = 3;
        hset.add(a);
        hset.add(b);

        for (Object c : hset) {
            System.out.println(c);
        }
        System.out.println(hset.contains(2));
        System.out.println(hset.remove(4));
    }
}
