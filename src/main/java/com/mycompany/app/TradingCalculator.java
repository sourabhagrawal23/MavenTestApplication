package com.mycompany.app;

public class TradingCalculator {


	private final TradingValidator tradingValidator;

	public TradingCalculator(TradingValidator tradingValidator) {
		this.tradingValidator=tradingValidator;
	}

	public int add(int input1, int input2) {
		if(!tradingValidator.validate())
		{
			return 0;
		}
		if(input1<0 || input2<0)
		{
			return 0;
		}
		return input1+input2;
	}

	public int divide(int inp1, int inp2) {
		if(tradingValidator.validate()==false)
		{
			return 0;
		}
		if(inp2 == 0)
		{
			throw new IllegalArgumentException();
		}
		return inp1/inp2;
	}
	
}
