package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerPosterTest {

    FilmsItem first = new FilmsItem(111, 1, "First film");
    FilmsItem second = new FilmsItem(22, 2, "Second film");
    FilmsItem third = new FilmsItem(3333, 3, "Third film");
    FilmsItem fourth = new FilmsItem(3333, 3, "Fourth film");
    FilmsItem fifth = new FilmsItem(3333, 3, "Fifth film");
    FilmsItem sixth = new FilmsItem(3333, 3, "Sixth film");
    FilmsItem seventh = new FilmsItem(3333, 3, "Seventh film");
    FilmsItem eighth = new FilmsItem(3333, 3, "Eighth film");
    FilmsItem ninth = new FilmsItem(3333, 3, "Ninth film");
    FilmsItem tenth = new FilmsItem(3333, 3, "Tenth film");
    FilmsItem eleventh = new FilmsItem(3333, 3, "Elevetth film");

    ManagerPoster poster = new ManagerPoster();

    @Test
    public void saveEmpty() {

        poster.save(first);

        FilmsItem[] exspected = {first};
        FilmsItem[] actual = poster.findAll();

        assertArrayEquals(exspected, actual);
    }

    @Test
    public void saveNotEmpty() {

        poster.save(first);
        poster.save(second);

        poster.save(third);

        FilmsItem[] exspected = {first, second, third};
        FilmsItem[] actual = poster.findAll();

        assertArrayEquals(exspected, actual);
    }

    @Test
    void findAllEmpty() {
        FilmsItem[] expected = {};
        FilmsItem[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllNotEmpty() {

        poster.save(first);
        poster.save(second);

        FilmsItem[] expected = {first, second};
        FilmsItem[] actual = poster.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastDefault() {
        ManagerPoster poster = new ManagerPoster();
        poster.save(first);
        poster.save(second);
        poster.save(third);
        poster.save(fourth);
        poster.save(fifth);
        poster.save(sixth);
        poster.save(seventh);
        poster.save(eighth);
        poster.save(ninth);
        poster.save(tenth);
        poster.save(eleventh);

        FilmsItem[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        FilmsItem[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findLast() {
        ManagerPoster poster = new ManagerPoster(2);
        poster.save(first);
        poster.save(second);
        poster.save(third);
        poster.save(fourth);
        poster.save(fifth);
        poster.save(sixth);
        poster.save(seventh);
        poster.save(eighth);
        poster.save(ninth);
        poster.save(tenth);

        FilmsItem[] expected = {tenth, ninth};
        FilmsItem[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void findLastLimitOverLenght() {
        ManagerPoster poster = new ManagerPoster(6);
        poster.save(first);
        poster.save(second);
        poster.save(third);

        FilmsItem[] expected = {third, second, first};
        FilmsItem[] actual = poster.findLast();

        assertArrayEquals(expected, actual);
    }

}