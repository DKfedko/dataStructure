package com.dkfedko.reflection;

import com.dkfedko.reflection.anotations.Reflection;

public class Person implements Reflection {

    String name;
    double salary;
    public int age;
    double weight;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age").append(age);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
    public void printName(){
        System.out.println(name);
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public void printName(int count){
        for (int i = 0; i <count; i++ ){
            System.out.println(name);
        }
    }
    public Person getClass(Class<Person> clazz){
        return null;
    }

}
