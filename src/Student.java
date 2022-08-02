import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private List<Course> courses;
    private int age;
    private List<String> basicKnowledges;

    public Student(String name, List<Course> courses, int age, List<String> basicKnowledges) {
        this.name = name;
        this.courses = courses;
        this.age = age;
        this.basicKnowledges = basicKnowledges;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getAge() {
        return age;
    }

    public List<String> getBasicKnowledges() {
        return basicKnowledges;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age && name.equals(student.name) && courses.equals(student.courses) && basicKnowledges.equals(student.basicKnowledges);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, courses, age, basicKnowledges);
    }
}
