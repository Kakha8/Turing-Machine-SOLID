package core;

public class TuringProgram {

    private final Tape tape;
    private final int headPosition;
    private final RuleSet ruleSet;

    public TuringProgram(Tape tape, int headPosition, RuleSet ruleSet) {
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
    public RuleSet getRuleSet() {
        return ruleSet;
    }

}
