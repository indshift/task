package ru.task.generator.impl;

import ru.task.generator.agreement.Writer;
import ru.task.generator.objects.Operation;
import ru.task.generator.objects.ResultFiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataWriter implements Writer {
    private List<List<Operation>> operationsLists;
    private ResultFiles filesPath;
    private List<Operation> operations;

    public DataWriter() {
        operationsLists = new ArrayList<>();
    }

    @Override
    public void writeOperations(List<Operation> operations, ResultFiles files) {
        this.filesPath = files;
        this.operations = operations;

        splitIntoPieces();
        writeToFiles();
    }

    /**
     * Метод разделяет спиок операций на несколько массивов в соответствии
     * с количеством файлов
     */
    public void splitIntoPieces() {
        double operationsNum = operations.size();
        double filesNum = filesPath.getSize();

        double remainder = operationsNum % filesNum;
        double every  = (operationsNum - remainder) / filesNum;

        int a = 0;
        int b = a + (int)every;
        for (int i = 0; i < filesNum; i++){

            if (remainder > 0){
                b = b + 1;
                remainder--;
            }

            List<Operation> operationsFirstPart = this.operations.subList(a, b);
            operationsLists.add(operationsFirstPart);
            a = b;
            b = b + (int) every;
        }
    }

    private void writeToFiles() {
        for (int fileNum = 0; fileNum < filesPath.getSize(); fileNum++) {
            Path path = Paths.get(filesPath.getFile(fileNum));
            try (BufferedWriter writer = Files.newBufferedWriter(path)) {
                List<Operation> list = operationsLists.get(fileNum);
                for (Operation operation : list) {
                    writer.write(operation.toString());
                    writer.write(System.lineSeparator());
                }
            } catch (IOException e) {
                System.out.println("Запись в файлы " + filesPath + " не удалась!");
                System.out.println(e);
            }
        }
    }
}
