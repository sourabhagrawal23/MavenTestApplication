package com.mycompany.app;


import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

import org.junit.Ignore;

public class TradingCalculatorTest {
	
	@Mock
	private MockTradingValidator tradingValidator=new MockTradingValidator();
	private TradingCalculator tradingCalulator=new TradingCalculator(tradingValidator);
	
//	public TradingCalculatorTest() {
//		MockitoAnnotations.initMocks(this);
//		tradingCalulator=new TradingCalculator(tradingValidator);
//	}
	
	@Test
	public void test_Add_PositiveNumbers_whentradingHoursAreNotOver() {
		//Given
		int inp1=2,inp2=3;
		tradingValidator.setValueToReturn(true);
		
//		Mockito.when(tradingValidator.validate()).thenReturn(true);
		//When
		int output=tradingCalulator.add(inp1,inp2);
		//Then
		assertEquals(5,output);
	}
	
	@Test
	public void test_Add_PositiveNumbers_whentradingHoursAreOver() {
		//Given
		int inp1=2,inp2=3;
		tradingValidator.setValueToReturn(false);
//		Mockito.when(tradingValidator.validate()).thenReturn(false);
		//When
		int output=tradingCalulator.add(inp1,inp2);
		//Then
		assertEquals(0,output);
	}
	
	@Test
	public void test_Add_AnyNegativeNumbers_ReturnZero__whentradingHoursAreOver() {
		//Given
		int inp1=-2,inp2=3;
		tradingValidator.setValueToReturn(false);
//		Mockito.when(tradingValidator.validate()).thenReturn(false);

		//When
		int output=tradingCalulator.add(inp1,inp2);
		//Then
		assertEquals(0,output);
	}
	@Test
	public void test_Division_PositiveNumbers() {
		//Given
		int inp1=30,inp2=6;
		tradingValidator.setValueToReturn(true);
//		Mockito.when(tradingValidator.validate()).thenReturn(true);
		//When
		int output=tradingCalulator.divide(inp1,inp2);
		//Then
		assertEquals(5,output);
	}
	@Test(expected = IllegalArgumentException.class)
	public void test_Division_ofZeroDenominator_shouldReturnException() {
		//Given
		int inp1=6,inp2=0;
		tradingValidator.setValueToReturn(true);
//		Mockito.when(tradingValidator.validate()).thenReturn(true);
		//When
		int output=tradingCalulator.divide(inp1,inp2);
		//Then
	}
	
	@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void test_Division_ofZeroDenominator_ReturnZero__whentradingHoursAreOver() {
		//Given
		int inp1=6,inp2=0;
		tradingValidator.setValueToReturn(false);
//		Mockito.when(tradingValidator.validate()).thenReturn(false);
		//When
		int output=tradingCalulator.divide(inp1,inp2);
		//Then
		assertEquals(0,output);
	}
	
	@Ignore
	@Test
	public void test_Division_ofNonDivisibleNumber_shouldReturnroundUpValue() {
		//Given
		int inp1=6,inp2=5;
		//When
		int output=tradingCalulator.divide(inp1,inp2);
		//Then
		assertEquals(2,output);
	}
	
	private class MockTradingValidator implements TradingValidator{
		
		private boolean valueToReturn;
		
		public void setValueToReturn(boolean valueToReturn)
		{
			this.valueToReturn=valueToReturn;
		}
		
		
		public boolean validate()
		{
			return valueToReturn;
		}
	}
}
