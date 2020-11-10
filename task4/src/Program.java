import java.time.LocalDate;
import java.util.Scanner;

public class Program {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        String userInput;
        do {
            System.out.println("Добро пожаловать!" +
                    "\nВыберите вариант дальнейшей работы:" +
                    "\n1.Добавить сотрудника." +
                    "\n2.Назначить смену сотруднику" +
                    "\n3.Забронировать столик" +
                    "\n4.Работа с меню" +
                    "\n5.Изменить способы оплаты" +
                    "\n6.Выход");
            userInput = IN.nextLine();
            switch (userInput) {
                case "1":
                    createStaff(restaurant);
                    printStaff(restaurant);
                    break;
                case "2":
                    createShedule(restaurant);
                    printShedule(restaurant);
                    break;
                case "3":
                    createReservation(restaurant);
                    printReservation(restaurant);
                    break;
                case "4":
                    System.out.println("Что именно вы хотите сделать?" +
                            "\n1.Добавить блюдо" +
                            "\n2.Удалить блюдо");
                    userInput = IN.nextLine();
                    switch (userInput) {
                        case "1":
                            menuAdd(restaurant);
                            printMenu(restaurant);
                            break;
                        case "2":
                            menuDel(restaurant);
                            printMenu(restaurant);
                            break;
                        default:
                            System.out.println("Выберите из предложенных вариантов!");
                            break;
                    }

                    break;
                case "5":
                    createPayment(restaurant);
                    printPayment(restaurant);
                    break;
                case "6":
                    System.out.println("Спасибо за работу!");
                    break;
                default:
                    System.out.println("Выберите из предложенных вариантов!");
                    break;
            }
        } while (!"6".equals(userInput));
    }

    private static void printStaff(Restaurant restaurant) {
        System.out.println("Список сотрудников:");
        for (int i = 0; i < restaurant.getStaffs().size(); ++i) {
            Staff staff = restaurant.getStaffs().get(i);
            System.out.println(i + ". " + staff);
        }
    }

    private static void createStaff(Restaurant restaurant) {
        System.out.println("Введите имя сотрудника");
        String staffName = IN.nextLine();
        System.out.println("На какую должность:");
        Position[] position = Position.values();
        for (int i = 0; i < Position.values().length; ++i) {
            System.out.println(i + ". " + position[i]);
        }
        String posChoice = IN.nextLine();
        int posChoiceInt = Integer.parseInt(posChoice);
        Staff newStaff = new Staff(staffName, position[posChoiceInt]);
        restaurant.addStaff(newStaff);
    }

    private static void createShedule(Restaurant restaurant) {
        System.out.println("Выберите сотрудника");
        for (int i = 0; i < restaurant.getStaffs().size(); ++i) {
            System.out.println(i + "." + restaurant.getStaffs().get(i));
        }
        String staffChoice = IN.nextLine();
        int staffChoiceInt = Integer.parseInt(staffChoice);
        Staff sheduleStaff = restaurant.getStaffs().get(staffChoiceInt);

        System.out.println("Введите дату смены в формате гггг-мм-дд");
        String dateAsString = IN.nextLine();
        LocalDate date = LocalDate.parse(dateAsString);
        Shedule newShedule = new Shedule(sheduleStaff, date);
        try {
            restaurant.addShedule(newShedule);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printShedule(Restaurant restaurant) {
        System.out.println("График:");
        for (int i = 0; i < restaurant.getShedules().size(); ++i) {
            Shedule shedule = restaurant.getShedules().get(i);
            System.out.println(i + ". " + shedule);
        }
    }

    private static void createReservation(Restaurant restaurant) {
        System.out.println("Выберите место:");
        Site[] sites = Site.values();
        for (int i = 0; i < Site.values().length; ++i) {
            System.out.println(i + ". " + sites[i]);
        }
        String posChoice = IN.nextLine();
        int posChoiceInt = Integer.parseInt(posChoice);
        System.out.println("Введите дату смены в формате гггг-мм-дд");
        String dateAsString = IN.nextLine();
        LocalDate date = LocalDate.parse(dateAsString);
        Reservation newRes = new Reservation(date, sites[posChoiceInt], restaurant.getReservations().size() + 1);
        try {
            restaurant.addReservation(newRes);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printReservation(Restaurant restaurant) {
        System.out.println("Список брони:");
        for (int i = 0; i < restaurant.getReservations().size(); ++i) {
            Reservation reservation = restaurant.getReservations().get(i);
            System.out.println(i + ". " + reservation);
        }
    }

    private static void menuAdd(Restaurant restaurant) {
        System.out.println("Название блюда:");
        String menuName = IN.nextLine();
        System.out.println("Код блюда в меню:");
        String menuID = IN.nextLine();
        int menuIDInt = Integer.parseInt(menuID);
        Menu newMenu = new Menu(menuName, menuIDInt);
        try {
            restaurant.addMenu(newMenu);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void printMenu(Restaurant restaurant) {
        System.out.println("Меню:");
        for (int i = 0; i < restaurant.getMenus().size(); ++i) {
            Menu menu = restaurant.getMenus().get(i);
            System.out.println(i + ". " + menu);
        }
    }

    private static void menuDel(Restaurant restaurant) {
        System.out.println("Какое блюдо удалить?");
        for (int i = 0; i < restaurant.getMenus().size(); ++i) {
            Menu menu = restaurant.getMenus().get(i);
            System.out.println(i + ". " + menu);
        }
        String menuDel = IN.nextLine();
        int menuDelInt = Integer.parseInt(menuDel);
        restaurant.menuDel(menuDelInt);
    }

    private static void createPayment(Restaurant restaurant){
        System.out.println("Добавьте способ оплаты");
        String paymentName = IN.nextLine();
        Payment payment = new Payment(paymentName);
        restaurant.addPayment(payment);
    }

    private static void printPayment(Restaurant restaurant){
        for (int i = 0; i < restaurant.getPayments().size(); ++i) {
            Payment payment = restaurant.getPayments().get(i);
            System.out.println(i + ". " + payment);
        }
    }
}
