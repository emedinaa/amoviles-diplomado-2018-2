package com.emedinaa.java;

import com.emedinaa.java.entity.Car;
import com.emedinaa.java.entity.Ford;
import com.emedinaa.java.entity.Sum;
import com.emedinaa.java.interfaces.MyInfB;
import com.emedinaa.java.interfaces.MyInterface;

public class Main {

    public static void main(String args[]){

        Sum sum= new Sum();
        System.out.println("Sum 2 :"+sum.add(10,20));
        System.out.println("Sum 3 :"+sum.add(10,20,30));

        Car car= new Ford();
        int num= car.speedLimit();
        System.out.println("Speed Limit is: "+num);

        MyInterface demo= new DemoInterface();
        demo.method1();

        MyInfB demoAB= new DemoInterfaceAB();
        demoAB.method1();
    }
}
