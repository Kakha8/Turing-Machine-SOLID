Turing Machine (SOLID)

A turing machine simulator written in accordance with SOLID principles
Features

Input formats: .tmprog.txt and .tmprog.json

Clean design with classes for: Tape, Rule, RuleSet, TuringMachine

Pluggable loaders via ProgramLoader + ProgramLoaderFactory

Project Layout:

src/
 └─ main/
     ├─ java/com/example/tm/
     │   ├─ app/Main.java
     │   ├─ core/ (TuringMachine, Tape, Rule, RuleSet, TuringProgram)
     │   └─ io/   (ProgramLoader, TextProgramLoader, JsonProgramLoader, ProgramLoaderFactory)
     └─ resources/
         ├─ running_ones.tmprog.txt
         └─ running_ones.tmprog.json
