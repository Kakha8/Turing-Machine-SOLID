import java.util.List;

public class RuleSet {

    private final List<Rule> rules;

    public RuleSet(List<Rule> rules) {
        this.rules = rules;
    }

    // finding first rule that matches the state and tape symbol
    public Rule findRule(String currentState, char currentSymbol) {
        for (Rule r : rules) {
            if (r.getCurrentState().equals(currentState) &&
                    r.getReadSymbol() == currentSymbol) {
                return r;
            }
        }
        return null;
    }

    public List<Rule> getRules() {
        return rules;
    }

}
