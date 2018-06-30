package com.emedinaa.java.samples;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListInitialization {

    public static void main(String[] args) {
        System.out.println("ArrayList Initialization!");

        ArrayList<String> languages = new ArrayList<String>(
                Arrays.asList("Clojure", "Groovy", "JRuby", "Jython","Kotlin","Scala"));

        showList(languages);
        //JVM Languages [Clojure, Groovy, JRuby, Jython, Kotlin, Scala]

        ArrayList<String> languages1 = new ArrayList<String>(){{
            add("Clojure");
            add("Groovy");
            add("JRuby");
            add("Jython");
            add("Kotlin");
            add("Scala");
        }};
        showList(languages1);
        //JVM Languages [Clojure, Groovy, JRuby, Jython, Kotlin, Scala]
    }


    public static void showList(Object object){
        System.out.println("JVM Languages "+object);
    }
}
