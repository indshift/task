package ru.task.analysis.agreement;

import ru.task.analysis.objects.Operation;

import java.util.List;

public interface Parser {
    /**
     * Соглашение о переводе строковых записей в
     * объекты - операции
     * @param operations
     * @return лист с объектами-операциями
     */
    List<Operation> parse(List<String> operations);
}
