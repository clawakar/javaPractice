package com.chetan.javaPractice.classClassDemo;

public class ClassDemo {
    int x;
    int y;
    static int z;

    void f1() {

    }

    static void f2(){

    }

    public static void main(String[] args) {
        ClassDemo classDemo = new ClassDemo();

        Class c = classDemo.getClass();

        System.out.println("c.getName() : " +c.getName());
        System.out.println("c.getClassLoader() : " +c.getClassLoader());
        System.out.println("c.getConstructors() : " +c.getConstructors().toString());
        System.out.println("c.getDeclaredFields() : " +c.getDeclaredFields());
        System.out.println("c.getDeclaredMethods() : " +c.getDeclaredMethods());
        System.out.println("c.getFields() : " +c.getFields());
        System.out.println("c.getInterfaces() : " +c.getInterfaces());
        System.out.println("c.getMethods() : " +c.getMethods());
        System.out.println("c.getModifiers() : " +c.getModifiers());
        System.out.println("c.getPackage() : " +c.getPackage());
        System.out.println("c.getSuperclass() : " +c.getSuperclass());
        System.out.println("c.getGenericSuperclass() : " +c.getGenericSuperclass());
        System.out.println("c.getTypeName() : " +c.getTypeName());
        System.out.println("c.getGenericInterfaces() : " +c.getGenericInterfaces());

    }

}

/*
OUTPUT :
c.getName() : com.chetan.javaPractice.classClassDemo.ClassDemo
c.getClassLoader() : sun.misc.Launcher$AppClassLoader@14dad5dc
c.getConstructors() : [Ljava.lang.reflect.Constructor;@61bbe9ba
c.getDeclaredFields() : [Ljava.lang.reflect.Field;@610455d6
c.getDeclaredMethods() : [Ljava.lang.reflect.Method;@511d50c0
c.getFields() : [Ljava.lang.reflect.Field;@5e2de80c
c.getInterfaces() : [Ljava.lang.Class;@1d44bcfa
c.getMethods() : [Ljava.lang.reflect.Method;@266474c2
c.getModifiers() : 1
c.getPackage() : package com.chetan.javaPractice.classClassDemo
c.getSuperclass() : class java.lang.Object
c.getGenericSuperclass() : class java.lang.Object
c.getTypeName() : com.chetan.javaPractice.classClassDemo.ClassDemo
c.getGenericInterfaces() : [Ljava.lang.Class;@6f94fa3e
 */