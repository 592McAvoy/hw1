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
	public static Stack<String> result = new Stack<String>();	//WordLadder�Ľ��
	public static Queue<Stack<String>> ladder = new LinkedList<Stack<String>>();//���ڴ洢ladder�Ķ���
	
	
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
    			//System.out.println(dict);
    			break;
    			}
    		System.out.println("Unable to open that file.  Try again.\n");
    	}
    	
    	String word1;//��㵥��
    	String word2;//�յ㵥��
    	
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
    			record.add(word1);

    			//������ҽ��
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
    			
    			//��������ʷֱ�������ֱ仯������ɾ����
    			int len = word.length();
    			for (int j = 0; j <= len; j++){
    				if(j!=len)
    					ww3 = word.substring(0, j) + word.substring(j+1);;//ɾ����ĸ
    					boolean cc = check(ww3, word2, temp);
    				for (char ch = 'a'; ch <= 'z'; ch++){    					
    					ww2 = word.substring(0, j) + ch + word.substring(j);//�����ĸ
    					if(j!=len)
    						ww1 = word.substring(0, j) + ch + word.substring(j+1);	//�ı���ĸ					  								
    
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
    		//ladder = queue<stack<string>>();//����
    		return true;
    	}
    	else if (dict.contains(word)) //�µ�����û���ֹ�����Ч����	
    								  //���ⲿ��wordladder��ӵ�ladder������
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
