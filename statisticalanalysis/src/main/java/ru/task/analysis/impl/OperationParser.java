package ru.task.analysis.impl;

import ru.task.analysis.ProcessConfiguration;
import ru.task.analysis.agreement.Parser;
import ru.task.analysis.objects.Operation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OperationParser implements Parser {

    ProcessConfiguration conf;

    public OperationParser(ProcessConfiguration conf) {
        this.conf = conf;
    }

    /**
     * Соглашение о переводе строковых записей в
     * объекты - операции
     *
     * @param operations
     * @return лист с объектами-операциями
     */
    public List<Operation> parse(List<String> operations) {
        List<Operation> operationObjects = new ArrayList<>(operations.size());
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(conf.getDateFormat());
        DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern(conf.getTimeFormat());

        for (String operationRow : operations) {
            // Входные данные
            //  дата   | время | номер точки продаж | номер операции | сумма операци
          //28.05.2018 | 21:37 |      3SalePoint    |       1        |    87760,96
           String[] elements = operationRow.split(" ");

           LocalDate date = LocalDate.parse(elements[0], dateFormat);
           LocalTime time = LocalTime.parse(elements[1], timeFormat);
           String operationPoint = elements[2];
           int operationNum = Integer.valueOf(elements[3]);
           double operationSum =
                   Double.valueOf(elements[4].replace(",","."));

           Operation operation = new Operation(
                   date,
                   time,
                   operationPoint,
                   operationNum,
                   operationSum
           );

           operationObjects.add(operation);
        }

        return operationObjects;
    }
}
