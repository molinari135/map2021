package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ester
 */
public class DialogHandler {
    
    public static final int FIRST_DIALOG_START = 1;
    public static final int FIRST_DIALOG_END = 5;
    public static final int SECOND_DIALOG_START = 10;
    public static final int SECOND_DIALOG_END = 15;
    public static final int THIRD_DIALOG_START = 20;
    public static final int THIRD_DIALOG_END = 25;
    public static final int FORTH_DIALOG_START = 30;
    public static final int FORTH_DIALOG_END = 35;
    public static final int DIALOG_OPTION_START = 40;
    public static final int DIALOG_OPTION_END = 43;
    public static String dir = System.getProperty("user.dir");
    
    public static List<String> SelectDialogOption(File file, int startLine, int endLine) throws FileNotFoundException {
        List<String> dialogList = new ArrayList<String>(); 
        Scanner sc = new Scanner(file);
        int lineNumber = 0;
        boolean flag = false; // true if lines == 5
        while (sc.hasNextLine() && !flag) {
            lineNumber++;
            String line = sc.nextLine();
            if (lineNumber >= startLine ) {
                System.out.println(lineNumber);
                dialogList.add(line);      
            }
            if (lineNumber == endLine) {
                flag = true;
            }            
        }
        sc.close();
        return dialogList;
    }

    public static List<String> Epilogue(File file) {
        List<String> epilogue = new ArrayList<String>();
        return epilogue;
    }
}