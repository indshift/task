package ru.task.analysis.agreement;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public interface Writer {
    void writeSumByDate(TreeMap<LocalDate, Double> sumByDate, String statsDatesFileName);
    void writeSumByPoint(List<Map.Entry<String, Double>> operationSumByPointSorted, String statsOfficesFileName);
}
