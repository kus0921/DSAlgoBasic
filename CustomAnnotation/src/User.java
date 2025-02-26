public class User {
    @NotEmpty(message = "Name must not be blank")
    String name;
    @Range(min=6,max=19,message="Age must be between 6 to 19")
    int age;

    public User(String alice, int i) {
        this.name=alice;
        this.age=i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
