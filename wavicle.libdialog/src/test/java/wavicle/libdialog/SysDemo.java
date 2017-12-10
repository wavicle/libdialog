/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

import java.math.BigDecimal;

/**
 * Demonstrates how command-line applications are built using the {@link Sys}
 * class in the libdialog library.
 */
public class SysDemo {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        /** We will use these variables throughout this demo **/
        String line;
        BigDecimal number;

        /** Let's input a string from the command line **/
        line = Sys.input("Please enter any text (press return at the end): ");
        System.out.println("You entered: " + line);

        /**
         * Note that we did not add any validations. So try entering nothing this time.
         * It still works
         **/
        line = Sys.input("Just hit enter this time (empty text): ");
        System.out.println("You entered: " + line);

        /**
         * Let's add some validation. We won't allow an emptry string (0-length or just
         * white spaces). This is done by passing an instance of the InputValidator
         * interface. Below, we are passing a specific implementation of that interface.
         **/
        line = Sys.input("Enter an empty string and I will prompt you again: ", DialogProcessor.NOT_EMPTY_STRING_VALIDATOR);
        System.out.println("You entered the following non-empty string: " + line);

        /**
         * What if you wanted to input a number? We can read a BigDecimal directly. The
         * expression has to be a valid number else it won't work.
         **/
        number = Sys.inputNumber("Enter a number (if you enter an invalid string like '12.34abc' I won't accept it: ");
        System.out.println("The valid number you entered is: " + number);

        /**
         * Like with plain strings, you can add validations to numbers too. Note that we
         * are also overriding the buildErrorMessage method in this case to provide a
         * custom validation error message.
         * 
         * In the validator below, we validate that the number is from 1 to 10.
         **/
        InputValidator<BigDecimal> numberValidator = new InputValidator<BigDecimal>() {

            @Override
            public boolean isValid(BigDecimal input) {
                /** Greater than or equal to 1, less than or equal to 10 **/
                return input.compareTo(BigDecimal.ONE) >= 0 && input.compareTo(BigDecimal.TEN) <= 0;
            }

            /** This method is overridden to provide a custom message **/
            @Override
            public String buildErrorMessage(BigDecimal input) {
                return "The number " + input + " is not in the range 1 to 10! Please try again: ";
            }
        };
        number = Sys.inputNumber("Please enter a number (try entering a negative number to see the validation): ", numberValidator);
        System.out.println("The number you entered is: " + number);

    }
}
