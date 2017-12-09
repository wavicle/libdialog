package wavicle.utils.mostfreq.cmd;

public interface InputParser<T> {
	T parse(String string) throws InputParseException;
}
