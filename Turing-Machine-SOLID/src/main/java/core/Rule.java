package core;

public class Rule {
    private final String currentState;
    private final char readSymbol;
    private final char writeSymbol;
    private final char direction;   // 'L' or 'R'
    private final String nextState;

    public Rule(String currentState, char readSymbol, char writeSymbol, char direction, String nextState) {
        this.currentState = currentState;
        this.readSymbol = readSymbol;
        this.writeSymbol = writeSymbol;
        this.direction = direction;
        this.nextState = nextState;
    }

    public String getCurrentState() {
        return currentState;
    }

    public char getReadSymbol() {
        return readSymbol;
    }

    public char getWriteSymbol() {
        return writeSymbol;
    }

    public char getDirection() {
        return direction;
    }

    public String getNextState() {
        return nextState;
    }

}
