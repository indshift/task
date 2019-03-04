package ru.task.generator.impl;

import ru.task.generator.agreement.Writer;
import ru.task.generator.objects.Operation;

import javax.jws.soap.SOAPBinding;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class DataWriter implements Writer {
    List<List<Operation>> operationsLists;
    Set<String> filesPath;

    @Override
    public boolean writeOperations(List<Operation> operations, Set<String> files) {
        //получим лист листов, которые потом запишем в файлы
        double operationsNum = operations.size();
        double filesNum = files.size();
        int operationsInfile = (int) Math.ceil(operationsNum/filesNum);
        operationsLists = new ArrayList<>();

        operationsLists.addAll(partition(operations, operationsInfile));

         filesPath = files;

        System.out.println("operationsLists: " + operationsLists);
        System.out.println("operationsLists.size(): " + operationsLists.size());
         for (List<Operation> list : operationsLists){
             System.out.println("\nLIST ");
             System.out.println();
             System.out.println(list);
         }

         writeToFiles();

         return true;
    }


    private void writeToFiles(){
        List<String> filesPathArray = new ArrayList<String>();
        filesPathArray.addAll(filesPath);

        //System.out.println("operationsLists: !!" + operationsLists);
        //System.out.println("END operationsLists: !!");

        for (int fileNum = 0; fileNum < filesPathArray.size(); fileNum++) {
            Path path = Paths.get(filesPathArray.get(fileNum));
            try (BufferedWriter writer = Files.newBufferedWriter(path))
            {
                List<Operation> list = operationsLists.get(fileNum);
                for (Operation operation : list) {
                    writer.write(operation.toString());
                    writer.write(System.lineSeparator());

                }
            } catch (IOException e){
                System.out.println("Запись в файлы " + filesPath + " не удалась!");
                System.out.println(e);
            }
        }
    }

    private static <T> Collection<List<T>> partition(List<T> list, int size) {
        final AtomicInteger counter = new AtomicInteger(0);

        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / size))
                .values();
    }
}
