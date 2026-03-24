package ru.innovationcampus.vsu26.lependin_e_s.first_sprint;

import java.util.Random;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        //String person = "\uD83E\uDDD9\u200D";
        int personLive = 3;
        /* здесь необходимо рассказать про переполнение и про другие типы данных
            int personLive = 2147483649; // мало ли кто-то захочет сделать ооочень много жизней
         */

        String monster = "\uD83E\uDDDF\u200D";
        int sizeBoard = 5;
        int personX = 1;
        int personY = 5;
        int monsterY = 2;
        int step = 0;
        boolean finishh = false;

        Person person = new Person(sizeBoard);

        // \n, \t - как спец символ(упомянуть)
        String castle = "\uD83C\uDFF0";
        String health = "❤️";

        Random r = new Random();
        int g = r.nextInt(sizeBoard);
        person.x = g == 0 ? 1 : g;
        person.y = sizeBoard;

        int n = r.nextInt(sizeBoard);
        if (n == 0) {
            person.x = 1;
        } else {
            person.x = n;
        }

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


        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        int count_monster = sizeBoard * sizeBoard - sizeBoard - 1;
        for (int i = 0; i <= count_monster; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = monster;
        }


        int health_ = 3;
        for (int i = 1; i <= health_; i++) {
            board[random.nextInt(sizeBoard - 1)][random.nextInt(sizeBoard)] = health;
        }


        board[castleY - 1][castleX - 1] = castle;
        board[personY - 1][personX - 1] = person.imagee;


        while ((personLive > 0) && !(castleX == personX && castleY == personY)) {


            for (int y = 1; y <= sizeBoard; y++) {
                System.out.println(wall);
                for (int x = 1; x <= sizeBoard; x++) {
                    System.out.print(leftBlock);
                    System.out.print(board[y - 1][x - 1]);
                }
                System.out.println(rightBlock);
            }
            System.out.println(wall);
            int x = sc.nextInt();
            int y = sc.nextInt();
 /*            int counterr = 0;

            if (inputX != personX && inputY != personY) {
                System.out.println("Неккоректный ход");
                counterr = 0;
            } {
                personX = inputX;
                counterr = 1;
                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY);


            } else {
                System.out.println("Координаты не изменены");
                counterr = 0;
            }

*/
            if (person.isMoveCorrect(x, y)) {
                String next = board[y - 1][x - 1];
                if (next.equals("  ")) {
                    board[person.y - 1][person.x - 1] = "  ";
                    person.move(x, y);
                    step++;
                    board[y - 1][x - 1] = person.imagee;
                    System.out.println("Ход корректный; Новые координаты: " + person.x + ", " + person.y +
                            "\\nХод номер: " + step);
                } else if (next.equals(castle)) {
                    System.out.println("Вы прошли игру!");
                    break;
                } else if (next.equals(health)) {
                    board[person.y - 1][person.x - 1] = "  ";
                    person.move(x, y);
                    step++;
                    board[y - 1][x - 1] = person.imagee;
                    personLive++;
                    System.out.println("вы получили доп жизнь теперь у вас " + personLive + " жизней");
                    System.out.println("Ход корректный; Новые координаты: " + person.x + ", " + person.y +
                            "\\nХод номер: " + step);

                } else {
                    // задача и взаимодействие с монстрами

                    boolean success = taskMonster();
                    if (success) {
                        System.out.println("Верно! Ты победил монстра");
                        personLive++;
                        board[person.y - 1][person.x - 1] = "  ";
                        personX = x;
                        personY = y;
                        person.move(x, y);
                        board[personY - 1][personX - 1] = person.imagee;

                        step++;
                    } else {
                        System.out.println("Ты проиграл эту битву!");
                        personLive -= 1;
                    }


                }
            } else {
                System.out.println("Некорректный ход");
            }
            if (personLive <= 0) {
                if (perlive_()) {
                    personLive++;
                } else {
                    break;
                }
            }


//
            // старая версия проверки и переноса персонажа без класс а также обтаботка монстра
            /*
            if (board[inputY - 1][inputX - 1].equals("  ")) {
                board[personY - 1][personX - 1] = "  ";
                personX = inputX;
                personY = inputY;
                step++;

                board[inputY - 1][inputX - 1] = person.image;

                System.out.println("Ход корректный; Новые координаты: " + personX + ", " + personY +
                        "\\nХод номер: " + step);
            } else if (board[inputY - 1][inputX - 1].equals(castle)) {
                System.out.println("Вы прошли игру!");
                break;
            } else {
                boolean success = taskMonster();
                if (success) {
                    System.out.println("Верно! Ты победил монстра");
                    personLive++;
                    board[personY - 1][personX - 1] = "  ";
                    personX = inputX;
                    personY = inputY;
                    board[personY - 1][personX - 1] = person;

                    step++;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    personLive -= 1;
                }

            }
            if (personLive <= 0) {
                int x = r.nextInt(400);
                int y = r.nextInt(400);
                int trueAnswer = x + y;
                System.out.println("Реши пример: " + x + " + " + y + " = ?");
                Scanner scx = new Scanner(System.in);
                int ans = scx.nextInt();
                if (trueAnswer == ans) {
                    System.out.println("Верно! Ты победил монстра");
                    personLive++;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    break;
                }
            }


            // логика хода
            //int personX = 1;
            //        int personY = 3;

*/
        }
        if (personLive==0) {
            System.out.println("Закончились жизни. Итог: ..." + step + " ходов");
        }
    }

    static boolean perlive_() {
        Random r = new Random();
        int x = r.nextInt(400);
        int y = r.nextInt(400);
        int trueAnswer = x + y;
        System.out.println("последний шанс");
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner scx = new Scanner(System.in);
        int ans = scx.nextInt();
        if (trueAnswer == ans) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву!");

            return false;
        }


    }

    static boolean taskMonster() {
        System.out.println("Решите задачу.");
        Random r = new Random();
        int x = r.nextInt(400);
        int y = r.nextInt(400);
        int trueAnswer = x + y;
        System.out.println("Реши пример: " + x + " + " + y + " = ?");
        Scanner scx = new Scanner(System.in);
        int ans = scx.nextInt();
        return trueAnswer == ans;
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
//        if (answer.equals("ДА")) {

//        System.out.println("Выбери сложность игры(от 1 до 5):");
//        int difficultGame = sc.nextInt();
//        System.out.println("Выбранная сложность:\t" + difficultGame);
//            System.out.println("Сколько жизней будет у персонажа?");
/// /            personLive = sc.nextInt(); // здесь необходимо рассказать о возможных ошибках(неверный тип, переполнение - еще раз и тд)
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

