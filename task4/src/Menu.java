public class Menu {

    private final String name;
    private final int ID;

    public Menu(String name, int id) {
        this.name = name;
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Код блюда : " + getID() + ", название блюда : " + name;
    }
}
