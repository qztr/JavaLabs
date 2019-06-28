
/*Даны два массива - список фамилий и список имён работников предприятия. 
 * Отсортировать список работников в алфавитном порядке, то есть в случае совпадения фамилии сравнивать
 *  работников по имени 
 
  
Выполнил Старцев Владислав ИТ-21
 */

public class main {
	public static void main(String[] args) {
		String[] names = new String[] { "Bri", "Irene", "Matu", "Sanja", "Bri" };
		String[] secondnames = new String[] { "Castaneda", "Veneziano", "Martinez", "Sancin", "Polanco" };
		/*
		 * значение меньше 0, если аргумент является строкой лексически большей, чем
		 * сравниваемая строка; и значение больше 0, если аргумент является строкой
		 * лексически меньшей этой строки.
		 */
		// та, относительно которой реультат- перед точкой
		for (int j = 0; j < names.length; j++) {
			for (int i = j + 1; i < names.length; i++) {
				if (names[i].compareTo(names[j]) < 0) {			/// 	посимвольное сравнение с учетом регистра
					String k = names[j];						///
					names[j] = names[i];						///		сортировка в массиве имен, их перестановки 
					names[i] = k;								///		и перестановки в массиве фамилий в соответствии с именами
					String f = secondnames[j];					///
					secondnames[j] = secondnames[i];			///
					secondnames[i] = f;							///
				} else if (names[i].compareTo(names[j]) == 0) { 			/// 	если найдено совпадение имен, 
					if (secondnames[i].compareTo(secondnames[j]) < 0) {		///		сравниваем посимвольно фамилии
						String k = names[j];								///		аналогичные перестановки
						names[j] = names[i];								///
						names[i] = k;
						String f = secondnames[j];
						secondnames[j] = secondnames[i];
						secondnames[i] = f;
					}
				}

			}
		}
		for (int j = 0; j < names.length; j++) {
			System.out.println(names[j] + " " + secondnames[j]);
		}
	}
}
