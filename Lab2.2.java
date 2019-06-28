/*
Дана целочисленная прямоугольная матрица размера m×n, целые числа x,y (−m≤x≤m; −n≤y≤n).
Сдвинуть элементы исходной матрицы на x строк и y столбцов, заполняя освобождающиеся элементы нулями


Выполнил Старцев Владислав ИТ-21
 */
import java.util.*;



public class program2dot27 {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        System.out.println("Введите размеры матрицы m×n");
        int m = scn.nextInt();
        int n = scn.nextInt();

        int arr[][] = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = 1;
                System.out.print(arr[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println("Введите на сколько строк сдвинуть от -" + m + " <= x <= " + m + ": ");
        int x = scn.nextInt();

        System.out.println("Введите на сколько столбцов сдвинуть от -" + n + " <= x <= " + n + ": ");
        int y = scn.nextInt();


        if ((x >= 0)) {
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < arr[i].length; j++)
                    arr[i][j] = 0;
            }
        } else {
            int x1 = m+x;
            for (int i = x1; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        if (y >= 0) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < y; j++)
                    arr[i][j] = 0;
            }
        } else {
            int y1 = n+y;
            for (int i = 0; i < arr.length; i++) {
                for (int j = y1; j < arr[i].length; j++) {
                    arr[i][j] = 0;
                }
            }
        }


        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
