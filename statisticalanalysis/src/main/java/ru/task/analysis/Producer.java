package ru.task.analysis;

public class Producer {
    ProcessConfiguration config;

    public void produce(String[] args) throws Exception {
        //todo входая строка
        config =  ProcessConfiguration.getConfiguratoin(args);
        

    }
}
