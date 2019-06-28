/* Вводить с клавиатуры последовательность вещественных чисел до 0 (сам 0 не входит в
последовательность). Найти второе максимальное значение из них (если оно есть).
Вывести результат на консоль.

Выполнил Старцев Владислав ИТ-21
 * */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner in = new Scanner(System.in);
        int count = 0;
        int num = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        do {
            System.out.println("enter num: ");
            num = in.nextInt();
            if (num == 0)
                break;
            list.add(count, num);
            count++;
        } while (num != 0);

        Collections.sort(list);
/// ===========================================

        System.out.println(list);
        //System.out.println(list.get(1));
        //System.out.println(list.get(list.size() - 1)); /// последний элемент в list!
        int kee = list.size();


        if (list.size() > 1) {
            for (int i = 1; i < list.size(); i++) {
                //System.out.println(list.get(list.size() - i - 1) + "  last");
                //System.out.println(list.get(list.size() - i) + " last -1");


                if (list.get(list.size() - i) > list.get(list.size() - i - 1)) {
                    System.out.println(list.get(list.size() - i - 1) + " <- 2nd max");
                    break;
                } else if ((list.get(list.size() - i) == list.get(list.size() - i - 1)) && (i == (list.size() - 1))) {
                    System.out.print(" max net");
                }

            }
        } else if (list.size() <= 1)
            System.out.println(" max net");
        System.out.println();

    }
}
