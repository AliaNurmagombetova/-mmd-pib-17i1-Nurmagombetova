public enum Site {
    TOP("Сверху"),
    MIDDLE("По центру"),
    BOTTOM("Снизу");

    private final String name;

    Site(String name) {
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
