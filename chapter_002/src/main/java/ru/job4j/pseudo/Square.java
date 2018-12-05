package ru.job4j.pseudo;

/**
 * @author Dmitrii Mitin (ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Square implements Shape {
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