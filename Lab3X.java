/*
Во входном файле расположен список логинов и паролей пользователей: в каждой строке один логин и один пароль. Строк не менее 10 и не более 20.
Программа пред-лагает либо войти в систему (ввести логин и пароль и проверить их корректность),
либо пройти регистрацию (ввести новые логин и пароль, и если такого логина не было, сохранить эту пару в выходной файл).
 */
 
 import javax.swing.*;
import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.SortedSet;
import java.util.TreeSet;


public class Main {
    public static void main(String[] args) throws Exception {
        String login, pass;

        File myFile = new File("Text.txt");
        Scanner scan = new Scanner(System.in);

        try {
            if (myFile.createNewFile())
                System.out.println("Файл " + myFile.getName() + " создан");
        } catch (IOException e) {
            System.err.println(e);
        }

        if (myFile.exists()) {
            System.out.println(myFile.getName() + " существует");
        }

        String input = JOptionPane.showInputDialog("1.Войти\n2.Зарегистрироваться");


        if (input.equals("2")) {

            login = JOptionPane.showInputDialog("Введите логин");

            pass = JOptionPane.showInputDialog("Введите пароль");

            try {

                FileWriter fw = new FileWriter(myFile, true);
                BufferedWriter bufferWriter = new BufferedWriter(fw);


                boolean cc = false; // flag zanyatogo logina
                int kot = 0; // флаг
                File file = new File("Text.txt");
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while (!cc) {
                    while ((line = bufferedReader.readLine()) != null) {
                        // разбиваем строку, храняущю логин и пароль на слова и проверяем повторы логина
                        Pattern pattern = Pattern.compile("\\w+", Pattern.UNICODE_CHARACTER_CLASS
                                | Pattern.CASE_INSENSITIVE);
                        Matcher matcher = pattern.matcher(line);
                        SortedSet<String> words = new TreeSet<>();

                        while (matcher.find())
                            words.add(matcher.group().toLowerCase());

                        for (String word : words) {
                            // если логин занят выводим сообщение, опускаем флаги
                            if (login.equals(word)) {
                                JOptionPane.showMessageDialog(null, "Логин занят," +
                                        " повторите регистрацию ");
                                cc = true;
                                kot = 1;

                            }
                        }
                    }
                    cc = true;
                }

                if (kot == 0) {
                    bufferWriter.newLine();
                    bufferWriter.write(login);
                    bufferWriter.write(" ");
                    bufferWriter.write(pass);
                    bufferWriter.newLine();

                    bufferWriter.close();
                    fw.close();
                    JOptionPane.showMessageDialog(null, "Вы успешно зарегистрировались\n" +
                            "Перезапустите программу, для авторизации");
                }

            } catch (IOException e) {
                System.err.println("ошибка файла: " + e);
            }
        } else {
            login = JOptionPane.showInputDialog("Введите логин и пароль через пробел");
            try {
                FileReader fr = new FileReader("Text.txt");
                Scanner scanfr = new Scanner(fr);
                boolean cat = false;

                while (scanfr.hasNextLine()) {
                    String userlogin = scanfr.nextLine();
                    //System.out.print(userlogin);
                    if ((login.equals(userlogin))) {
                        JOptionPane.showMessageDialog(null, "Вы успешно вошли");
                        cat = true;
                    }
                }
                if (!cat) {
                    JOptionPane.showMessageDialog(null, "Некорректный логин\n" +
                            "повторите авторизацию");
                }

                fr.close();

            } catch (IOException e) {
                System.err.println("ошибка файла: " + e);
            }
        }
    }
}
