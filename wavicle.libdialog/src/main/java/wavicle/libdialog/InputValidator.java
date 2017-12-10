/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

/**
 * The Interface InputValidator.
 *
 * @param <T>
 *            the generic type
 */
public interface InputValidator<T> {

    /**
     * Checks if is valid.
     *
     * @param input
     *            the input
     * @return true, if is valid
     */
    boolean isValid(T input);

    /**
     * Builds the error message.
     *
     * @param input
     *            the input
     * @return the string
     */
    default String buildErrorMessage(T input) {
        return "Invalid input: '" + input + "' - please retry: ";
    }
}
