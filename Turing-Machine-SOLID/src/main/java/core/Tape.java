package core;

public class Tape {

    private char[] cells;

    public Tape(char[] cells) {
        this.cells = cells;
    }

    public char read(int position) {
        return cells[position];
    }

    public void write(int position, char value) {
        cells[position] = value;
    }

    public int length() {
        return cells.length;
    }

    public void print() {
        System.out.println();
        for (char c : cells) {
            System.out.print(c);
        }
    }

}
