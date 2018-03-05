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
	public static Stack<String> result = new Stack<String>();	//WordLadder的结果
	public static Queue<Stack<String>> ladder = new LinkedList<Stack<String>>();//用于存储ladder的队列
	
	
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
    			//System.out.println(dict);
    			break;
    			}
    		System.out.println("Unable to open that file.  Try again.\n");
    	}
    	
    	String word1;//起点单词
    	String word2;//终点单词
    	
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
    			record.add(word1);

    			//处理查找结果
    			boolean find = findLadder(word2);
    			ladder = new LinkedList<Stack<String>>();
    			record = new HashSet<String>();
    			if (find) {
    				System.out.println( "A ladder from " + word2 + " back to " + word1 + " :");
    				while (!result.empty()) 
    					System.out.print( result.pop() + " ");    					
    				System.out.println("\n");
    			}
    			else
    				System.out.println( "No word ladder found from " + word2 + " back to " + word1 + " .\n"); 				 		
    	}
    	System.out.println( "Have a nice day!");
    }
    
    public static boolean findLadder(String word2) {
    	//System.out.println("ladder size "+ladder.size());
    	while (ladder.size()>0) {
    		int size = ladder.size();
    		for (int i = 0; i < size; i++) {
    			Stack<String> temp = ladder.poll();
    			String word = temp.peek();
    			
    			String ww1 = "";
				String ww2 = "";
				String ww3 = "";
    			
    			//对这个单词分别进行三种变化：增、删、改
    			int len = word.length();
    			for (int j = 0; j <= len; j++){
    				if(j!=len)
    					ww3 = word.substring(0, j) + word.substring(j+1);;//删除字母
    					boolean cc = check(ww3, word2, temp);
    				for (char ch = 'a'; ch <= 'z'; ch++){    					
    					ww2 = word.substring(0, j) + ch + word.substring(j);//添加字母
    					if(j!=len)
    						ww1 = word.substring(0, j) + ch + word.substring(j+1);	//改变字母					  								
    
    					if(	check(ww1, word2, temp)||
    						check(ww2, word2, temp)||
    						cc)
    						return true;
    					}
    				}
    			}
    		}
    	System.out.println("false!");
    	return false;
    }
    
    public static boolean check(String word, String target, Stack<String> temp) {
    	//System.out.println(word + "  " +target);
    	if(record.contains(word))
    		return false;
    	if (word.equals(target)) {
    		result = (Stack<String>)temp.clone();
    		result.push(word);
    		//ladder = queue<stack<string>>();//重置
    		return true;
    	}
    	else if (dict.contains(word)) //新单词是没出现过的有效单词	
    								  //将这部分wordladder添加到ladder队列中
    		{
    			record.add(word);
    			Stack<String> save = (Stack<String>)temp.clone();
    			save.push(word);
    			ladder.offer(save);
    		}
    	return false;
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
