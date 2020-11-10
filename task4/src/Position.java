public enum Position {
    WAITER("Официант"),
    MANAGER("Менеджер"),
    COOK("Повар");

    private final String name;

    Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
//