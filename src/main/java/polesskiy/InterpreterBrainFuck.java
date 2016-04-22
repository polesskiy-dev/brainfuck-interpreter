package polesskiy;

public class InterpreterBrainFuck {

    /**
     * RAM
     */
    private byte[] ram = new byte[Character.MAX_VALUE];

    /**
     * RAM pointer
     */
    private int ramPointer = 0;

    /**
     * Pointer to program listing
     */
    private int programPointer = 0;

    /** Main*/
    public static void main(String args[]) {
        //simple validation
        if (args.length!=0 && !args[0].isEmpty()) {
            //compile
            new InterpreterBrainFuck().compileProgram(args[0]);
        } else System.err.println("Invalid program string!");
    }

    /**
     * Compile program string
     *
     * @param str string to compile
     */
    public void compileProgram(String str) {
        for (; programPointer < str.length(); programPointer++)
            compileCommand(str.charAt(programPointer), str.toCharArray());
    }

    /**
     * Compile single command
     *
     * @param command command to perform
     * @param program
     */
    private void compileCommand(char command, char[] program) {
        switch (command) {
            case '>':
                ramPointer++;
                break;
            case '<':
                ramPointer--;
                break;
            case '+':
                ram[ramPointer]++;
                break;
            case '-':
                ram[ramPointer]--;
                break;
            case '.':
                System.out.print((char) ram[ramPointer]);
                break;
            case '[':
                if (ram[ramPointer] == 0) {
                    int i = 1;
                    while (i > 0) {
                        switch (program[++programPointer]) {
                            case '[':
                                i++;
                                break;
                            case ']':
                                i--;
                                break;
                        }
                    }
                }
                break;
            case ']':
                int i = 1;
                while (i > 0) {
                    switch (program[--programPointer]) {
                        case '[':
                            i--;
                            break;
                        case ']':
                            i++;
                            break;
                    }
                }
                programPointer--;
                break;
        }
    }
}
