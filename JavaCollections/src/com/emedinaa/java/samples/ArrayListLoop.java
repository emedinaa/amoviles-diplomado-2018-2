package com.emedinaa.java.samples;

import java.util.ArrayList;

public class ArrayListLoop {

    public static void main(String[] args) {
        System.out.println("ArrayList Loop!");

        ArrayList<String> languages= new ArrayList<>();
        System.out.println("\n");

        languages.add("Clojure");
        languages.add("Groovy");
        languages.add("JRuby");
        languages.add("Jython");
        languages.add("Kotlin");
        languages.add("Scala");

        showList(languages);
        System.out.println("\n" +
                "");
        System.out.println("fori ------- \n");
        //fori
        for (int i = 0; i < languages.size(); i++) {
            System.out.println(languages.get(i));
        }
        System.out.println("\n");
        System.out.println("foreach ------- \n");
        //for
        for (String language : languages) {
            System.out.println(language);
        }

        System.out.println("\n");
        System.out.println("while ------- \n");
        //while
        int count = 0;
        while (languages.size() > count) {
            System.out.println(languages.get(count));
            count++;
        }
    }

    public static void showList(Object object){
        System.out.println("JVM Languages "+object);
    }
}
