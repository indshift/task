package ru.task.analysis.impl;

import ru.task.analysis.ProcessConfiguration;
import ru.task.analysis.agreement.Writer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DataWriter implements Writer {

    DateTimeFormatter dateFormatter;
    DecimalFormat sumFormat;

    public DataWriter() {
        dateFormatter = ProcessConfiguration.getDateFormatter();
        sumFormat = ProcessConfiguration.getDf();
    }

    @Override
    public void writeSumByDate(TreeMap<LocalDate, Double> sumByDate, String statsDatesFileName) {
        Path path = Paths.get(statsDatesFileName);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Map.Entry<LocalDate, Double> entry : sumByDate.entrySet()) {
                StringBuffer line = new StringBuffer();
                line
                        .append(entry.getKey().format(dateFormatter)).append(" ")
                        .append(sumFormat.format(entry.getValue()))
                        .append(System.lineSeparator());
                writer.write(line.toString());
            }
        } catch (IOException e) {
            System.out.println("Запись в файл " + statsDatesFileName + " не удалась!");
            System.out.println(e);
        }
    }

    @Override
    public void writeSumByPoint(List<Map.Entry<String, Double>> operationSumByPointSorted,
                                String statsOfficesFileName) {

        Path path = Paths.get(statsOfficesFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Map.Entry<String, Double> entry : operationSumByPointSorted) {
                StringBuffer line = new StringBuffer();
                line
                        .append(entry.getKey()).append(" ")
                        .append(sumFormat.format(entry.getValue()))
                        .append(System.lineSeparator());
                writer.write(line.toString());
            }
        } catch (IOException e) {
            System.out.println("Запись в файл " + statsOfficesFileName + " не удалась!");
            System.out.println(e);
        }
    }
}
