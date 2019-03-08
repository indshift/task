package ru.task.generator.agreement;

import ru.task.generator.objects.Operation;
import ru.task.generator.objects.ResultFiles;

import java.util.List;
import java.util.Set;

public interface Writer {
     void writeOperations(List<Operation> operations, ResultFiles files);
}
