package ru.task.generator.agreement;

import ru.task.generator.objects.Operation;
import ru.task.generator.objects.ResultFiles;

import java.util.List;

public interface Writer {
    void writeOperations(List<Operation> operations, ResultFiles files);
}
