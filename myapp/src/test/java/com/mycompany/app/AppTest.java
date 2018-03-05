package com.mycompany.app;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import junit.framework.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }
    
    static App app = null;
    
    /**
     * Rigourous Test :-)
     */
    protected void setUp() throws Exception{
    	app = new App();
    } 
    
    public void testSetDict() {
    	assertTrue(app.setDict("D:\\罗宇辰\\作业\\大二下\\软工后端\\hw1\\myapp\\src"
                + "\\main\\java\\com\\mycompany\\app\\dictionary.txt"));
    	assertFalse(app.setDict("dictionary.txt"));
    }
    
    public void testFind() {
    	app.setDict("D:\\罗宇辰\\作业\\大二下\\软工后端\\hw1\\myapp\\src"
                + "\\main\\java\\com\\mycompany\\app\\smalldict1.txt");
    	String word1 = "cat";
    	Stack<String> ss = new Stack<String>();
		ss.push(word1);
		app.ladder.offer(ss);
		app.record.add(word1);
		assertTrue(app.findLadder("dog"));
		app.ladder = new LinkedList<Stack<String>>();
		app.record = new HashSet<String>();
		assertFalse(app.findLadder("beauty"));
    }

}
