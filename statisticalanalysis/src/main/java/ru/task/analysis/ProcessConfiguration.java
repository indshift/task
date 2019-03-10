package ru.task.analysis;

import ru.task.analysis.objects.DataInputFiles;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

public class ProcessConfiguration {
    //Файл с результирующей статистикой по датам
    private String statsDatesFileName;
    //Файл с результирующей статистикой по точкам продаж
    private String statsOfficesFileName;
    //файлы с входными данными
    private DataInputFiles dataInputFiles;

    private static String dateFormat = "dd.MM.yyyy";
    private String timeFormat = "HH:mm";

    private final static DecimalFormat df;
    private final static String OPERATION_SUM_FORMAT = "#.00";

    private final static DateTimeFormatter dateFormatter;

    private final static String runParamsExample =
            "task2.jar stats-dates.txt stats-offices.txt ops1.txt ops2.txt ops3.txt";

    static {
        df = new DecimalFormat(OPERATION_SUM_FORMAT);
        dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
    }

    public ProcessConfiguration(String statsDatesFileName,
                                String statsOfficesFileName,
                                DataInputFiles dataInputFiles) {
        this.statsDatesFileName = statsDatesFileName;
        this.statsOfficesFileName = statsOfficesFileName;
        this.dataInputFiles = dataInputFiles;
    }

    public static ProcessConfiguration getConfiguratoin(String[] args) throws Exception {

        //Пример запуска программы:
        //java -jar task2.jar stats-dates.txt stats-offices.txt ops1.txt ops2.txt ops3.txt
        //stats-dates.txt stats-offices.txt - выходные файлы
        //ops1.txt ops2.txt ops3.txt - входные данные

        //подготовим конфигурацию
        checkArgs(args);

        String statDates = args[0];
        String statOffices = args[1];

        DataInputFiles dataInputFiles = new DataInputFiles();
        for (int i = 2; i < args.length; i++) {
            dataInputFiles.add(args[i]);
        }

        return new ProcessConfiguration(statDates, statOffices, dataInputFiles);
    }

    private static void checkArgs(String[] args) throws Exception {
        if (args.length < 3) {
            String errorText1 = "Задайте корректно входные параметры " +
                    "в виде " + runParamsExample +
                    "где первые два параметра - файлы для записи результатов; " +
                    "третий и далее параметры - файлы с входными данными";
            throw new Exception(errorText1);
        }
    }

    public String getStatsDatesFileName() {
        return statsDatesFileName;
    }

    public String getStatsOfficesFileName() {
        return statsOfficesFileName;
    }

    public DataInputFiles getDataInputFiles() {
        return dataInputFiles;
    }

    public String getDateFormat() {
        return dateFormat;
    }

    public String getTimeFormat() {
        return timeFormat;
    }

    public static DecimalFormat getDf() {
        return df;
    }

    public static DateTimeFormatter getDateFormatter() {
        return dateFormatter;
    }

    public static String getRunParamsExample() {
        return runParamsExample;
    }
}
