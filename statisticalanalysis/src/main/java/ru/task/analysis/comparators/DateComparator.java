package ru.task.analysis.comparators;

import java.time.LocalDate;
import java.util.Comparator;

/**
 * Класс-компаратор для сортировки сгруппированной по дням статистики
 * Сорировка по возрастанию даты
 */
public class DateComparator implements Comparator<LocalDate> {
    public int compare(LocalDate d1, LocalDate d2) {
        return d1.compareTo(d2);
    }
}
