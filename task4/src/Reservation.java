import java.time.LocalDate;

public class Reservation implements Clock {

    private final int ID;
    private final LocalDate date;
    private final Site site;

    public Reservation(LocalDate date, Site site, int id) {
        this.date = date;
        this.site = site;
        this.ID = id;
    }

    public int getID() {
        return ID;
    }

    public Site getSite() {
        return site;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Номер брони : " + getID() +
                ", Дата : " + date +
                ", Место : " + site;
    }
}
