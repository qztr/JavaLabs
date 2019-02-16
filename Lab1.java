
/* Вводить с клавиатуры последовательность вещественных чисел до 0 (сам 0 не входит в
последовательность). Найти второе максимальное значение из них (если оно есть).
Вывести результат на консоль.
 * */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class main {
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
		if (list.size() > 1) {
			System.out.println(list.get(list.size() - 2));
		} else if (list.size() <= 1)
			System.out.println(list);

	}
}
