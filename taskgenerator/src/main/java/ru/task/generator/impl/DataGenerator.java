package ru.task.generator.impl;

import ru.task.generator.ProcessConfiguration;
import ru.task.generator.agreement.Generator;
import ru.task.generator.objects.Operation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator implements Generator {
    private ProcessConfiguration conf;
    private List<Operation> operationsList;
    private LocalDate localDateFrom;
    private LocalDate localDateTo;
    private long minSecondDayValue;
    private long maxSecondDayValue;
    private DateTimeFormatter formatter;
    private ArrayList<String> salePoints;



    @Override
    public List<Operation> generateOperations(ProcessConfiguration configuration) {
        if (configuration == null ){
            System.out.println("Не задана конфигурация генератора");
            return null;
        }

        if (configuration.getSalePointSet() == null) {
            System.out.println("Не заданы точки продаж");
            return null;
        }

        this.conf = configuration;
        localDateFrom = conf.getLocalDateFrom();
        localDateTo = conf.getLocalDateTo();
        maxSecondDayValue = conf.getMaxSecondDayValue();
        minSecondDayValue = conf.getMinSecondDayValue();
        formatter = configuration.getFormatter();

        salePoints = new ArrayList<>(conf.getSalePointSet().size());
        salePoints.addAll(conf.getSalePointSet());

        makeOperations();

        return operationsList;
    }

    private void makeOperations(){
        operationsList = new ArrayList<>(conf.getOperationsQuantity());

        //todo переписать на стрим
        for (int i = 1; i <= conf.getOperationsQuantity(); i++) {
            String dateTime = getDateTime();
            String salePoint = getRandomSalePoint();
            double operationSum = getRandomDouble(
                    ProcessConfiguration.getMinOperation(),
                    ProcessConfiguration.getMaxOperation());

            Operation operation =
                    new Operation(dateTime, salePoint, i, operationSum);

            operationsList.add(operation);
        }
    }

    private String getRandomSalePoint(){
        int index = getRandomInt(0, this.salePoints.size());
        return this.salePoints.get(index);
    }

    private double getRandomDouble(double from, double to){
        return ThreadLocalRandom.current().doubles(from, to).findAny().getAsDouble();
    }
    private long getRandomLong(long from, long to){//TODO переиспользовать для генерации времени
        return ThreadLocalRandom.current().longs(from, to).findAny().getAsLong();
    }
    private int getRandomInt(int from, int to){
        return ThreadLocalRandom.current().ints(from, to).findAny().getAsInt();
    }

    private String getDateTime(){
        LocalDate localDate = getRandomLocalDate();
        LocalTime localTime = getRandomLocalTime();
        LocalDateTime dateTime = LocalDateTime.of(localDate, localTime);

        return dateTime.format(formatter);
    }

    private LocalDate getRandomLocalDate(){
        long randomEpochDay = ThreadLocalRandom.current()
                .longs(localDateFrom.toEpochDay(), localDateTo.toEpochDay()).findAny().getAsLong();

        return LocalDate.ofEpochDay(randomEpochDay);
    }

    private LocalTime getRandomLocalTime(){
        //поскольку randomNumberBound не включается, то увеличим на 1
        long randomTime = ThreadLocalRandom.current()
                .longs(minSecondDayValue, maxSecondDayValue - 1).findAny().getAsLong();

        return LocalTime.ofSecondOfDay(randomTime);
    }

}
