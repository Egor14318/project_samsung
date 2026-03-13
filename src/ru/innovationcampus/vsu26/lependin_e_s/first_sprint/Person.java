package ru.innovationcampus.vsu26.lependin_e_s.first_sprint;

public class Person    //основной класс персонажа
{
    int x;
    int y;
    String image = "\\\\uD83E\\\\uDDD9\\\\u200D";
    int live = 3;

    void move(int x, int y)  //метод перемещения персонажа
    {
        this.x = x;
        this.y = y;
    }

    public boolean isMoveCorrect(int x, int y)   //метод проверки коректности кода
    {
        return this.x == x && Math.abs(this.y - y) == 1 || this.y == y && Math.abs(this.x - x) == 1;
    }

    void getDamage() {
        this.live -=1;
    }
}

