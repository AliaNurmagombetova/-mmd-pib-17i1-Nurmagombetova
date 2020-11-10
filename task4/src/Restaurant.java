import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private final List<Staff> staffs = new ArrayList<>();
    private final List<Menu> menus = new ArrayList<>();
    private final List<Shedule> shedules = new ArrayList<>();
    private final List<Reservation> reservations = new ArrayList<>();
    private final List<Payment> payments = new ArrayList<>();

    public Restaurant() {
        this.menus.add(new Menu("Солянка", 1));
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public List<Shedule> getShedules() {
        return shedules;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addStaff(Staff staff) {
        staffs.add(staff);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addShedule(Shedule s) throws Exception {
        for (Shedule shedule : shedules) {
            if (shedule.getDate().equals(s.getDate()) && shedule.getStaff() == s.getStaff()) {
                throw new Exception("Сотрудник уже на смене");
            }
        }
        shedules.add(s);
    }

    public void addReservation(Reservation r) throws Exception {
        for (Reservation reservation : reservations) {
            if (reservation.getDate().equals(r.getDate()) && reservation.getSite() == r.getSite()) {
                throw new Exception("Место уже занято");
            }
        }
        reservations.add(r);
    }

    public void addMenu(Menu m) throws Exception {
        for (Menu menu : menus) {
            if (menu.getID() == m.getID() && menu.getName().equals(m.getName())) {
                throw new Exception("Код блюда или его название совпадает с существующим");
            }
        }
        menus.add(m);
    }

    public void menuDel(int id) {
        menus.remove(id);
    }

    public void addPayment(Payment payment)
    {
        payments.add(payment);
    }
}
