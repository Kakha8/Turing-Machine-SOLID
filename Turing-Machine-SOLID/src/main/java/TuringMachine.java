import java.util.List;

public class TuringMachine {

    private Tape tape;
    private int headPosition;
    private String state;
    private RuleSet ruleSet;
    public TuringMachine(Tape tape, int headPosition, RuleSet ruleSet) {

        this.tape = tape;
        this.headPosition = headPosition;
        this.ruleSet = ruleSet;
        this.state = "0"; // initial state
    }

    public void run() {
        int maxSteps = 100000;
        int steps = 0;

        while (steps < maxSteps) {
            steps++;

            char currentSymbol = tape.read(headPosition);

            // finding the rule
            Rule rule = ruleSet.findRule(state, currentSymbol);

            if (rule == null) {
                System.out.println("\nHALT (no rule matched for state " + state +
                        " and symbol '" + currentSymbol + "')");
                break;
            }

            // applying the rule
            tape.write(headPosition, rule.getWriteSymbol());

            if (rule.getDirection() == 'L') {
                headPosition--;
            } else {
                headPosition++;
            }

            state = rule.getNextState();

            tape.print();

            if (headPosition < 0 || headPosition >= tape.length()) {
                System.out.println("\nHALT (head moved off tape)");
                break;
            }
        }

        if (steps >= maxSteps) {
            System.out.println("\nHALT (max steps reached)");
        }
    }

}
