package ru.task.generator.impl;

import ru.task.generator.agreement.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class DataReader implements Reader {
    Set<String> pointSet;

    @Override
    public Set<String> readSailPoints(String path) {
        pointSet = new HashSet<>();

        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            stream.forEach(this::addToSalePointSet);
        } catch (IOException e){
            System.out.println("Кажется что-то пошло не так при чтении точек обслуживания");
        }

        return pointSet;
    }

    private void addToSalePointSet(String point){
        pointSet.add(point);
    }

}
