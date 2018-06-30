package com.emedinaa.java.samples;

import java.util.ArrayList;

/**
 * https://en.wikipedia.org/wiki/List_of_JVM_languages
 */
public class ArrayListSamples {

    public static void main(String[] args)
    {
        System.out.println("ArrayList!");

        //ArrayList<String> days= new ArrayList<String>();
        ArrayList<String> languages= new ArrayList<>();

        //Add elements
        languages.add("Clojure");
        languages.add("Groovy");
        languages.add("JRuby");
        languages.add("Jython");
        languages.add("Kotlin");
        languages.add("Scala");

        System.out.println("JVM Languages "+languages);
        //JVM Languages [Clojure, Groovy, JRuby, Jython, Kotlin, Scala]

        languages.add(0,"Clojure, a functional Lisp dialect");
        languages.add(1,"Groovy, a dynamic programming and scripting language");

        System.out.println("JVM Languages "+languages);
        //JVM Languages [Clojure, a functional Lisp dialect, Groovy, a dynamic programming and scripting language, Clojure, Groovy, JRuby, Jython, Kotlin, Scala]

        //Remove elements
        languages.add("Java");
        showList(languages);
        //JVM Languages [Clojure, a functional Lisp dialect, Groovy, a dynamic programming and scripting language, Clojure, Groovy, JRuby, Jython, Kotlin, Scala, Java]

        languages.remove("Java");
        showList(languages);
        //JVM Languages [Clojure, a functional Lisp dialect, Groovy, a dynamic programming and scripting language, Clojure, Groovy, JRuby, Jython, Kotlin, Scala]

        languages.add("Java");
        languages.remove(languages.size()-1);
        showList(languages);
        //JVM Languages [Clojure, a functional Lisp dialect, Groovy, a dynamic programming and scripting language, Clojure, Groovy, JRuby, Jython, Kotlin, Scala]

    }

    public static void showList(Object object){
        System.out.println("JVM Languages "+object);
    }
}
