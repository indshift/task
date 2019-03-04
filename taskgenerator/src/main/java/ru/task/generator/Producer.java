package ru.task.generator;

import ru.task.generator.agreement.Generator;
import ru.task.generator.agreement.Writer;
import ru.task.generator.impl.DataGenerator;
import ru.task.generator.impl.DataReader;
import ru.task.generator.impl.DataWriter;
import ru.task.generator.objects.Operation;

import java.util.List;
import java.util.Set;

public class Producer {
    ProcessConfiguration config;

    public void produce(String[] args) throws Exception {
        //offices.txt 90000 ops1.txt ops2.txt ops3.txt
        config = ProcessConfiguration.getConfiguratoin(args);
        DataReader reader = new DataReader();
        Set<String> points =
        reader.readSailPoints(config.getOfficesFilePath());
        config.setSalePointSet(points);

        Generator generator = new DataGenerator();
        List<Operation> operations = generator.generateOperations(config);

        Writer writer = new DataWriter();
        writer.writeOperations(operations, config.getOperationFilesResult());
    }
}
