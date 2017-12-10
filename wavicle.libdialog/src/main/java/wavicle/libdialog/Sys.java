/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Class Sys.
 */
public final class Sys {

    /** The processor. */
    private static DialogProcessor processor = new DialogProcessor(new SystemIODialogTransporter());

    /**
     * Instantiates a new cmd.
     */
    private Sys() {
        /** Do not instantiate! **/
    }

    /**
     * Input option.
     *
     * @param <T>
     *            the generic type
     * @param prompt
     *            the prompt
     * @param options
     *            the options
     * @return the t
     */
    public static <T> T inputOption(String prompt, List<T> options) {
        return processor.inputOption(prompt, options);
    }

    /**
     * Input option index.
     *
     * @param prompt
     *            the prompt
     * @param options
     *            the options
     * @return the int
     */
    public int inputOptionIndex(String prompt, List<?> options) {
        return processor.inputOptionIndex(prompt, options);
    }

    /**
     * Input number.
     *
     * @param prompt
     *            the prompt
     * @return the big decimal
     */
    public static BigDecimal inputNumber(String prompt) {
        return processor.inputNumber(prompt);
    }

    /**
     * Input number.
     *
     * @param prompt
     *            the prompt
     * @param validator
     *            the validator
     * @return the big decimal
     */
    public static BigDecimal inputNumber(String prompt, InputValidator<BigDecimal> validator) {
        return processor.inputNumber(prompt, validator);
    }

    /**
     * Input.
     *
     * @param prompt
     *            the prompt
     * @return the string
     */
    public static String input(String prompt) {
        return processor.input(prompt);
    }

    /**
     * Input.
     *
     * @param prompt
     *            the prompt
     * @param validator
     *            the validator
     * @return the string
     */
    public static String input(String prompt, InputValidator<String> validator) {
        return processor.input(prompt, validator);
    }

    /**
     * Input.
     *
     * @param <T>
     *            the generic type
     * @param prompt
     *            the prompt
     * @param parser
     *            the parser
     * @param validator
     *            the validator
     * @return the t
     */
    public static <T> T input(String prompt, InputParser<T> parser, InputValidator<T> validator) {
        return processor.input(prompt, parser, validator);
    }
}
