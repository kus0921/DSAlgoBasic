import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class ContactInfo {

    List<String> emails;

    public ContactInfo(List<String> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "emails=" + emails +
                '}';
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }
}

public class Employee {
    private String name;
    private ContactInfo contactInfo;

    public Employee() {
    }

    public Employee(String name, ContactInfo contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee("first", new ContactInfo(Arrays.asList("amar@gmail.com", "amar@epam.com")));
        Employee emp2 = new Employee("second", new ContactInfo(Arrays.asList("second@Gmail.com", "second@EPAM.com")));
        Employee employee3 = new Employee("third", new ContactInfo(Arrays.asList("third@Yahoo.com", "third@facebook.com")));
        Employee employee4 = new Employee("fourth", new ContactInfo(Arrays.asList("third@Yahoo.com", null)));
        Employee employee5 = new Employee("fifth", null);
        Employee employee6 = new Employee("sixth", new ContactInfo(null));
        System.out.print(countTheNumberOfUniqueDomains(Arrays.asList(emp1, emp2, employee3, employee4, employee5, null, employee6)).toString());
    }

    private static Set<String> countTheNumberOfUniqueDomains(List<Employee> employees) {
        // write your code here.>
        Set<String> hm = new HashSet<>();
        hm = employees.stream()
                .filter(Objects::nonNull)
                .map(Employee::getContactInfo)
                .filter(Objects::nonNull)
                .map(ContactInfo::getEmails)
                .peek(System.out::println)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .map(input->input.substring(input.indexOf('@')))
                .distinct()
                .collect(Collectors.toSet());


        return hm;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", contactInfo=" + contactInfo +
                '}';
    }

    public String getName() {
        return name;
    }
    //expected output : { "epam.com:2, "gmail.com":2, "yahoo.com":2, "facebook.com":1}

    public ContactInfo getContactInfo() {
        return contactInfo;
    }
}

