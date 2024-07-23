package assignments.day14.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person {
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name= "+name+", age= "+age+"}";
    }
    public static void main(String[] args) {
        List<Person> people=new ArrayList<>();
        people.add(new Person("Rahul", 24));
        people.add(new Person("Arjun", 23));
        people.add(new Person("Kamal", 21));
        people.add(new Person("Kriti", 23));
        people.add(new Person("Sneha", 24));
        Comparator<Person> byAge= (p1,p2)->p1.getAge().compareTo(p2.getAge());
        people.sort(byAge);
        System.out.println(people);
    }   
}