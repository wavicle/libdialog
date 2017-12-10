package wavicle.libdialog;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class DialogProcessor {
	private Scanner scanner = new Scanner(System.in);

	private static final InputValidator<String> NOOP_STRING_VALIDATOR = anyString -> true;

	public static final InputValidator<String> NOT_EMPTY_STRING_VALIDATOR = theString -> theString != null
			&& !theString.isEmpty();

	public static final InputParser<String> NOOP_PARSER = string -> string;

	private static final InputParser<BigDecimal> BIG_DECIMAL_PARSER = string -> {
		try {
			BigDecimal number = new BigDecimal(string);
			return number;
		} catch (NumberFormatException e) {
			throw new InputParseException("Not a valid number: '" + string + "' - please retry: ");
		}
	};

	public <T> T inputOption(String prompt, List<T> options) {
		int optionIndex = inputOptionIndex(prompt, options);
		T optionValue = options.get(optionIndex);
		return optionValue;
	}

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
		InputValidator<BigDecimal> validator = num -> num.compareTo(BigDecimal.ONE) >= 0
				&& num.compareTo(maxIndex) <= 0;
		BigDecimal inputBigDecimal = inputNumber(fullPrompt, validator);
		return inputBigDecimal.intValue() - 1;
	}

	public BigDecimal inputNumber(String prompt) {
		return inputNumber(prompt, num -> true);
	}

	public BigDecimal inputNumber(String prompt, InputValidator<BigDecimal> validator) {
		return input(prompt, BIG_DECIMAL_PARSER, validator);
	}

	public String input(String prompt) {
		return input(prompt, NOOP_PARSER, NOOP_STRING_VALIDATOR);
	}

	public String input(String prompt, InputValidator<String> validator) {
		return input(prompt, NOOP_PARSER, validator);
	}

	public <T> T input(String prompt, InputParser<T> parser, InputValidator<T> validator) {
		System.out.print(prompt);
		while (true) {
			String originalValue = scanner.nextLine();
			T valueFromParsing;
			try {
				valueFromParsing = parser.parse(originalValue);
				if (validator.isValid(valueFromParsing)) {
					return valueFromParsing;
				} else {
					System.out.print(validator.buildErrorMessage(valueFromParsing));
				}
			} catch (InputParseException e) {
				System.out.print(e.getMessage());
			}
		}
	}

}
