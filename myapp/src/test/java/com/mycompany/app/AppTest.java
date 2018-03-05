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
    
    static App app = new App();
    
    /**
     * Rigourous Test :-)
     */
       
    
    public void testSetDict() {
    	assertTrue(app.setDict("D:\\罗宇辰\\作业\\大二下\\软工后端\\hw1\\myapp\\src"
                + "\\main\\java\\com\\mycompany\\app\\dictionary.txt"));
    	assertFalse(app.setDict("dictionary.txt"));
    }
    

}
