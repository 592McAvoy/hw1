package com.mycompany.app;

import java.util.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String filename;	
    	Scanner in= new Scanner(System.in);
    	while (true) {
    		System.out.println( "Dictionary file name?");
    		filename = in.nextLine();
    		boolean read = setDict("D:\\罗宇辰\\作业\\大二下\\软工后端\\hw1\\myapp\\src"
    				                + "\\main\\java\\com\\mycompany\\app\\"+filename);//设置字典
    		if (read)break;
    		System.out.println("Unable to open that file.  Try again.\n\n");
    	}
    	System.out.println( "Done!");
    }
    
    public static boolean setDict(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            //System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null ) {  
                // 显示行号  
                System.out.println("line " + line + ": " + tempString);  
                line++;  
            }  
            reader.close();  
            return true;
        } catch (IOException e) {  
            //e.printStackTrace();  
            return false;
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
    }  
}
