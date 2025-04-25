
import java.util.*;
import java.util.stream.*;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', dept='" + department + "', salary=" + salary + "}";
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeProcessor {

    public static void processEmployees(List<Employee> employees) { 
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Engineering") && e.getSalary() > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());

        System.out.println("\nFiltered & Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        Map<String, List<Employee>> groupedByDept = filteredSorted.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        System.out.println("\nGrouped By Department:");
        groupedByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });

        Map<String, Double> averageSalaryByDept = filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        System.out.println("\nAverage Salary By Department:");
        averageSalaryByDept.forEach((dept, avgSalary) -> {
            System.out.println(dept + ": $" + avgSalary);
        });
    }

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "Engineering", 95000),
                new Employee(3, "Charlie", "HR", 60000),
                new Employee(4, "Dave", "Engineering", 79000),
                new Employee(5, "Eve", "Engineering", 87000),
                new Employee(6, "Frank", "Marketing", 85000)
        );

        processEmployees(employeeList);
    }
}
