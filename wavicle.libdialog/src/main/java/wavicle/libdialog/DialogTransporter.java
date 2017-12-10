package wavicle.libdialog;

public interface DialogTransporter {

    String readNext();

    void write(String output);
}
