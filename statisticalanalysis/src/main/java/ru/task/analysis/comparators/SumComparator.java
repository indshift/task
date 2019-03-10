package ru.task.analysis.comparators;

import java.util.Comparator;
import java.util.Map;

/**
 * Класс-компаратор для сортировки сгруппированной по точкам продаж статистики
 * Сорировка по убыванию суммы
 */
public class SumComparator implements Comparator<Map.Entry<String, Double>> {
    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
