package ru.task.analysis;

import ru.task.analysis.objects.Operation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationsAnalyzer {

    /**
     * Метод получает на вход массив операций и возвращает сумму операций за каждый день
     *
     * @param operations
     * @return
     */
    public static Map<LocalDate, Double> getByDay(List<Operation> operations) {
        Map<LocalDate, Double> sumByDay = new HashMap<>();

        for (Operation operation : operations) {
            /**
             * 1. проверить, есть ли такой ключ.
             * 2. если ключа нет, добавить
             * 3. если ключ есть - добавить сумму операции в запись
             */
            LocalDate dayKey = operation.getDate();
            double oSum = operation.getOperationSum();
            double currDaySum;

            if (!sumByDay.containsKey(dayKey)) {
                sumByDay.put(dayKey, oSum);
            } else {
                currDaySum = sumByDay.get(dayKey);
                currDaySum = currDaySum + oSum;
                sumByDay.put(dayKey, currDaySum);
            }
        }
        return sumByDay;
    }

    /**
     * Метод получает на вход массив операций и возвращает сумму операций в каждой точке
     */
    public static Map<String, Double> getByPoint(List<Operation> operations) {
        Map<String, Double> sumByPoint = new HashMap<>();

        for (Operation operation : operations) {
            /**
             * 1. проверить, есть ли такой ключ.
             * 2. если ключа нет, добавить
             * 3. если ключ есть - добавить сумму операции в запись
             */
            String point = operation.getPoint();
            double oSum = operation.getOperationSum();
            double currPointSum;

            if (!sumByPoint.containsKey(point)) {
                sumByPoint.put(point, oSum);
            } else {
                currPointSum = sumByPoint.get(point);
                currPointSum = currPointSum + oSum;
                sumByPoint.put(point, currPointSum);
            }
        }
        return sumByPoint;
    }
}
