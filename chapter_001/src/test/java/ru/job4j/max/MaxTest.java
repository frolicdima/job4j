package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmitrii Mitin (mailto:ppdnk@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    @Test
    public void whenFirstGreaterSecond() {
        Max maxim = new Max();
        int result = maxim.max(100, 2);
        assertThat(result, is(100));
    }

    @Test
    public void whenFirstGreaterSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(100, 2, 4);
        assertThat(result, is(100));
    }

    @Test
    public void whenSecondGreaterFirstAndThird() {
        Max maxim = new Max();
        int result = maxim.max(10, 20, 4);
        assertThat(result, is(20));
    }
}
