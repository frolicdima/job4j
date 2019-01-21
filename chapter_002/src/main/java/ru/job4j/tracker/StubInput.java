package ru.job4j.tracker;

import java.util.List;

public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     * Например, если пользователь хочет выбрать добавление новой заявки, ему нужно ввести:
     * 0 - выбор пункта меню "добавить новую заявку"
     * name - имя заявки
     * desc - описание заявки
     * 6 - выйти из трекера
     */
    private final String[] value;

    /**
     * Поле считает количество вызовов метода ask
     * При каждом вызове надо передвинуть указатель в соответствии с выполненными действиями
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Давайте рассмотрим, как работает этот метод.
     * У нас есть объект, в котором содержатся заранее продуманные ответы.
     * При последовательном вызове метода ask нам надо возвращать соответствующие данные.
     * Как если бы мы симулировали поведение пользователя.
     * Для этого при каждом вызове метода ask мы изменяем счетчик и
     * при следующем вызове он вернет нам новое значение.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    @Override
    public int ask(String question, List<Integer> range) {
        return -1;
    }
}
