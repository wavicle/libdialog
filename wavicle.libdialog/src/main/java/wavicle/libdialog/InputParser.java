package wavicle.libdialog;

public interface InputParser<T> {
	T parse(String string) throws InputParseException;
}
