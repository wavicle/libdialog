/**
 * @author Shashank Araokar
 */
package wavicle.libdialog;

import java.util.Scanner;

/**
 * The Class SystemIODialogTransporter.
 */
public class SystemIODialogTransporter implements DialogTransporter {

    /** The scanner. */
    private Scanner scanner = new Scanner(System.in);

    /*
     * (non-Javadoc)
     * 
     * @see wavicle.libdialog.DialogTransporter#readNext()
     */
    @Override
    public String readNext() {
        String line = scanner.nextLine();
        return line;
    }

    /*
     * (non-Javadoc)
     * 
     * @see wavicle.libdialog.DialogTransporter#write(java.lang.String)
     */
    @Override
    public void write(String output) {
        System.out.print(output);
    }

}
