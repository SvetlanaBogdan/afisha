package ru.netology.afisha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AfishaManagerTest {

    @Test
    public void shouldAddSeveralMovies() {
        // Создаём менеджер афиши с лимитом по умолчанию (5)
        AfishaManager manager = new AfishaManager();

        // Добавляем фильмы
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        // Ожидаемый результат (в порядке добавления)
        String[] expected = {"Film 1", "Film 2", "Film 3"};

        // Получаем фактический результат
        String[] actual = manager.findAll();

        // Проверяем совпадение массивов
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllMoviesInReverseOrderWhenLessThanLimit() {
        // Создаём менеджер с лимитом по умолчанию (5)
        AfishaManager manager = new AfishaManager();

        // Добавляем 3 фильма (меньше лимита)
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");

        // Ожидаем получить их в обратном порядке
        String[] expected = {"Film 3", "Film 2", "Film 1"};

        // Вызываем метод получения последних фильмов
        String[] actual = manager.findLast();

        // Проверяем совпадение
        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnLastFiveWhenExactlyFiveAdded() {
        // Менеджер с лимитом по умолчанию (5)
        AfishaManager manager = new AfishaManager();

        // Добавляем ровно 5 фильмов
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        // Ожидаем получить их в обратном порядке
        String[] expected = {
                "Film 5",
                "Film 4",
                "Film 3",
                "Film 2",
                "Film 1"
        };

        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnOnlyLastFiveWhenMoreThanLimit() {
        // Менеджер с лимитом по умолчанию (5)
        AfishaManager manager = new AfishaManager();

        // Добавляем 7 фильмов
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");
        manager.add("Film 6");
        manager.add("Film 7");

        // Ожидаем только последние 5 в обратном порядке
        String[] expected = {
                "Film 7",
                "Film 6",
                "Film 5",
                "Film 4",
                "Film 3"
        };

        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRespectCustomLimit() {
        // Создаём менеджер с лимитом 3
        AfishaManager manager = new AfishaManager(3);

        // Добавляем 5 фильмов
        manager.add("Film 1");
        manager.add("Film 2");
        manager.add("Film 3");
        manager.add("Film 4");
        manager.add("Film 5");

        // Должны получить только 3 последних
        String[] expected = {
                "Film 5",
                "Film 4",
                "Film 3"
        };

        String[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }


}
