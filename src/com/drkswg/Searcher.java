package com.drkswg;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Searcher {
    private String directory;
    private ArrayList<File> txtFilesList = new ArrayList<>();

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public ArrayList<File> getTxtFilesList() {
        return txtFilesList;
    }

    public void search(File directory){
        if(directory.isDirectory()){
            for(File file : directory.listFiles()){
                if(file.isFile() && (file.getName().endsWith(".txt") || file.getName().endsWith(".TXT"))){
                    txtFilesList.add(file);
                } else {
                    search(file);
                }
            }
        }

        if(txtFilesList.size() == 0){
            System.out.println("В указанной вами директории файлов формата \".txt\" не найдено, " +
                    "файл результата не изменён.");
            System.exit(0);
        }
    }

    public void sort(){

        Comparator<File> comparator = new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(this.txtFilesList, comparator);
    }

    public void processingFiles() {
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(directory + "\\result.txt"));
            for ( File file : this.txtFilesList ) {
                try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file.toString())))
                {
                    while (bufferedReader.ready()){
                        bufferedWriter.write(bufferedReader.readLine());
                        bufferedWriter.newLine();
                    }
                }
            }
            bufferedWriter.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
