/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

/**
 * The Interface InputParser.
 *
 * @param <T>
 *            the generic type
 */
public interface InputParser<T> {

    /**
     * Parses the string into a value of the generic type.
     *
     * @param string
     *            the string
     * @return the t
     * @throws InputParseException
     *             the input parse exception
     */
    T parse(String string) throws InputParseException;
}
