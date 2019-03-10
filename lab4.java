/*
* Кинопоиск. Фильмотека кинопоиска хранит информацию о кинофильмах. Каждый
фильм имеет: название год выпуска, киностудию. Режиссер, оператор,актеры имеют Имя и Фамилию.
Cтандартные запросы : поиск фильмов конкретной
личности и его роль в каждом фильме, поиск личностей и их роли для конкретного
фильма и подобные
*
* */

import java.util.ArrayList;
import javax.swing.*;

class Film {
    private String name;
    private String date;
    private String studio;
    private String actorName; // создадим 1 актера, который снялся в главной роли
    private String actorName1;
    private String actorName2;
    private String actorName3;
    private String actorBD;
    private String actorBD1;
    private String actorBD2;
    private String actorBD3;
    private String operatorName;
    private String operatorBD;
    private String producerName;
    private String producerBD;

    Film(String name, String date, String studio, String actorName, String actorBD, String operatorName, String operatorBD,
         String producerName, String producerBD) {
        this.name = name;
        this.date = date;
        this.studio = studio;
        this.actorName = actorName;
        this.actorBD = actorBD;
        this.operatorName = operatorName;
        this.operatorBD = operatorBD;
        this.producerName = producerName;
        this.producerBD = producerBD;
    }

    public String getActorBD() {
        return actorBD;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getOperatorBD() {
        return operatorBD;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public String getProducerBD() {
        return producerBD;
    }

    public String getProducerName() {
        return producerName;
    }

    public String getStudio() {
        return studio;
    }

    public String getActorName1() {
        return actorName1;
    }

    public String getActorName2() {
        return actorName2;
    }

    public String getActorName3() {
        return actorName3;
    }

    // актер вторая главная роль
    public void setActorName1(String actorName) {
        this.actorName1 = actorName;
    }

    public void setActorBD1(String actorBD) {
        this.actorBD1 = actorBD;
    }

    // 3 гл роль
    public void setActorName2(String actorName) {
        this.actorName2 = actorName;
    }

    public void setActorBD2(String actorBD) {
        this.actorBD2 = actorBD;
    }

    // втроая роль
    public void setActorName3(String actorName) {
        this.actorName3 = actorName;
    }

    public void setActorBD3(String actorBD) {
        this.actorBD3 = actorBD;
    }

    boolean isActor(String some) {
        return some.equals(this.actorName);
    }

    boolean isActor1(String some) {
        return some.equals(this.actorName1);
    }

    boolean isActor2(String some) {
        return some.equals(this.actorName2);
    }

    boolean isActor3(String some) {
        return some.equals(this.actorName3);
    }

    String allActors() {
        return (getActorName() + ", " + getActorName1() + ", " + getActorName2() + ", " + getActorName3());
    }

}


public class Main {
    public static void main(String[] args) {
        Film brat = new Film("Brat", "1999", "ABC", "Сергей Бодров", "1971",
                "Алексей Балабанов", "1975", "Вечаслав Бутусов", "1970");

        brat.setActorName1("Светлана Письмиченко");
        brat.setActorName3("Виктор Сухоруков");
        brat.setActorName2("Мария Жукова");

        Film hulk = new Film("Space Invaders", "1989", "Disney", "Walt Disney", "1950",
                "Mickey Walkey", "1955", "Warren Buffet", "1930");

        hulk.setActorName3("Green Man");
        hulk.setActorName2("Iron Man");
        hulk.setActorName1("Captain America");

        ArrayList<Film> Kinopoisk = new ArrayList<>();
        Kinopoisk.add(brat);
        Kinopoisk.add(hulk);

        boolean key = true;

        while (key) {
            String checked = JOptionPane.showInputDialog("выберете действие: \n1) Найти фильм, в котором снимался актер\n" +
                    "2)Найти всех актеров фильма\n" + "10)Выход");

            if (checked.equals("10")) {
                key = false;
            } else if (checked.equals("1")) {
                String nameSearch = JOptionPane.showInputDialog("Актеры доступные для поиска:\n" +
                        "-Fedor Bondarchuk\n" + "-Сергей Бодров\n" + "-Walt Disney\n-Green Man\n" +
                        " \nВведите Имя и Фамилию актера для поиска: \n");

                for (Film film : Kinopoisk) {
                    if (film.isActor(nameSearch))
                        JOptionPane.showMessageDialog(null, nameSearch + " is acted here:\n" + film.getName() + "\n" +
                                " as main actor");
                    if (film.isActor1(nameSearch))
                        JOptionPane.showMessageDialog(null, nameSearch + " is acted here:\n" + film.getName() + "\n" +
                                " as second main actor");
                    if (film.isActor2(nameSearch))
                        JOptionPane.showMessageDialog(null, nameSearch + " is acted here:\n" + film.getName() + "\n" +
                                " as third main actor");
                    if (film.isActor3(nameSearch))
                        JOptionPane.showMessageDialog(null, nameSearch + " is acted here:\n" + film.getName() + "\n" +
                                " as second actor");

                }
            } else if (checked.equals("2")) {
                checked = JOptionPane.showInputDialog(null, "Фильмы: \n1)Brat\n2)Space Invaders");
                if (checked.equals("1")) {
                    JOptionPane.showMessageDialog(null, brat.allActors());
                }
                if (checked.equals("2")) {
                    JOptionPane.showMessageDialog(null, hulk.allActors());
                }
            }
        }
    }


}

