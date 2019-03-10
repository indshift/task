package ru.task.analysis.objects;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Операция считанная из файла и переложенная в объект
 */
public class Operation {
    LocalDate date; //дата операции
    LocalTime time; //время операции
    String point; //точка прождажи
    int operationNum; //номер операции
    double operationSum; //сумма одной операции

    public Operation(LocalDate date, LocalTime time, String point, int operationNum, double operationSum) {
        this.date = date;
        this.time = time;
        this.point = point;
        this.operationNum = operationNum;
        this.operationSum = operationSum;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPoint() {
        return point;
    }

    public double getOperationSum() {
        return operationSum;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "date=" + date +
                ", time=" + time +
                ", point='" + point + '\'' +
                ", operationNum=" + operationNum +
                ", operationSum=" + operationSum +
                '}';
    }
}
