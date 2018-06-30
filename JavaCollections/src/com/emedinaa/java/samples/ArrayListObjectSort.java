package com.emedinaa.java.samples;

import com.emedinaa.java.samples.model.User;
import com.emedinaa.java.samples.model.UserC;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListObjectSort {

    public static void main(String[] args) {
        System.out.println("ArrayList  Object Sort!");

        ArrayList<User> users= new ArrayList<User>();
        System.out.println("\n");

        users.add(new User(100,"Bjarne Stroustrup",67, "Bjarne Stroustrup, developer of C++."));
        users.add(new User(101,"Chris Lattner",40, "Chris Lattner, creator of Swift and LLVM."));
        users.add(new User(102,"Guido van Rossum",62, "Guido van Rossum, creator of Python."));
        users.add(new User(103,"Yukihiro Matsumoto",53, "Yukihiro Matsumoto, creator of Ruby."));
        users.add(new User(104,"James Gosling",63, "James Gosling, lead developer of Java and its precursor, Oak."));

        showList(users);
        //user User{id=100, name='Bjarne Stroustrup', age=67, info='Bjarne Stroustrup, developer of C++.'}
        //user User{id=101, name='Chris Lattner', age=40, info='Chris Lattner, creator of Swift and LLVM.'}
        //user User{id=102, name='Guido van Rossum', age=62, info='Guido van Rossum, creator of Python.'}
        //user User{id=103, name='Yukihiro Matsumoto', age=53, info='Yukihiro Matsumoto, creator of Ruby.'}
        //user User{id=104, name='James Gosling', age=63, info='James Gosling, lead developer of Java and its precursor, Oak.'}

        //Collections.sort(users);
        ArrayList<UserC> usercList= new ArrayList<UserC>();
        System.out.println("\n");

        usercList.add(new UserC(100,"Bjarne Stroustrup",67, "Bjarne Stroustrup, developer of C++."));
        usercList.add(new UserC(101,"Chris Lattner",40, "Chris Lattner, creator of Swift and LLVM."));
        usercList.add(new UserC(102,"Guido van Rossum",62, "Guido van Rossum, creator of Python."));
        usercList.add(new UserC(103,"Yukihiro Matsumoto",53, "Yukihiro Matsumoto, creator of Ruby."));
        usercList.add(new UserC(104,"James Gosling",63, "James Gosling, lead developer of Java and its precursor, Oak."));

        Collections.sort(usercList);

        showUserList(usercList);
        //user UserC{id=101, name='Chris Lattner', age=40, info='Chris Lattner, creator of Swift and LLVM.'}
        //user UserC{id=103, name='Yukihiro Matsumoto', age=53, info='Yukihiro Matsumoto, creator of Ruby.'}
        //user UserC{id=102, name='Guido van Rossum', age=62, info='Guido van Rossum, creator of Python.'}
        //user UserC{id=104, name='James Gosling', age=63, info='James Gosling, lead developer of Java and its precursor, Oak.'}
        //user UserC{id=100, name='Bjarne Stroustrup', age=67, info='Bjarne Stroustrup, developer of C++.'}
    }

    public static void showList(ArrayList<User> users){
        //System.out.println("Users "+users);
        for (User user:users) {
            System.out.println("user "+user);
        }
    }

    public static void showUserList(ArrayList<UserC> users){
        //System.out.println("Users "+users);
        for (UserC user:users) {
            System.out.println("user "+user);
        }
    }
}
