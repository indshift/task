package ru.task.generator;


import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class ProcessConfiguration {

    private String officesFilePath;
    private int operationsQuantity;
    private Set<String> operationFilesResult;
    private static final double minOperation =  10_000.12;
    private static final double maxOperation = 100_000.50;
    private LocalDate localDateFrom;
    private LocalDate LocalDateTo;
    private long minSecondDayValue = 0;
    private long maxSecondDayValue = 24 * 60 * 60 - 1;
    private DateTimeFormatter formatter;


    private Set<String> salePointSet;

    public ProcessConfiguration(String officesFilePath,
            int operationsQuantity,
            Set<String> operationFilesResult) {
        this.officesFilePath = officesFilePath;
        this.operationsQuantity = operationsQuantity;
        this.operationFilesResult = operationFilesResult;

        int currentYear = LocalDateTime.now().getYear();

        localDateFrom = LocalDate.of(currentYear - 1, Month.JANUARY,01);
        LocalDateTo = LocalDate.of(currentYear, Month.JANUARY,01);
        formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    }

    public static ProcessConfiguration getConfiguratoin(String[] args) throws Exception {
        //offices.txt 90000 ops1.txt ops2.txt ops3.txt
        if (args.length < 3) {
            String message = "Некорректное число входных параметров." +
                    "Строка запуска должна соответствовать виду " +
                    "offices.txt 90000 ops1.txt ops2.txt ops3.txt";
            throw new Exception(message);
        }

        String offices = args[0];
        int operationsQuantity;
        try {
            operationsQuantity = Integer.valueOf(args[1]);
        } catch (NumberFormatException e){
            String message = "Количестов операций должно целым числом";
            throw new Exception(message);
        }

        //String ops1 = args[]
        Set<String> operationFilesResult = new HashSet<>();

        for (int i = 2; i < args.length; i++) {
            operationFilesResult.add(args[i]);
        }

        ProcessConfiguration configuration = new ProcessConfiguration(
                offices,
                operationsQuantity,
                operationFilesResult);
        return configuration;
    }


    public String getOfficesFilePath() {
        return officesFilePath;
    }

    public int getOperationsQuantity() {
        return operationsQuantity;
    }

    public Set<String> getOperationFilesResult() {
        return operationFilesResult;
    }

    public static double getMinOperation() {
        return minOperation;
    }

    public static double getMaxOperation() {
        return maxOperation;
    }

    public Set<String> getSalePointSet() {
        return salePointSet;
    }

    public void setSalePointSet(Set<String> salePointSet) {
        this.salePointSet = salePointSet;
    }

    public LocalDate getLocalDateFrom() {
        return localDateFrom;
    }

    public LocalDate getLocalDateTo() {
        return LocalDateTo;
    }

    public long getMinSecondDayValue() {
        return minSecondDayValue;
    }

    public long getMaxSecondDayValue() {
        return maxSecondDayValue;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }
}
