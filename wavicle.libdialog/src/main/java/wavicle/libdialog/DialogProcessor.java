/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

import java.math.BigDecimal;
import java.util.List;

/**
 * The Class DialogProcessor.
 */
public class DialogProcessor {

    /** The transporter. */
    private DialogTransporter transporter;

    /** The Constant NOOP_STRING_VALIDATOR. */
    private static final InputValidator<String> NOOP_STRING_VALIDATOR = anyString -> true;

    /** The Constant NOT_EMPTY_STRING_VALIDATOR. */
    public static final InputValidator<String> NOT_EMPTY_STRING_VALIDATOR = theString -> theString != null && !theString.isEmpty();

    /** The Constant NOOP_PARSER. */
    public static final InputParser<String> NOOP_PARSER = string -> string;

    /** The Constant BIG_DECIMAL_PARSER. */
    private static final InputParser<BigDecimal> BIG_DECIMAL_PARSER = string -> {
        try {
            BigDecimal number = new BigDecimal(string);
            return number;
        } catch (NumberFormatException e) {
            throw new InputParseException("Not a valid number: '" + string + "' - please retry: ");
        }
    };

    /**
     * Instantiates a new dialog processor.
     *
     * @param transporter
     *            the transporter
     */
    public DialogProcessor(DialogTransporter transporter) {
        super();
        this.transporter = transporter;
    }

    /**
     * Displays the prompt followed by a numbered list of the passed options. The
     * user is allowed to select an option by entering its index (starting with 1).
     * Basic validation on the index is provided: the index must be from 1 to
     * options.size()
     * 
     * @see DialogProcessor#inputOptionIndex(String, List) for a similar function
     *      that returns the entered option index, instead of the value
     *
     * @param <T>
     *            the generic type
     * @param prompt
     *            the prompt
     * @param options
     *            the options
     * @return the t
     */
    public <T> T inputOption(String prompt, List<T> options) {
        int optionIndex = inputOptionIndex(prompt, options);
        T optionValue = options.get(optionIndex);
        return optionValue;
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
        StringBuilder sb = new StringBuilder();
        sb.append(prompt);
        sb.append("\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((i + 1) + ": " + options.get(i));
            sb.append("\n");
        }
        sb.append("Enter a number from 1 to " + options.size() + ": ");
        String fullPrompt = sb.toString();
        BigDecimal maxIndex = new BigDecimal(options.size());
        InputValidator<BigDecimal> validator = num -> num.compareTo(BigDecimal.ONE) >= 0 && num.compareTo(maxIndex) <= 0;
        BigDecimal inputBigDecimal = inputNumber(fullPrompt, validator);
        return inputBigDecimal.intValue() - 1;
    }

    /**
     * Input number.
     *
     * @param prompt
     *            the prompt
     * @return the big decimal
     */
    public BigDecimal inputNumber(String prompt) {
        return inputNumber(prompt, num -> true);
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
    public BigDecimal inputNumber(String prompt, InputValidator<BigDecimal> validator) {
        return input(prompt, BIG_DECIMAL_PARSER, validator);
    }

    /**
     * Input.
     *
     * @param prompt
     *            the prompt
     * @return the string
     */
    public String input(String prompt) {
        return input(prompt, NOOP_PARSER, NOOP_STRING_VALIDATOR);
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
    public String input(String prompt, InputValidator<String> validator) {
        return input(prompt, NOOP_PARSER, validator);
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
    public <T> T input(String prompt, InputParser<T> parser, InputValidator<T> validator) {
        transporter.write(prompt);
        while (true) {
            String originalValue = transporter.readNext();
            T valueFromParsing;
            try {
                valueFromParsing = parser.parse(originalValue);
                if (validator.isValid(valueFromParsing)) {
                    return valueFromParsing;
                } else {
                    transporter.write(validator.buildErrorMessage(valueFromParsing));
                }
            } catch (InputParseException e) {
                transporter.write(e.getMessage());
            }
        }
    }

}
