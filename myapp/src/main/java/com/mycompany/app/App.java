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
    		boolean read = setDict("D:\\���\\��ҵ\\�����\\�����\\hw1\\myapp\\src"
    				                + "\\main\\java\\com\\mycompany\\app\\"+filename);//�����ֵ�
    		if (read)break;
    		System.out.println("Unable to open that file.  Try again.\n\n");
    	}
    	System.out.println( "Done!");
    }
    
    public static boolean setDict(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            //System.out.println("����Ϊ��λ��ȡ�ļ����ݣ�һ�ζ�һ���У�");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
            while ((tempString = reader.readLine()) != null ) {  
                // ��ʾ�к�  
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
