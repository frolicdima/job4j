package ru.job4j.pseudo;

/**
 * @author Dmitrii Mitin (ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {

    /**
     * Отрисовка строки, которая условно олицетворяет квадрат
     * @return строка, которая условно олицетворяет квадрат
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++");
        pic.append("+     +");
        pic.append("+     +");
        pic.append("++++");
        return pic.toString();
    }
}