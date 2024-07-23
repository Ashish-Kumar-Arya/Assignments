package assignments.day14.task5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

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
}

class PersonOperations {
    public static void operateOnPerson(
    Predicate<Person> predicate,
    Function<Person, String> function,
    Consumer<List<Person>> consumer,
    Supplier<Person> supplier
    ) {
        List<Person> people=new ArrayList<>(Arrays.asList(new Person("Ashish", 23), new Person("Manish", 24), new Person("Kamal", 21), new Person("Sneha", 25)) );
        List<Person> ap=people.stream().filter(predicate).collect(Collectors.toList());
        System.out.println("People age greater than 22: "+ap);

        List<String> cap=people.stream().map(function).collect(Collectors.toList());
        System.out.println("List with capitalized names: "+cap);
        
        people.add(supplier.get());
        
        consumer.accept(people);
        System.out.println("People with names and year of birth: "+people);

        
    }

    public static void main(String[] args) {
        operateOnPerson(
            p->p.getAge()>22,
            p->p.getName().toUpperCase(),
            ls->{
                for(int i=0;i<ls.size();i++) {
                    ls.get(i).setAge(LocalDate.now().getYear()-ls.get(i).getAge());;
                }
            },
            ()->new Person("Kavita", 25)
            );
    }
}