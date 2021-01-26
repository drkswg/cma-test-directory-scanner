package com.drkswg;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        Searcher searcher = new Searcher();
        searcher.setDirectory("C:\\Users\\123\\Desktop\\folder");
        File file = new File(searcher.getDirectory());
        searcher.search(file);
        searcher.sort();
        searcher.processingFiles();
        System.out.println(
                "Всего найдено текстовых файлов: "
                        + searcher.getTxtFilesList().size() +
                        ", данные из которых были записаны " +
                "в результирующий файл: " + searcher.getDirectory() + "\\result.txt");
    }
}

