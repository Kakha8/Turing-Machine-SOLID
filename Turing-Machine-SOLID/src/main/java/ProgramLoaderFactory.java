import java.io.IOException;

public class ProgramLoaderFactory {

    public static ProgramLoader create(String path) throws IOException {
        if(path.endsWith(".json")){
            return new JsonProgramLoader();
        }
        return new TextProgramLoader();

    }

}
