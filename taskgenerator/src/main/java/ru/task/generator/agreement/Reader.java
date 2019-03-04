package ru.task.generator.agreement;


import java.io.File;
import java.util.Set;

public interface Reader {
    /**
     * Метод читает из указанного файла данные - точки продаж и возвращает эти точки
     * продаж в виде множества
     * @param path
     * @return
     */
     Set<String> readSailPoints(String path);
}
