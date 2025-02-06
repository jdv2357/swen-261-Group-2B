public class Util {

    /**
     * Clears console screen and returns cursor to top left
     * */
    public static void clearConsole(){
        System.out.print("\033[H\033[2J");
    }

    /**
     * Returns escape sequence to clear a file or console
     * */
    public static String getClearEscapeSeq(){
        return "\033[H\033[2J";
    }

    /**
     * Puts current thread to sleep for 'ms' milliseconds
     * @param ms
     * */
    public static void pauseThread(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e){
            System.out.println("Interruption in Util.pauseThread()");
        }
    }

    /**
     * Prints 'text' to console one character at a time with a 'ms' pause between characters
     * Does not print newline character at the end of string
     * @param ms
     * @param text
     * */
    public static void bufferText(String text, int ms){
        for(char ch : text.toCharArray()){
            pauseThread(ms);
            System.out.print(ch);
        }
    }


    //Main method just for testing utility methods
    public static void main(String[] args){

        clearConsole();
        bufferText("The main method in the class Util exists only to test the methods within it\na b c d e f g\n1 2 3 4 5 6 7", 75);
        pauseThread(1000);
        clearConsole();

    }

}

