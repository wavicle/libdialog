/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

// TODO: Auto-generated Javadoc
/**
 * A helper class for the libdialog library. Contains validations and other
 * useful functions.
 */
public final class Libdialog {

    /**
     * Instantiates a new libdialog constants.
     */
    private Libdialog() {
        /** Do not instantiate! **/
    }

    /**
     * The Class Validators.
     */
    public static final class Validators {

        /**
         * Instantiates a new validators.
         */
        private Validators() {
            /** Do not instantiate! **/
        }

        /** The Constant NOT_EMPTY_STRING_VALIDATOR. */
        public static final InputValidator<String> NOT_EMPTY_STRING = str -> str != null && !str.trim().isEmpty();

        /**
         * Returns string a validator that requires the input string to match the regex.
         *
         * @param regex
         *            the regex
         * @param errorMessage
         *            the error message
         * @return the input validator
         */
        public static InputValidator<String> mustMatch(String regex, String errorMessage) {
            return new InputValidator<String>() {

                @Override
                public boolean isValid(String input) {
                    return input != null && input.matches(regex);
                }

                @Override
                public String buildErrorMessage(String input) {
                    return errorMessage;
                }
            };
        }
    }

}
