package ru.task.analysis.agreement;

import ru.task.analysis.objects.DataInputFiles;

import java.util.List;

public interface Reader {
    /**
     * Соглашение о чтении из файлов данных
     * для анализа
     * @param files
     * @return
     */
    List<String> readFromFiles(DataInputFiles files);
}
