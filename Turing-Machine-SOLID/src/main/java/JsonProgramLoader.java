import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonProgramLoader implements ProgramLoader {


    private final Gson gson = new Gson();

    @Override
    public TuringProgram load(String path) throws IOException {

        Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
        Map<String, Object> root = gson.fromJson(new FileReader(path), mapType);

        int headPosition = Integer.parseInt((String) root.get("head-start-position"));
        String tapeStr = (String) root.get("tape");
        Tape tape = new Tape(tapeStr.toCharArray());

        List<Map<String, String>> rulesJson =
                (List<Map<String, String>>) root.get("rules");

        List<Rule> rules = new ArrayList<>();
        for (Map<String, String> r : rulesJson) {
            rules.add(new Rule(
                    r.get("state"),
                    r.get("read").charAt(0),
                    r.get("write").charAt(0),
                    r.get("move").charAt(0),
                    r.get("next-state")
            ));
        }

        return new TuringProgram(tape, headPosition, new RuleSet(rules));
    }
}
