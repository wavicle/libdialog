/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

import java.util.Arrays;

import wavicle.libdialog.DialogProcessor;

import static java.lang.System.out;

/**
 * The Class SysDemo.
 */
public class SysDemo {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        out.println("Your name is: " + Sys.input("What is your name (try an empty string)? ", DialogProcessor.NOT_EMPTY_STRING_VALIDATOR));

        out.println("The number you entered is: " + Sys.inputNumber("Please enter a number (try 'abc'): "));

        out.println("The season you selected is: "
                + Sys.inputOption("What is your favorite season? ", Arrays.asList("Spring", "Fall", "Autumn", "Winter")));
    }
}
