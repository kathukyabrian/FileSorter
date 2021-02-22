package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Optional;

public class Sorter {
    public static void findMusic(){
        System.out.println("This method will find  all music in your system");
        // check for mp3, wav

        // create a list to store music extensions
        String [] musicExtensions = {"mp3","wav"};

        // Create an arrayList that shall store the musics
        ArrayList<String> musicList = new ArrayList<>();

        // Create a process that will execute a command
        Process process;

        // Create a string to hold the current looped file
        String line;

        try{
            // execute the command
            process = Runtime.getRuntime().exec("find");

            // create a bufferedReader to stream the output of the command above
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // while tn bufferedReader reads a new line, add the read line to the arraylist
            while((line=bufferedReader.readLine())!=null){
                musicList.add(line);
            }
        }catch(Exception e){
            System.out.println(e);
        }

        // print out the arrayList with its contents
        System.out.println(musicList);

    }

    public static Optional<String> getExtension(String filename){
        return Optional.ofNullable(filename)
                .filter(f->f.contains("."))
                .map(f->f.substring(filename.lastIndexOf(".")+1));
    }
}
