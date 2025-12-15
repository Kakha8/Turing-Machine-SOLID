package io;

import core.Rule;
import core.RuleSet;
import core.Tape;
import core.TuringProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextProgramLoader implements ProgramLoader {
    @Override
    public TuringProgram load(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));

        String readLine = br.readLine();

        int headPosition = Integer.parseInt(readLine);

        // read tape
        readLine = br.readLine();
        char[] tapeArray = readLine.toCharArray();
        Tape tape = new Tape(tapeArray);

        //read rules
        List<Rule> rules = new ArrayList<>();

        while ((readLine = br.readLine()) != null) {
            if (readLine.trim().isEmpty()) continue;

            String[] tokens = readLine.trim().split("\\s+");

            Rule r = new Rule(
                    tokens[0],        // current state
                    tokens[1].charAt(0), // read symbol
                    tokens[2].charAt(0), // write symbol
                    tokens[3].charAt(0), // direction L/R
                    tokens[4]         // next state
            );

            rules.add(r);
        }

        br.close();

        RuleSet ruleSet = new RuleSet(rules);

        return new TuringProgram(tape, headPosition, ruleSet);
    }
}
