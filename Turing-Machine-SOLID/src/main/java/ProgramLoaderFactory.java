import java.io.IOException;

public class ProgramLoaderFactory {

    public static ProgramLoader create(String path) throws IOException {
        //if(path.endsWith(".json")) expand later to add Json
        return new TextProgramLoader();
        
    }

}
