package com.mycompany.app;

import java.util.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Set<String> dict = new HashSet<String>();//字典
	public static Set<String> record = new HashSet<String>();//记录替换后的新单词，避免出现无限循环
	public static Stack<String> result = new Stack<String>();;	//WordLadder的结果
	public static Queue<Stack<String>> ladder = new LinkedList<Stack<String>>();;//用于存储ladder的队列
	
	
    public static void main( String[] args )
    {
    	String filename;	
    	Scanner in= new Scanner(System.in);
    	while (true) {
    		System.out.println( "Dictionary file name?");
    		filename = in.nextLine();
    		boolean read = setDict("D:\\罗宇辰\\作业\\大二下\\软工后端\\hw1\\myapp\\src"
    				                + "\\main\\java\\com\\mycompany\\app\\"+filename);//设置字典
    		if (read) {
    			System.out.println(dict);
    			break;
    			}
    		System.out.println("Unable to open that file.  Try again.\n\n");
    	}
    	
    	String word1;//终点单词
    	String word2;//起点单词
    	
    	//从用户处得到起点和终点的单词
    	while (true) {
    		
    			System.out.println("Word #1 (or Enter to quit): ");
    			word1 = in.nextLine().toLowerCase();
    			if (word1.equals(""))break;
    			
    			System.out.println( "Word #2 (or Enter to quit): ");
    			word2 = in.nextLine().toLowerCase();
    			//排查不规范输入
    			if (word2.equals(""))break;
    			if (word1.equals(word2)) {
    				System.out.println("The two words must be different.");
    				continue;
    			}
    			//初始化ladder队列
    			Stack<String> ss = new Stack<String>();
    			ss.push(word1);
    			ladder.offer(ss);

    			//处理查找结果
    			/*boolean _result = find_ladder(word2);
    			if (_result) {
    				System.out.println( "A ladder from " + word2 + " back to " + word1 + " :\n");
    				while (!result.empty()) {
    					System.out.println( result.top() + " ");
    					result.pop();
    				}
    				System.out.println("\n\n");
    			}
    			else
    				System.out.println( "No word ladder found from " + word2 + " back to " + word1 + " .\n\n");
    				*/
    		
    		
    	}
    	System.out.println( "Have a nice day!");
    }
    
    public static boolean setDict(String fileName) {  
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {   
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;   
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null ) {    
            	dict.add(tempString);                 
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
