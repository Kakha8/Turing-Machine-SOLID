package app;

import core.TuringMachine;
import core.TuringProgram;
import io.ProgramLoader;
import io.ProgramLoaderFactory;

import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        //String path = "src/main/resources/running_ones.tmprog.txt";
        String path = "src/main/resources/running_ones.tmprog.json";
        System.out.println("Loading program from: " + path);

        ProgramLoader loader = ProgramLoaderFactory.create(path);
        TuringProgram program = loader.load(path);

        // Building TM from program instance
        TuringMachine machine = new TuringMachine(
                program.getTape(),
                program.getHeadPosition(),
                program.getRuleSet()
        );

        machine.run();

    }
}