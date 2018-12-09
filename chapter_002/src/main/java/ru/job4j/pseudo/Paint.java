package ru.job4j.pseudo;

/**
 * Paint
 */
public class Paint {

    /**
     * Shape как поле класса Paint
     */
    private Shape shape;

    /**
     * Конструктор
     * @param shape
     */
    public Paint(Shape shape) {
        this.shape = shape;
    }

    public Paint() {
    }

    /**
     * Отрисовка фигуры в псеводграфике при помощи интерфейса
     * @param shape - объект класса Square или Triangle
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}
