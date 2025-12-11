public class TuringProgram {

    private final Tape tape;
    private final int headPosition;
    private final Rule ruleSet;

    public TuringProgram(Tape tape, int headPosition, Rule ruleSet) {
        this.tape = tape;
        this.headPosition = headPosition;
        this.ruleSet = ruleSet;
    }

    public Tape getTape() {
        return tape;
    }
    public int getHeadPosition() {
        return headPosition;
    }
    public Rule getRuleSet() {
        return ruleSet;
    }

}
