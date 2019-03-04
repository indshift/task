package ru.task.generator.agreement;

import ru.task.generator.objects.Operation;

import java.util.List;
import java.util.Set;

public interface Writer {
    boolean writeOperations(List<Operation> operations, Set<String> files);
}
