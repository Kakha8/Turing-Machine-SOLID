public class TuringMachine {

    private char[] tape;
    private int headPosition;
    private String state;
    private String[][] rules;
    private int ruleCount;

    public TuringMachine(char[] tape, int headPosition, String[][] rules, int ruleCount) {

        this.tape = tape;
        this.headPosition = headPosition;
        this.rules = rules;
        this.ruleCount = ruleCount;
        this.state = "0"; // initial state
    }

    public void run() {
        int maxSteps = 100000;
        int steps = 0;

        while (steps < maxSteps) {
            steps++;

            char currentSymbol = tape[headPosition];
            boolean ruleApplied = false;

            for (int i = 0; i < ruleCount; i++) {
                if (rules[i][0].equals(state) &&
                        rules[i][1].charAt(0) == currentSymbol) {

                    // apply rule
                    tape[headPosition] = rules[i][2].charAt(0);

                    if (rules[i][3].charAt(0) == 'L') {
                        headPosition--;
                    } else {
                        headPosition++;
                    }

                    state = rules[i][4];

                    printTape();
                    ruleApplied = true;
                    break;  // stop after one rule
                }
            }

            if (!ruleApplied) {
                System.out.println("\nHALT (no rule matched for state " + state +
                        " and symbol '" + currentSymbol + "')");
                break;
            }

            if (headPosition < 0 || headPosition >= tape.length) {
                System.out.println("\nHALT (head moved off tape)");
                break;
            }
        }

        if (steps >= maxSteps) {
            System.out.println("\nHALT (max steps reached, possible infinite loop)");
        }
    }

    private void printTape() {
        System.out.println();
        for (char c : tape) {
            System.out.print(c);
        }
    }
}
