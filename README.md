# libdialog

An library to quickly build command-line text-based applications. Features and usage are explained below.


## Read simple text from the command line

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

Validations can be added using the `InputValidator` interface:


