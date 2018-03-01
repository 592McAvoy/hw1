package com.mycompany.app;

import java.util.*;
import java.io.*;

/**
 * Hello world!
 *
 */
public class App 
{
	public static Set<String> dict = new HashSet<String>();//�ֵ�
	public static Set<String> record = new HashSet<String>();//��¼�滻����µ��ʣ������������ѭ��
	public static Stack<String> result = new Stack<String>();;	//WordLadder�Ľ��
	public static Queue<Stack<String>> ladder = new LinkedList<Stack<String>>();;//���ڴ洢ladder�Ķ���
	
	
    public static void main( String[] args )
    {
    	String filename;	
    	Scanner in= new Scanner(System.in);
    	while (true) {
    		System.out.println( "Dictionary file name?");
    		filename = in.nextLine();
    		boolean read = setDict("D:\\���\\��ҵ\\�����\\�����\\hw1\\myapp\\src"
    				                + "\\main\\java\\com\\mycompany\\app\\"+filename);//�����ֵ�
    		if (read) {
    			System.out.println(dict);
    			break;
    			}
    		System.out.println("Unable to open that file.  Try again.\n\n");
    	}
    	
    	String word1;//�յ㵥��
    	String word2;//��㵥��
    	
    	//���û����õ������յ�ĵ���
    	while (true) {
    		
    			System.out.println("Word #1 (or Enter to quit): ");
    			word1 = in.nextLine().toLowerCase();
    			if (word1.equals(""))break;
    			
    			System.out.println( "Word #2 (or Enter to quit): ");
    			word2 = in.nextLine().toLowerCase();
    			//�Ų鲻�淶����
    			if (word2.equals(""))break;
    			if (word1.equals(word2)) {
    				System.out.println("The two words must be different.");
    				continue;
    			}
    			//��ʼ��ladder����
    			Stack<String> ss = new Stack<String>();
    			ss.push(word1);
    			ladder.offer(ss);

    			//������ҽ��
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
            // һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
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
