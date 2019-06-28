/*

    Гонки. На гоночной трассе находится N движущихся автомобилей,
    для каждого из ко-торых известны начальное положение и скорость. Указать первые M обгонов.

    Выполнил: Старцев Владислав ИТ-21

    Лабораторная работа выполнена с использованием коллекции TreeMap
 */

import java.util.*;
import javax.swing.*;


class Race {


    int bubbleSort(int arr[], int arr1[], boolean l, int mmm) {
        int n = arr.length;
        //System.out.println("some symbols!");
        int curd = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    // swap temp and arr[i]
                    if (l)
                        if (curd < mmm)
                            System.out.println(" машина, скорость которой равна:  " + arr1[j + 1] + " обогнала машину со скоростью: " + arr1[j]);
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    int temp1 = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp1;
                    curd += 1;

                }
        }
        //System.out.println("curd = " + curd);
        return curd;
    }

}

class lab15 {


    public static void main(String[] args) {

        Race m1 = new Race();

        boolean key = true;

        TreeMap<Integer, Integer> hashMap1 = new TreeMap<Integer, Integer>();

        String n = JOptionPane.showInputDialog("Введите количество машин N : ");

        String m = JOptionPane.showInputDialog("Введите количество обгонов М : ");

        int M = Integer.parseInt(m);

        int N = Integer.parseInt(n);

        int k = 1;

        int[] myArray_key;
        myArray_key = new int[N];

        int[] myArray_value;
        myArray_value = new int[N];

        int milk = 0;

        while (key) {

            String checked = JOptionPane.showInputDialog("выберете действие: \n1) Добавить машину\n"
                    + "3) Первые М обгонов\n" + "10)Выход ");

            if (checked.equals("10")) {
                key = false;

            } else if (checked.equals("1")) {

                if (k <= N) {
                    String car_speed = JOptionPane.showInputDialog("Введите скорость машины");
                    String car_posit = JOptionPane.showInputDialog("Введите начальное положение машины");
                    int speed = Integer.parseInt(car_speed);
                    int posit = Integer.parseInt(car_posit);
                    hashMap1.put(speed, posit);
                    k += 1;
                } else if (k > N) JOptionPane.showMessageDialog(null, "Слишком много машин!");


                System.out.println(Arrays.toString(myArray_value));
                System.out.println();

            } else if (checked.equals("3")) {
                for (int i = 0; i < N; i++) {
                    if (myArray_key[i] == 0) {
                        JOptionPane.showMessageDialog(null, "Добавьте машин!");
                        key = false;
                        break;
                    }
                }


                int index = 0;
                for (Map.Entry<Integer, Integer> pair : hashMap1.entrySet()) {
                    myArray_value[index] = pair.getValue();
                    myArray_key[index] = pair.getKey();
                    index++;
                }

                boolean lie = false;
                m1.bubbleSort(myArray_value, myArray_key, lie, M);
                lie = true;
                milk = 0;
                while (milk < M) {
                    for (int i = 0; i < 3; i++) {
                        myArray_value[i] += myArray_key[i];

                    }
                    milk = m1.bubbleSort(myArray_value, myArray_key, lie, M);
                }


            }


        }
    }
}


