package ru.task.generator.agreement;

import ru.task.generator.ProcessConfiguration;
import ru.task.generator.objects.Operation;

import java.util.List;

public interface Generator {
    /**
     * Метод получает на вход точки обслуживания
     * Возвращает набор строк в виде:
     * дата, время, номер точки продаж, номер операции, сумма операции
     *
     * Если что-то пошло не так, возвращает null
     *
     * @param configuration
     * @return
     */
    List<Operation> generateOperations(ProcessConfiguration configuration);
}
