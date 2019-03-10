package ru.task.analysis.objects;

import java.util.ArrayList;

/**
 * Класс для хранения названий файлов,
 * их которых будут стчитаны операции
 * Используется для того не хранить
 * дублирующиеся названия файлов
 */
public class DataInputFiles {

    private ArrayList<String> files;

    public DataInputFiles() {
        this.files = new ArrayList<>();
    }

    public void add(String file){
        if(!files.contains(file)){
            files.add(file);
        }
    }

    public String get(int index){
        return  files.get(index);
    }

    public int size(){
        return files.size();
    }

    @Override
    public String toString() {
        return "{" + files + '}';
    }
}
