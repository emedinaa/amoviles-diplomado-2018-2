package com.emedinaa.java.samples;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListSorting {

    public static void main(String[] args) {
        System.out.println("ArrayList Sorting!");

        ArrayList<String> languages= new ArrayList<>();
        System.out.println("\n");

        languages.add("JRuby");
        languages.add("Scala");
        languages.add("Java");
        languages.add("Clojure");
        languages.add("Jython");
        languages.add("Kotlin");
        languages.add("Groovy");

        showList(languages);
        System.out.println("\n");
        //JVM Languages [JRuby, Scala, Java, Clojure, Jython, Kotlin, Groovy]

        //sorting
        Collections.sort(languages);
        showList(languages);
        //JVM Languages [Clojure, Groovy, JRuby, Java, Jython, Kotlin, Scala]

        //Sorting in decreasing order*
        Collections.sort(languages,Collections.reverseOrder());
        showList(languages);
        //JVM Languages [Scala, Kotlin, Jython, Java, JRuby, Groovy, Clojure]
    }

    public static void showList(Object object){
        System.out.println("JVM Languages "+object);
    }
}
