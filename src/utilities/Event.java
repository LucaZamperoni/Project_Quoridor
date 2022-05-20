package utilities;

public enum Event {
    GET_USERS("users"), CHALLENGE("challenge"), YOUR_TURN("your_turn"), GAMEOVER("gameover");

    private final String string;

    Event(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
