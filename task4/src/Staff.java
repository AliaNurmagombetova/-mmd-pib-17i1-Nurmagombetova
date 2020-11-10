public class Staff {

    private final String name;
    private final Position position;

    public Staff(String name, Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPosition();
    }


}
