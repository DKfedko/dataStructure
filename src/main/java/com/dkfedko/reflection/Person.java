package com.dkfedko.reflection;
import com.dkfedko.reflection.anotations.Inject;
import com.dkfedko.reflection.anotations.Reflection;
import com.dkfedko.reflection.anotations.Run;

public class Person implements Reflection {


    String name;
    String salary;
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

    @Override
    @Inject
    public void printName() {
    System.out.println("name is  :" + name);
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
    @Run
    public String getSalary() {
        System.out.println("salary is: " + salary);
        return salary;
    }

    public Class<Person> getClass(Class<Person> clazz) {
        return clazz;
    }


}
