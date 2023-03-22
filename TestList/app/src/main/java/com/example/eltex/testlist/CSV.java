package com.example.eltex.testlist;

// TODO: сделать интерфейс для хранения в файлах??? необходимо обращение к фаловой системе

public interface CSV {

    String toCSV();
    void fromCSV(String str);

}
