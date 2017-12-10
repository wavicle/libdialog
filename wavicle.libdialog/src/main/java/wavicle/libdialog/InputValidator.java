package wavicle.libdialog;

public interface InputValidator<T> {
	boolean isValid(T input);

	default String buildErrorMessage(T input) {
		return "Invalid input: '" + input + "' - please retry: ";
	}
}
