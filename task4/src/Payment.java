public class Payment {

    private final String Type;

    public Payment(String type) {
        Type = type;
    }

    public String getType() {
        return Type;
    }

    @Override
    public String toString() {
        return "Способ оплаты : " + Type;
    }
}
