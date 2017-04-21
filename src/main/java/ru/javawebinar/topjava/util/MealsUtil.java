package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.to.MealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class MealsUtil {

    private static List<Meal> MEALS = Arrays.asList(
                new Meal(LocalDateTime.of(2017, Month.APRIL, 18, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2017, Month.APRIL, 18, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2017, Month.APRIL, 18, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2017, Month.APRIL, 19, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2017, Month.APRIL, 19, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2017, Month.APRIL, 19, 20, 0), "Ужин", 510)
        );

    public static  final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static List<MealWithExceed> mealsWithExceeded = getFilteredWithExceeded(MEALS, LocalTime.of(0, 0), LocalTime.of(23, 59), 2000);
//        mealsWithExceeded.forEach(System.out::println);

//
//        System.out.println(getFilteredWithExceededByCycle(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));

    public static List<MealWithExceed> getWithExceeded(Collection<Meal> meals, int caloriesPerDay) {
        return getFilteredWithExceeded(meals, LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
    }


    public static List<MealWithExceed> getFilteredWithExceeded(Collection<Meal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        Map<LocalDate, Integer> caloriesSumByDate = meals.stream()
                .collect(
                        Collectors.groupingBy(Meal::getDate, Collectors.summingInt(Meal::getCalories))
//                      Collectors.toMap(Meal::getDate, Meal::getCalories, Integer::sum)
                );

        return meals.stream()
                .filter(meal -> TimeUtil.isBetween(meal.getTime(), startTime, endTime))
                .map(meal -> new MealWithExceed(meal.getId(), meal.getDateTime(), meal.getDescription(), meal.getCalories(),
                        caloriesSumByDate.get(meal.getDate()) > caloriesPerDay))
                .collect(Collectors.toList());
    }

    public static List<Meal> getMEALS() {
        return MEALS;
    }

}