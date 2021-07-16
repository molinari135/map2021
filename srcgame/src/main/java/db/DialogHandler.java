package db;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ester
 */
public class DialogHandler {
    
    public static final int FIRST_DIALOG_START = 1;
    public static final int FIRST_DIALOG_END = 10;
    public static final int SECOND_DIALOG_START = 15;
    public static final int SECOND_DIALOG_END = 26;
    public static final int THIRD_DIALOG_START = 31;
    public static final int THIRD_DIALOG_END = 42;
    public static final int FORTH_DIALOG_START = 47;
    public static final int FORTH_DIALOG_END = 58;
    public static final int DIALOG_OPTION_START = 63;
    public static final int DIALOG_OPTION_END = 66;
    public static final int DIALOG_FINAL_START = 1;
    public static final int DIALOG_FINAL_END = 22;
    public static final int FINAL_START = 23;
    public static final int FINAL_END = 27;
    public static String dir = System.getProperty("user.dir");
    
    public List<String> SelectDialogOption(String namefile, int startLine, int endLine) throws FileNotFoundException, IOException {
        List<String> dialogList = new ArrayList<>(); 
        String str;
        int lineNumber = 0;
        boolean flag = false; // true if lines == 5
        InputStream i = getClass().getResourceAsStream("/" + namefile);
           
        BufferedReader bf = new BufferedReader(new InputStreamReader(i,"UTF-8"));
        

           while ((str = bf.readLine()) != null && !flag){           
            lineNumber++;  
            System.out.println(str);
            if (lineNumber >= startLine ) {
                System.out.println(lineNumber);
                dialogList.add(str);      
            }
            if (lineNumber == endLine) {
                flag = true;
            }            
        }
        
        return dialogList;
    }
            
}