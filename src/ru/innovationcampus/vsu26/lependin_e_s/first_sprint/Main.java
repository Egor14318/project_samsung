package ru.innovationcampus.vsu26.lependin_e_s.first_sprint;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int personLive = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */
//
        String monster = "\uD83E\uDDDF\u200D";
        int sizeBoard = 5;
        int personX = 1;
        int personY = 5;
        int monsterY = 2;
        int step = 0;

        // \n, \t - как спец символ(упомянуть)
        String castle = "\uD83C\uDFF0";


        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();
        System.out.println("Ваш ответ:\t" + answer);
        int castleY = 1;

        Random random = new Random();

        int castleX = 1 + random.nextInt(sizeBoard);
        int monsterX = 1 + random.nextInt(sizeBoard);

        String[][] board = new String[sizeBoard][sizeBoard];


        String leftBlock = " | ";
        String rightBlock = " |";
        String wall = " + —— + —— + —— + —— + —— + ";


        for (int y=1;y<=sizeBoard;y++)
        {
            for (int x=1;x<=sizeBoard;x++)
            {
                int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;
                for (int i = 0; i <= count_monster; i++) {
                    board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
                }
            }
        }
        /*        for (int y = 1; y <= sizeBoard; y++) {
            System.out.println(wall);
            for (int x = 1; x <= sizeBoard; x++) {
                System.out.print(leftBlock);
                if (personY == y && personX == x) {
                    System.out.print(person);
                } else if (castleX == x && castleY == y) {                                //это старый фор для ввода через ифы без массивов
                    System.out.print(castle);
                }else if (monsterX == x && monsterY == y) {
                        System.out.print(monster);
                 }else {
                    System.out.print("  ");
                }
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);
*/
        while ((personLive > 0) && !(castleX == personX && castleY == personY)) {

            // логика хода
            //int personX = 1;
            //        int personY = 3;


        }
        System.out.println("Закончились жизни. Итог: ...");


        //        if (answer.equals("ДА")) {

//        System.out.println("Выбери сложность игры(от 1 до 5):");
//        int difficultGame = sc.nextInt();
//        System.out.println("Выбранная сложность:\t" + difficultGame);
//            System.out.println("Сколько жизней будет у персонажа?");
////            personLive = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)
//            System.out.println(output_str);
//            System.out.println("Live:\t" + personLive + "\n");
//
//            System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
//                    "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            System.out.println(x + ", " + y);
//
//            // проверка
//            if (x != personX && y != personY) {
//                System.out.println("Неккоректный ход");
//            } else if (Math.abs(x - personX) == 1) {
//                personX = x;
//                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY);
//            } else if (Math.abs(y - personY) == 1) {
//                personY = y;
//                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY);
//            }else {
//                System.out.println("Координаты не изменены");
//            }
//
//        } else if (answer.equals("НЕТ")) {
//            System.out.println("Жаль, приходи еще!");
//        } else {
//            System.out.println("Данные введены неккоректно");
//        }

/*        switch (answer) {
            case "ДА" -> {
                System.out.println("Выбери сложность игры(от 1 до 5):");
                int difficultGame = sc.nextInt();
                System.out.println("Выбранная сложность:\t" + difficultGame);
//                System.out.println("Сколько жизней будет у персонажа?");
//            personLive = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)

                System.out.println(gamingField);
                System.out.println("Количество жизней:\t" + personLive + "\n");
                System.out.println("Введите куда будет ходить персонаж(ход возможен только по вертикали и горизонтали на одну клетку;" +
                        "\nКоординаты персонажа - (x: " + personX + ", y: " + personY + "))");
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(x + ", " + y);

                // проверка
                if (x != personX && y != personY) {
                    System.out.println("Неккоректный ход");
                } else if (Math.abs(x - personX) == 1 || Math.abs(y - personY) == 1) {
                    personX = x;
                    personY = y;
                    step++;
                    System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                            "\nХод номер: " + step);
                } else {
                    System.out.println("Координаты не изменены");
                }
            }
            case "НЕТ" -> System.out.println("Жаль, приходи еще!");
            default -> System.out.println("Данные введены неккоректно");
        }

    }
}


*/
        int[] massia = new int[10];
    }
}