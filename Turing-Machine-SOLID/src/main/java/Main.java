
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        String path = "running_ones.tmprog.txt";  // you can still hardcode this
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