
import java.util.*;

class Person {
    String name;
    int age;
    double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class SortPersonsByAge {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30, 50000),
            new Person("Bob", 24, 45000),
            new Person("Charlie", 28, 47000),
            new Person("David", 22, 42000)
        );

        people.sort((p1, p2) -> Integer.compare(p1.age, p2.age));

        System.out.println("Sorted by Age (Ascending):");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
