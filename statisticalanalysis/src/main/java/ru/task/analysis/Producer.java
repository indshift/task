package ru.task.analysis;

import ru.task.analysis.agreement.Writer;
import ru.task.analysis.comparators.DateComparator;
import ru.task.analysis.comparators.SumComparator;
import ru.task.analysis.impl.DataReader;
import ru.task.analysis.impl.DataWriter;
import ru.task.analysis.impl.OperationParser;
import ru.task.analysis.objects.Operation;

import java.time.LocalDate;
import java.util.*;

public class Producer {
    ProcessConfiguration config;
    ProcessData processData;


    public void produce(String[] args) throws Exception {
        config = ProcessConfiguration.getConfiguratoin(args);
        DataReader reader = new DataReader();

        List<String> rowOperations =
                reader.readFromFiles(config.getDataInputFiles());

        processData = new ProcessData();
        processData.setRowOperations(rowOperations);

        //перевести данные в объекты
        OperationParser parser = new OperationParser(config);
        List<Operation> operationList = parser.parse(processData.getRowOperations());
        processData.setOperations(operationList);

        //получим суммы
        //по датам
        Map<LocalDate, Double> sumByDate =
                OperationsAnalyzer.getByDay(processData.getOperations());
        processData.setOperationSumByDay(sumByDate);
        //по точкам
        Map<String, Double> sumByPoint =
                OperationsAnalyzer.getByPoint(processData.getOperations());
        processData.setOperationSumByPoint(sumByPoint);


        //сделаем сортировку
        //по возрастанию даты
        TreeMap<LocalDate, Double> sortedSumByDate = new TreeMap<>(new DateComparator());
        sortedSumByDate.putAll(sumByDate);
        processData.setOperationSumByDaySorted(sortedSumByDate);

        //по убыванию суммы
        List<Map.Entry<String, Double>> operationSumByPointSorted =
                sortSumByPoint(sumByPoint);
        processData.setOperationSumByPointSorted(operationSumByPointSorted);

        Writer writer = new DataWriter();
        writer.writeSumByDate(processData.getOperationSumByDaySorted(), config.getStatsDatesFileName());
        writer.writeSumByPoint(processData.getOperationSumByPointSorted(), config.getStatsOfficesFileName());
    }

    //TODO выделить в отдельный класс
    private List<Map.Entry<String, Double>> sortSumByPoint(Map<String, Double> map) {
        List<Map.Entry<String, Double>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new SumComparator());

        return list;
    }
}
