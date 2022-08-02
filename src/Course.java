import java.time.LocalDate;
import java.util.Objects;

public class Course {
    private final String name;
    private final int months;
    private final int fees;
    private final LocalDate startDate;

    public Course(String name, int months, int fees, LocalDate startDate) {
        this.name = name;
        this.months = months;
        this.fees = fees;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public int getMonths() {
        return months;
    }

    public int getFees() {
        return fees;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return months == course.months && fees == course.fees && name.equals(course.name) && startDate.equals(course.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, months, fees, startDate);
    }
}
