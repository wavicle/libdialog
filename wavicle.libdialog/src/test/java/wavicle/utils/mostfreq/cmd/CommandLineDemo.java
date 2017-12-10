package wavicle.utils.mostfreq.cmd;

import java.util.Arrays;

import static java.lang.System.out;

import wavicle.utils.mostfreq.cmd.DialogProcessor;

public class CommandLineDemo {

	public static void main(String[] args) {
		DialogProcessor processor = new DialogProcessor();

		out.println("Your name is: " + processor.input("What is your name (try an empty string)? ",
				DialogProcessor.NOT_EMPTY_STRING_VALIDATOR));

		out.println("The number you entered is: " + processor.inputNumber("Please enter a number (try 'abc'): "));

		out.println("The season you selected is: " + processor.inputOption("What is your favorite season? ",
				Arrays.asList("Spring", "Fall", "Autumn", "Winter")));
	}
}