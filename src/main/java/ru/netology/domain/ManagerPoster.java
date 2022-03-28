package ru.netology.domain;

import static java.lang.System.arraycopy;

public class ManagerPoster {

    private FilmsItem[] items = new FilmsItem[0];
    private int limit = 10;

    public ManagerPoster(int limit) {
        this.limit = limit;
    }

    public ManagerPoster() {
    }

    public void save(FilmsItem item) {
        int lenght = items.length + 1;
        FilmsItem[] tmp = new FilmsItem[lenght];
        arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public FilmsItem[] findAll() {
        return this.items;
    }

    public FilmsItem[] findLast() {

        int resultLenght;
        if (limit > items.length) {
            resultLenght = items.length;
        } else {
            resultLenght = limit;
        }
        FilmsItem[] result = new FilmsItem[resultLenght];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }
}
