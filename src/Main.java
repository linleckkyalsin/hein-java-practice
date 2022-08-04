import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Set<Course> courses = new HashSet<Course>();
        students.forEach(student -> student.getCourses().stream().forEach(c -> courses.add(c)));
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        System.out.println("===すべての学生を表示する===");
        students.forEach(s -> System.out.println("生徒の名前： %s　コース： %s".formatted(s.getName(), s.getCourses().stream().map(Course::getName).collect(Collectors.joining("/")))));

        System.out.println("===すべてのコースを表示する===");
        courses.forEach(course -> System.out.printf("コースの名前: %s 期間: %dヶ月間\n", course.getName(), course.getMonths()));

        System.out.println("===料金250,000kyats以下のコースを表示する===");
        courses.stream().filter(course -> course.getFees() <= 250000).collect(Collectors.toList()).forEach(c -> System.out.printf("%s コースの料金は %sチャットです。\n", c.getName(), decimalFormat.format(c.getFees())));
        
        System.out.println("===コースの開始日と終了日を表示する===");
        courses.forEach(course -> System.out.printf("%s コースの開始日は %sで、終了日は %sです。\n", course.getName(), course.getStartDate(), course.getStartDate().plusMonths(course.getMonths())));

        System.out.println("===Spring Frameworkコースを取っている生徒を表示する===");
        students.stream().filter(student -> student.getCourses().stream().map(Course::getName).collect(Collectors.toList()).stream().anyMatch("Spring Framework"::equals)).forEach(student -> System.out.printf("生徒の名前： %s 年齢： %s歳\n", student.getName(), student.getAge()));

        System.out.println("===生徒の基礎を表示する===");
        students.stream().forEach(student -> System.out.printf("%sは%sを勉強したことあります。\n", student.getName(), student.getBasicKnowledges().stream().collect(Collectors.joining(","))));

        System.out.println("===HTMLを勉強した生徒を表示する。===");
        students.stream().filter(student -> student.getBasicKnowledges().stream().anyMatch("HTML"::equals)).forEach(student -> System.out.printf("%sはHTMLを勉強したことあります。\n", student.getName()));

        System.out.println("===生徒全員が30歳未満かチェックして表示する。===");
        if (students.stream().allMatch(student -> student.getAge() < 30)){
            students.forEach(student -> System.out.printf(""));
        }
        else {
            System.out.println("30歳以上の生徒がいます！");
        }

        System.out.println("===Hein Thantという名前の生徒がいるかチェックする。===");
        checkStudentExist("hein thant", students);

        System.out.println("===Johnという名前の生徒がいるかチェックする。===");
        checkStudentExist("Jhon", students);
    }
    private static void checkStudentExist(String searchName, List<Student> students){

        List<Student> filteredStudents = students.stream().filter(student -> student.getName().toLowerCase().contains(searchName.toLowerCase())).collect(Collectors.toList());
        if (filteredStudents.isEmpty()){
            System.out.println("その名前で授業を取っている生徒はいません。");
        }
        else {
            filteredStudents.forEach(student -> System.out.printf("%sは%s コースを取っています。\n", student.getName(), student.getCourses().stream().map(Course::getName).collect(Collectors.joining("/"))));
        }
    }

}
