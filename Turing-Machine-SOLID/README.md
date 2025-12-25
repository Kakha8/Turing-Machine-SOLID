Turing Machine (SOLID)

A turing machine simulator written in accordance with SOLID principles
Features

Input formats: .tmprog.txt and .tmprog.json

Clean design with classes for: Tape, Rule, RuleSet, TuringMachine

Pluggable loaders via ProgramLoader + ProgramLoaderFactory

## Project Layout

```text
src/
└── main/
    └── java/com/example/tm/
        ├── app/
        │   └── Main.java
        ├── core/
        │   ├── TuringMachine.java
        │   ├── Tape.java
        │   ├── Rule.java
        │   ├── RuleSet.java
        │   └── TuringProgram.java
        ├── io/
        │   ├── ProgramLoader.java
        │   ├── ProgramLoaderFactory.java
        │   ├── TextProgramLoader.java
        │   └── JsonProgramLoader.java
└── resources/
    ├── running_ones.tmprog.txt
    └── running_ones.tmprog.json
```
