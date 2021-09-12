package com.mycompany.app;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    @Ignore
//    public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
    public void sum_forPositiveNumbers()
    {
    	//Given
    	int input1=2;
    	int input2=3;
    	//When
    	int sum=new App().sum(input1,input2);
    	
    	//then
    	Assert.assertEquals(95,sum); 
    }
    @Test
    public void sum_forNegativeNumbers()
    {
    	//Given
    	int input1=-12;
    	int input2=-3;
    	//When
    	int sum=new App().sum(input1,input2);
    	
    	//then
    	Assert.assertEquals(-15,sum); 
    }
}
