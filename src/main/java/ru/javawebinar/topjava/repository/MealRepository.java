package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

/**
 * Created by Elisey on 21.04.2017.
 */
public interface MealRepository {
    Meal save(Meal meal);

    void delete(int id);
    Meal get(int id);

    Collection<Meal> getAll();
}
