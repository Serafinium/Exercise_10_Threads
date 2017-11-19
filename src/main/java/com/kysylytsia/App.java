package com.kysylytsia;


import java.io.*;

import java.util.ArrayList;

import java.util.List;


/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        String file = "let and const are two relatively new types of variable declarations in JavaScript. As we mentioned earlier, let is\n" +
                "similar to var in some respects, but allows users to avoid some of the common “gotchas” that users run into in\n" +
                "JavaScript. const is an augmentation of let in that it prevents re-assignment to a variable.\n" +
                "With TypeScript being a superset of JavaScript, the language naturally supports let and const. Here we’ll elaborate more\n" +
                "on these new declarations and why they’re preferable to var.\n" +
                "var\n"+
                "If you’ve used JavaScript offhandedly, the next section might be a good way to refresh your memory. If you’re intimately\n" +
                "familiar with all the quirks of var declarations in JavaScript, you might find it easier to skip ahead.";

        // write to file
        App.writeTextInFile(file);


        //read from file
        List<String> list = App.ReadTextInFile(file);

        // Answer to the question
        App.analysisMethod(list);


    }

    public static void writeTextInFile(String text){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter("note.txt", false));
            bufferedWriter.write(text);
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static List<String> ReadTextInFile (String text) {

        List<String> array = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader( new FileReader("note.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String line = new String();

        try {
            while( ( line = reader.readLine() )  != null) {
                array.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return array;
    }


    public static void analysisMethod (List<String> list){


        int[] countArray = new int[list.size()];
        int maxSize = list.get(0).length();
        int minSize = list.get(0).length();;
        int positionMin = 0;
        int positionMax = 0;
        //int []positionWord = new int[list.size()];
        List<Integer> positionWord = new ArrayList<>();




        for(int i=0; i<list.size(); i++){
            countArray[i] = list.get(i).length();

            if(maxSize<list.get(i).length()){
                maxSize = list.get(i).length();
                positionMax = (i);
            }

            if(minSize>list.get(i).length()){
                minSize = list.get(i).length();
                positionMin = (i);
            }


            if (list.get(i).contains("var")) {
                positionWord.add(i);
            }
        }

        System.out.println("count symbols in every line: ");
        for (int i = 0; i<countArray.length; i++){
            System.out.println("Column № " + (i+1) + "  contains: " + countArray[i] + " symbols");
        }

        System.out.println();

        System.out.println("Longest line: " + (positionMax+1) + "  contains: " + maxSize);
        System.out.println("Shortest line: " + (positionMin+1) + "  contains: " + minSize);


        System.out.println();

        for (int i = 0; i<positionWord.size(); i++){
            System.out.println("Word contains in: " + (positionWord.get(i)+1) + "  column" + " value column:  " + list.get(positionWord.get(i)));
        }

        // P/S: +1 для того, щоб вивід ішов не з 0, а з 1.
    }


}