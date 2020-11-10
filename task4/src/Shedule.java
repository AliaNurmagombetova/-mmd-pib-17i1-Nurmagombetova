import java.time.LocalDate;

public class Shedule implements Clock {
    private final LocalDate date;
    private final Staff staff;

    public Shedule(Staff staff, LocalDate date) {
        this.date = date;
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Смена: Время - " + date + ", сотрудник - " + staff;
    }
}
