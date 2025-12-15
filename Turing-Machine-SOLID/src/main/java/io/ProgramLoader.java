package io;

import core.TuringProgram;

import java.io.IOException;

public interface ProgramLoader {
    TuringProgram load(String path) throws IOException;
}
