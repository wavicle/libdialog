package wavicle.utils.mostfreq.cmd;

@SuppressWarnings("serial")
public class InputParseException extends Exception {

	public InputParseException() {
		/** Default constructor **/
	}

	public InputParseException(String arg0) {
		super(arg0);
	}

	public InputParseException(Throwable arg0) {
		super(arg0);
	}

	public InputParseException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InputParseException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
