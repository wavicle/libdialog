# libdialog

A Java library to quickly build command-line text-based applications. Features and usage are explained below.


## Read simple text

First, we need to import the DialogProcessor:

```java
import wavicle.libdialog.DialogProcessor;
```

Next, reading a line of text is as simple as:
```java
DialogProcessor processor = new DialogProcessor();
String lineOfText = processor.input("Enter some line of text");
System.out.println("You entered: " + lineOfText);
```

## Read a number (BigDecimal)

Numbers are read as `BigDecimal`'s:

```java
BigDecimal number = processor.inputNumber("What is your favorite number? ");
System.out.println("Your favorite number is: " + number);
```

The library provides basic validation on the input - if the number is not valid, 
the following error is shown and the user is asked for the input again:

```
Not a valid number: '***' - please retry: 
```

