//package com.compoent.compoent.test;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//
//public class demo {
//
//    public static void main(String[] args){
//
//        Class c = null;
//        try {
//            c = Class.forName("com.compoent.compoent.test.Person");
//        } catch (ClassNotFoundExcep+tion e) {
//            e.printStackTrace();
//        }
//        Method[] methods = c.getMethods();
//        Class<?> inter[]=null;//声明一个对象数组
//       inter =  c.getInterfaces();
//        Arrays.stream(methods).forEach(e-> System.out.println("方法名："+e.getName()));
//        Arrays.stream(inter).forEach(a-> System.out.println("接口名："+a.));
//    }
//}
