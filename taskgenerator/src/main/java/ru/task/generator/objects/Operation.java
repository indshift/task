package ru.task.generator.objects;

import java.text.DecimalFormat;

public class Operation {
    //дату и время | номер точки продаж | номер операции | сумму операции

    String datetime;
    String salePointNuber;
    double operationNumber;
    double operationSum;
    private final static DecimalFormat df;

    static {
        df = new DecimalFormat("#.##");
    }

    public Operation(String datetime, String salePointNuber, double operationNumber, double operationSum) {
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
