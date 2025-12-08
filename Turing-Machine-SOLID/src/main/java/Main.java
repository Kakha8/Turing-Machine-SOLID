
import java.io.*;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {

        String path = "running_ones.tmprog.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));

        String readLine = br.readLine();

        int headPosition = Integer.parseInt(readLine);

        // read tape
        readLine = br.readLine();
        char[] tape = new char[readLine.length()];;
        //String state = "0";
        for( int i=0; i < readLine.length(); i++) tape[i] = readLine.charAt(i);

        //read rules
        int ruleCount = 0;
        String[][] rules = new String[100][5];

        while ((readLine = br.readLine()) != null) {
            if( readLine.trim().isEmpty()) continue;

            String[] tokens = readLine.split(" ");
            for(int i = 0; i < 5; i++) {
                rules[ruleCount][i] = tokens[i];
            }
            ruleCount++;
        }

        br.close();

        // TM instance
        TuringMachine machine = new TuringMachine(tape, headPosition, rules, ruleCount);
        machine.run();
    }
}