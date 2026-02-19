package ru.netology.afisha;

public class AfishaManager {

    // Поле для хранения фильмов
    private String[] movies = new String[0];

    // Лимит количества фильмов для вывода
    private int limit;

    // Конструктор по умолчанию (лимит = 5)
    public AfishaManager() {
        this.limit = 5;
    }

    // Конструктор с параметром (можно задать свой лимит)
    public AfishaManager(int limit) {
        this.limit = limit;
    }
    // Метод для добавления нового фильма
    public void add(String movie) {

        // Создаем новый массив размером на 1 больше
        String[] tmp = new String[movies.length + 1];

        // Копируем старые фильмы в новый массив
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }

        // Добавляем новый фильм в конец
        tmp[tmp.length - 1] = movie;

        // Перезаписываем ссылку на массив
        movies = tmp;
    }

    // Метод для получения всех фильмов в порядке добавления
    public String[] findAll() {
        return movies;
    }
    // Метод для получения последних фильмов в обратном порядке
    public String[] findLast() {

        // Определяем сколько фильмов нужно вернуть
        int resultLength;

        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        // Создаём массив нужного размера
        String[] result = new String[resultLength];

        // Заполняем его в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }

}

