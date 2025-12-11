import java.util.List;

public class TuringMachine {

    private Tape tape;
    private int headPosition;
    private String state;
    private List<Rule> rules;

    public TuringMachine(Tape tape, int headPosition, List<Rule> rules) {

        this.tape = tape;
        this.headPosition = headPosition;
        this.rules = rules;
        this.state = "0"; // initial state
    }

    public void run() {
        int maxSteps = 100000;
        int steps = 0;

        while (steps < maxSteps) {
            steps++;

            char currentSymbol = tape.read(headPosition);
            boolean ruleApplied = false;

            for (Rule r : rules) {

                if (r.getCurrentState().equals(state) &&
                        r.getReadSymbol() == currentSymbol) {

                    // apply rule
                    tape.write(headPosition, r.getWriteSymbol());

                    if (r.getDirection() == 'L') {
                        headPosition--;
                    } else {
                        headPosition++;
                    }

                    state = r.getNextState();

                    tape.print();
                    ruleApplied = true;
                    break;
                }
            }

            if (!ruleApplied) {
                System.out.println("\nHALT (no rule matched for state " + state +
                        " and symbol '" + currentSymbol + "')");
                break;
            }

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
