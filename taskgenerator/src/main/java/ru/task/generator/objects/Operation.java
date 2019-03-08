package ru.task.generator.objects;

import java.text.DecimalFormat;

/**
 * Класс для хранения записи - результата генерации
 */
public class Operation {
    //дата и время | номер точки продаж | номер операции | сумма операции
    private String datetime;
    private String salePointNuber;
    private int operationNumber;
    private double operationSum;
    private final static DecimalFormat df;
    private final static String OPERATION_SUM_FORMAT = "#.##";

    static {
        df = new DecimalFormat(OPERATION_SUM_FORMAT);
    }

    public Operation(String datetime, String salePointNuber, int operationNumber, double operationSum) {
        this.datetime = datetime;
        this.salePointNuber = salePointNuber;
        this.operationNumber = operationNumber;
        this.operationSum = operationSum;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer
                .append(datetime).append(" ")
                .append(salePointNuber).append(" ")
                .append(operationNumber).append(" ")
                .append(df.format(operationSum));

        return buffer.toString();
    }
}
