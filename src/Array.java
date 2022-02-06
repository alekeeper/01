
//проверка
public class Array {
    public static void main(String[] args) {

        // Определить длину/ширину/глубину массива

        int[][][] array = new int[12][44][65];

        System.out.println(array.length + "\n");


        int[][] subArray = array[0];
        System.out.println(subArray.length);
        System.out.println(subArray[0].length);
        System.out.println("\n");


        // Другой вариант массива

        int[][] arr = new int[][]{{1, 2, 3}, {4, 9, 6}, {7, 8, 9}};
        System.out.println(arr.length);
        System.out.println(arr[0].length);
        // для трёхмерного массива: System.out.println(arr[0][0].length);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println(" ");

        // Использование OutterLoop/InnerLoop для выхода из цикла после обнаружения первой "девятки"

        OutterLoop:
        for (int ii = 0; ii < arr.length; ii++) {
            InnerLoop:
            for (int jj = 0; jj < arr.length; jj++) {
                if (arr[ii][jj] == 9) {
                    System.out.println(ii + " " + jj);
                    break OutterLoop;
                }

            }
        }
        System.out.println(" ");

    }
}
