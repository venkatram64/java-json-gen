package com.venkat.jsongen.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;

/**
 * Created by venkatram.veerareddy on 8/7/2017.
 */


public class WordList {

    public static String[] fileReader(){

        String[] words = new String[100];
        try{
            //URL path = ClassLoader.getSystemResource("word-list.txt");

            //URL path = WordList.class.getClass().getResource("C:\\XXX\\eclipse\\work\\JSONN-Gen\\src\\com\\venkat\\json\\word-list.txt");

            FileReader fr = new FileReader("word-list.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int i = 0;
            while((line = br.readLine()) != null && i != 100){
                if(line.length() > 4){
                    words[i] = line.trim();
                    i++;
                }
            }
            br.close();
            fr.close();

        }catch(Exception ex){

        }
        return words;
    }

    public static void main(String[] args){
        String[] words = fileReader();
        for(String s : words){
            System.out.println(s);
        }
    }
}
