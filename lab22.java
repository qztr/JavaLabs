/**
 * Дана вещественная прямоугольная матрица. В каждой строке найти сумму элементов,
 упорядочить строки матрицы по убыванию таких сумм.
 не сдавать
 */

import java.util.*;
//package array1;


public class Main {

    static int[][] masA = new int[3][3];

    public static void randMas(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                masA[i][j] = (int) (Math.random() * 9);
            }
        }
    }

    public static void Output(int[][] array) {
        for (int[] array1 : array) {
            for (int j = 0; j < array1.length; j++) {
                System.out.print(array1[j] + "\t");
            }
            System.out.println();
        }
    }


    public static void etalonMatrix(int[][] convertToMatrix) {

        int b = 0;
        int k = 0;
        int j = 0;
        int i = 0;
        int[] sum = new int[4];
        int[][] mas = convertToMatrix;
        int s = 0;
        for (i = 0; i < 3; i++) {
            s = 0;
            //System.out.println("zah2");
            for (j = 0; j < 3; j++) {
                //System.out.println(mas[i][j]);
                //System.out.println("i= " + i);
                sum[i] = sum[i] + mas[i][j];
            }
            //System.out.println("sum= "+sum[i]);
        }

        for (i = 0; i < 3; i++) {
            for (k = 0; k < 3; k++) {
                if (sum[k] > sum[k + 1]) {
                    b = sum[k];
                    sum[k] = sum[k + 1];
                    sum[k + 1] = b;
                }
            }
         /// где-то здесь ошибка =)
            /*for (j = 0; j < 3; j++) {
                b = mas[k][j];
                mas[k][j] = mas[k + 1][j];
                mas[k + 1][j] = b;

            }*/
        }
        for (i=0;i<3;i++){
            System.out.print(sum[i]+" ");
        }

    }


    public static void main(String[] args) {

        System.out.println("Изначальный массив:");
        randMas(masA);
        Output(masA);

        System.out.println();
        System.out.print("Отсортированный массив:");
        System.out.println();
        etalonMatrix(masA);
        //sort(masA);
        System.out.println();
        Output(masA);
    }
}



