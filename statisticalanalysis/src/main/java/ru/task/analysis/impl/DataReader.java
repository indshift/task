package ru.task.analysis.impl;

import ru.task.analysis.ProcessConfiguration;
import ru.task.analysis.agreement.Reader;
import ru.task.analysis.objects.DataInputFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataReader implements Reader {
    ArrayList<String> operations;

    @Override
    public List<String> readFromFiles(DataInputFiles files) {
        operations = new ArrayList<>();

        for (int i = 0; i < files.size() ; i++) {
            try (Stream<String> stream = Files.lines(Paths.get(files.get(i)))) {
                stream.forEach(this::addOperationToArray);
            } catch (IOException e){
                System.out.println("Кажется что-то пошло не так при чтении точек обслуживания!");
                System.out.println("Файлы должны существовать в директории запуска программы!");
                System.out.println("Пример запуска программы " + ProcessConfiguration.getRunParamsExample());
            }
        }

        return operations;
    }

    private void addOperationToArray(String operation) {
        operations.add(operation);
    }
}
