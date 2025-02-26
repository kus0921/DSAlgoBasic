import java.util.*;
import java.util.stream.Collectors;

public class HighestSalaryInDept {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Alice", "IT", 70000),
                new Employee("Bob", "HR", 50000),
                new Employee("Charlie", "IT", 90000),
                new Employee("David", "HR", 60000),
                new Employee("Eve", "Finance", 75000),
                new Employee("Frank", "Finance", 85000)
        );

        // Find highest salary employee in each department
        Map<String, Optional<Employee>> highestSalaryEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        // Print results
        highestSalaryEmployees.forEach((dept, emp) ->
                System.out.println("Department: " + dept + " -> " + emp.get().getName() + " (Salary: " + emp.get().getSalary() + ")")
        );


        Map<String, Employee> maxByDepartment = employees.stream()
                .collect(Collectors.toMap(Employee::getDepartment,
                        e -> e,
                        (e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2));

        maxByDepartment.forEach((s, employee) -> System.out.println(s+":"+employee.getName()+":"+employee.getSalary()));
    }
}
