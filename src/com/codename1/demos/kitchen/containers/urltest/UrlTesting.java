package com.codename1.demos.kitchen.containers.urltest;

class UrlTesting {
    public static void main(String[] args) {
        UrltestBaseclass class1 = new TestClass1();
        UrltestBaseclass class2 = new TestClass2();
        UrltestBaseclass class3 = new TestClass3();

        print("___________Printting for class 1 ____________\n\n\n\n\n");
        print("Simple Name: "+class1.getSimpleNameUrl());
        print("Cannonical Name: "+class1.getCannonicalUrl());

        print("___________Printting for class 2 ____________\n\n\n\n\n");
        print("Simple Name: "+class2.getSimpleNameUrl());
        print("Cannonical Name: "+class2.getCannonicalUrl());

        print("___________Printting for class 3 ____________\n\n\n\n\n");
        print("Simple Name: "+class3.getSimpleNameUrl());
        print("Cannonical Name: "+class3.getCannonicalUrl());
    }

    static void print(String print){
        System.out.println(print);
    }
}