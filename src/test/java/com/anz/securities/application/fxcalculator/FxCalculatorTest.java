package com.anz.securities.application.fxcalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anz.securities.common.exception.SameSourceAndDestinationCurrency;
import com.anz.securities.converter.dto.UserInputDto;

import junit.framework.Assert;

public class FxCalculatorTest {
	
	@InjectMocks
	FxCalculator objectUnderTest;

	@Mock
	Logger logger;

	private UserInputDto userInput;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		objectUnderTest = (FxCalculator) context.getBean("calculator");
		objectUnderTest.loadData();
		userInput = new UserInputDto();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=SameSourceAndDestinationCurrency.class)
	public void testConvertCurrency_AUD_AUD() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("AUD");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
	}

	@Test
	public void testConvertCurrency_AUD_CAD() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CAD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(96.1, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_AUD_CNY() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(516.62, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_AUD_CZK() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("CZK");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(1876.16, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_AUD_DKK() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("DKK");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(505.73, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_AUD_EUR() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("EUR");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(67.97, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_AUD_JPY() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("JPY");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(10041.0, userInput.getConvertedAmount());

	}
	
	@Test
	public void testConvertCurrency_AUD_NOK() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("NOK");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(588.97, userInput.getConvertedAmount());

	}

	@Test
	public void testConvertCurrency_AUD_NZD() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("NZD");
		userInput.setConversionAmount("100");

		objectUnderTest.convert(userInput);
		Assert.assertEquals(108.01, userInput.getConvertedAmount());

	}

	@Test
	public void testConvertCurrency_AUD_GBP() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("GBP");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(53.38, userInput.getConvertedAmount());

	}

	@Test
	public void testConvertCurrency_AUD_USD() throws Exception {
		userInput.setSourceCurrency("AUD");
		userInput.setDestinationCurrency("USD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(83.71, userInput.getConvertedAmount());

	}


	@Test(expected=SameSourceAndDestinationCurrency.class)
	public void testConvertCurrency_USD_AUD() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("USD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);

	}

	@Test
	public void testConvertCurrency_USD_CAD() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("CAD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(114.8, userInput.getConvertedAmount());

	}
	@Test
	public void testConvertCurrency_USD_CNY() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("CNY");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(617.15, userInput.getConvertedAmount());
		
	}
	@Test
	public void testConvertCurrency_USD_CZK() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("CZK");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(2241.35, userInput.getConvertedAmount());

	}
	@Test
	public void testConvertCurrency_USD_DKK() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("DKK");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(604.17, userInput.getConvertedAmount());

	}
	@Test
	public void testConvertCurrency_USD_EUR() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("EUR");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(81.2, userInput.getConvertedAmount());
	}
	@Test
	public void testConvertCurrency_USD_JPY() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("JPY");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(11995.0, userInput.getConvertedAmount());
	}
	
	@Test
	public void testConvertCurrency_USD_NOK() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("NOK");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(703.61, userInput.getConvertedAmount());
	}

	@Test
	public void testConvertCurrency_USD_NZD() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("NZD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);		
		Assert.assertEquals(129.03, userInput.getConvertedAmount());
		
	}

	@Test
	public void testConvertCurrency_USD_GBP() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("GBP");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(63.76, userInput.getConvertedAmount());
	}

	@Test
	public void testConvertCurrency_USD_USD() throws Exception {
		userInput.setSourceCurrency("USD");
		userInput.setDestinationCurrency("AUD");
		userInput.setConversionAmount("100");
		
		objectUnderTest.convert(userInput);
		Assert.assertEquals(119.46, userInput.getConvertedAmount());
	}


}
