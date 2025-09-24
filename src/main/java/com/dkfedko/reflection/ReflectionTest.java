package com.dkfedko.reflection;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ReflectionTest {
    public ReflectionTest() throws NoSuchMethodException {
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> clazz = Person.class;

        Method printName = clazz.getMethod("printName");
        Method getAge = clazz.getMethod("getAge");
        Method getWeight = clazz.getMethod("getWeight");
        Method getSalary = clazz.getMethod("getSalary");
        Method getPerson = clazz.getMethod("getClass", Class.class);

        System.out.println(printName);
        System.out.println(getWeight);
        System.out.println(getAge);
        System.out.println(getSalary);
        System.out.println(getPerson);

        Person person = new Person();

        person.name = "Danylo";
        person.weight = 100.5;
        person.age = 20;
        person.salary = "$2500";

        printName.invoke(person);

        Object weight = getWeight.invoke(person);
        System.out.println("weight is: " + (double) weight);

        Object age = getAge.invoke(person);
        System.out.println("my age is : " + (int) age);

        getSalary.invoke(person);


        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }

        Annotation[] annotations = clazz.getDeclaredAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
        }

        for (Class interfaze : clazz.getInterfaces()) {
            System.out.println(interfaze.getName());
        }

    }
}


