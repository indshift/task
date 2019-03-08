package ru.task.generator.objects;

import java.util.ArrayList;

/**
 * Класс для хранения путей к файлам
 * Используется для того, чтобы сохранить порядо
 * переданных файлов для записи результатов и,
 * при этом, не хранить дублирующиеся названия файлов
 */
public class ResultFiles {

    private ArrayList<String> files;

    public ResultFiles() {
        this.files = new ArrayList<>();
    }

    public void addFile(String file){
        if(!files.contains(file)){
            files.add(file);
        }
    }

    public String getFile(int index){
        return  files.get(index);
    }

    public int getSize(){
        return files.size();
    }

    @Override
    public String toString() {
        return "{" + files + '}';
    }
}
