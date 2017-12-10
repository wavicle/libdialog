/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

/**
 * The Class InputParseException.
 */
@SuppressWarnings("serial")
public class InputParseException extends Exception {

    /**
     * Instantiates a new input parse exception.
     */
    public InputParseException() {
        /** Default constructor **/
    }

    /**
     * Instantiates a new input parse exception.
     *
     * @param arg0
     *            the arg 0
     */
    public InputParseException(String arg0) {
        super(arg0);
    }

    /**
     * Instantiates a new input parse exception.
     *
     * @param arg0
     *            the arg 0
     */
    public InputParseException(Throwable arg0) {
        super(arg0);
    }

    /**
     * Instantiates a new input parse exception.
     *
     * @param arg0
     *            the arg 0
     * @param arg1
     *            the arg 1
     */
    public InputParseException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    /**
     * Instantiates a new input parse exception.
     *
     * @param arg0
     *            the arg 0
     * @param arg1
     *            the arg 1
     * @param arg2
     *            the arg 2
     * @param arg3
     *            the arg 3
     */
    public InputParseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3);
    }

}
