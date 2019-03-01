/*
Во входном файле расположен список логинов и паролей пользователей: в каждой строке один логин и один пароль. Строк не менее 10 и не более 20.
Программа пред-лагает либо войти в систему (ввести логин и пароль и проверить их корректность),
либо пройти регистрацию (ввести новые логин и пароль, и если такого логина не было, сохранить эту пару в выходной файл).
 */
 
 // Marat edited
 
 
import javax.swing.*;
import java.util.*;
import java.io.*;


public class program3dot12 {
    public static void main(String[] args) throws Exception{
        String login, pass;

        File myFile = new File("Text.txt");
        Scanner scan = new Scanner(System.in);

        try {
            if(myFile.createNewFile())
                System.out.println("Файл " + myFile.getName() + " создан");
        }
        catch(IOException e) {
            System.err.println(e);
        }

        if(myFile.exists()) {
            System.out.println(myFile.getName() + " существует");
        }

        String input = JOptionPane.showInputDialog("1.Войти\n2.Зарегистрироваться");

        if (input.equals("2")) {

            login = JOptionPane.showInputDialog("Введите логин");

            pass = JOptionPane.showInputDialog("Введите пароль");

            try {

                FileWriter fw = new FileWriter(myFile, true);
                BufferedWriter bufferWriter = new BufferedWriter(fw);

                bufferWriter.newLine();
                bufferWriter.write(login);
                bufferWriter.write(" ");
                bufferWriter.write(pass);
                bufferWriter.newLine();

                bufferWriter.close();
                fw.close();
                JOptionPane.showMessageDialog(null, "Вы успешно зарегистрировались");

            } catch (IOException e) {
                System.err.println("ошибка файла: " + e);
            }
        } else {
            login = JOptionPane.showInputDialog("Введите логин и пароль через пробел");



            try {
                FileReader fr= new FileReader("text.txt");
                Scanner scanfr = new Scanner(fr);

                while (scanfr.hasNextLine()) {
                    String userlogin = scanfr.nextLine();
                    System.out.print(userlogin);
                    if ((login.equals(userlogin))) {
                        JOptionPane.showMessageDialog(null, "Вы успешно вошли");
                    }

                }

                fr.close();

            } catch (IOException e) {
                System.err.println("ошибка файла: " + e);
            }
        }




    }

}
