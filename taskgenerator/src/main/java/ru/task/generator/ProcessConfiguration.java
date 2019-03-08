package ru.task.generator;


import ru.task.generator.objects.ResultFiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Set;

/**
 * Класс - конфигуратор генерируемых данных
 */
public class ProcessConfiguration {
    private String officesFilePath;
    private int operationsQuantity;
    ResultFiles resultFiles;
    private static final double minOperation =  10_000.12;
    private static final double maxOperation = 100_000.50;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private long minSecondDayValue = 0; //секунд в дне
    private long maxSecondDayValue = 24 * 60 * 60 - 1; //секунд в дней
    private DateTimeFormatter formatter;

    private Set<String> salePointSet;

    private ProcessConfiguration(String officesFilePath,
            int operationsQuantity,
            ResultFiles resultFiles) {
        this.officesFilePath = officesFilePath;
        this.operationsQuantity = operationsQuantity;
        this.resultFiles = resultFiles;

        int currentYear = LocalDateTime.now().getYear();

        dateFrom = LocalDate.of(currentYear - 1, Month.JANUARY,01);
        dateTo = LocalDate.of(currentYear, Month.JANUARY,01);
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

        //String ops1 = args[i>=2]
        ResultFiles resultFiles = new ResultFiles();

        for (int i = 2; i < args.length; i++) {
            resultFiles.addFile(args[i]);
        }

        ProcessConfiguration configuration = new ProcessConfiguration(
                offices,
                operationsQuantity,
                resultFiles);
        return configuration;
    }

    public String getOfficesFilePath() {
        return officesFilePath;
    }

    public int getOperationsQuantity() {
        return operationsQuantity;
    }

    public ResultFiles getOperationFilesResult() {
        return this.resultFiles;
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

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
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
