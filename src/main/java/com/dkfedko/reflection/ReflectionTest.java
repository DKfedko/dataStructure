package com.dkfedko.reflection;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ReflectionTest {
    public ReflectionTest() throws NoSuchMethodException {
    }

    public static void main(String[] args) {
        Class<Person> clazz = Person.class;



        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods){
            System.out.println(method.getName());
        }

        Annotation[] annotations = clazz.getDeclaredAnnotations();
            for (Annotation annotation : annotations){
                System.out.println(annotation.annotationType());
        }

        for (Class interfaze : clazz.getInterfaces()){
            System.out.println(interfaze.getName());
        }

    }

}


