import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course c1 = new Course("Java", 4, 200000, LocalDate.of(2022, 7, 3));
        Course c2 = new Course("Spring Framework", 6, 250000, LocalDate.of(2022, 10, 15));
        Course c3 = new Course("Node.js", 5, 300000, LocalDate.of(2023, 1, 15));
        List<Student> students = List.of(
                new Student("Hein Thant", List.of(c1, c2), 24, List.of("HTML", "CSS")),
                new Student("Thidar", List.of(c3), 30, List.of("CSS")),
                new Student("Kyi Phyar", List.of(c1,c3), 26, List.of("CSS", "DataBase")),
                new Student("Zwe", List.of(c2), 20, List.of("HTML", "CSS", "Database")));
        System.out.println("===すべての学生を表示する===");
        students.forEach(s -> System.out.println("生徒の名前： %s、コース：　%sを取っています。".formatted(s.getName(), s.getCourses().stream().map(Course::getName).collect(Collectors.joining("/")))));
    }
}
