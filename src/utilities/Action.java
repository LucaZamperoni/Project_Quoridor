package utilities;

public enum Action {
    ACCEPT_CHALLENGE("accept_challenge"), MOVE("move"), WALL("wall");

    private final String string;

    Action(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
