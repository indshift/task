package ru.task.analysis;

import ru.task.analysis.objects.Operation;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Класс для хранения входных и результирующих
 * данных.
 * Типы контейнеров заданы осознанно
 */
public class ProcessData {
    //Операции, считанные из файла в виде строк
    private List<String> rowOperations;

    //Операции, переложенные в объект
    private List<Operation> operations;

    //Сумма всех операций за каждый день
    private Map<LocalDate, Double> operationSumByDay;

    //Сумма всех операций в каждой точке
    private Map<String, Double> operationSumByPoint;

    //Сумма всех операций за каждый день, отсортированная по возрастанию даты
    private TreeMap<LocalDate, Double> operationSumByDaySorted;

    //Сумма всех операций в каждой точке, отсортированная по убыванию суммы
    //private TreeMap<String, Double> operationSumByPointSorted;
    List<Map.Entry<String, Double>> operationSumByPointSorted;

    public List<String> getRowOperations() {
        return rowOperations;
    }

    public void setRowOperations(List<String> rowOperations) {
        this.rowOperations = rowOperations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public Map<LocalDate, Double> getOperationSumByDay() {
        return operationSumByDay;
    }

    public void setOperationSumByDay(Map<LocalDate, Double> operationSumByDay) {
        this.operationSumByDay = operationSumByDay;
    }

    public Map<String, Double> getOperationSumByPoint() {
        return operationSumByPoint;
    }

    public void setOperationSumByPoint(Map<String, Double> operationSumByPoint) {
        this.operationSumByPoint = operationSumByPoint;
    }

    public TreeMap<LocalDate, Double> getOperationSumByDaySorted() {
        return operationSumByDaySorted;
    }

    public void setOperationSumByDaySorted(TreeMap<LocalDate, Double> operationSumByDaySorted) {
        this.operationSumByDaySorted = operationSumByDaySorted;
    }

    public List<Map.Entry<String, Double>> getOperationSumByPointSorted() {
        return operationSumByPointSorted;
    }

    public void setOperationSumByPointSorted(List<Map.Entry<String, Double>> operationSumByPointSorted) {
        this.operationSumByPointSorted = operationSumByPointSorted;
    }
}
