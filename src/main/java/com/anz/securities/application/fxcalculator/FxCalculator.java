package com.anz.securities.application.fxcalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anz.securities.common.exception.FxCalculatorException;
import com.anz.securities.common.exception.UnsuccessfulDataLoading;
import com.anz.securities.converter.api.Converter;
import com.anz.securities.converter.dto.UserInputDto;
import com.anz.securities.converter.impl.ConverterImpl;
import com.anz.securities.dataloader.spi.DataLoader;
import com.anz.securities.dataloader.spi.LoaderConfig;
import com.anz.securities.entities.dto.CurrencyConverter;

/**
 * A Spring component acts as a Facade for currency conversion. DataLoader and
 * the LoaderConfig gets injected via configuration
 * 
 * @author Anand Katti
 *
 */
@Component
public class FxCalculator {

	private DataLoader loader;
	private LoaderConfig loaderConfig;
	private Converter converter;

	@Autowired
	public void setLoader(final DataLoader myLoader) {
		this.loader = myLoader;
	}

	@Autowired
	public void setLoaderConfig(final LoaderConfig myConfig) {
		this.loaderConfig = myConfig;
	}

	/**
	 * Converts the currency based on the user input
	 * 
	 * @param userInput
	 * @throws FxCalculatorException
	 */
	public void convert(UserInputDto userInput) throws FxCalculatorException {
		converter.convert(userInput);
	}

	/**
	 * Loads the data
	 * 
	 * @throws UnsuccessfulDataLoading
	 */
	public void loadData() throws UnsuccessfulDataLoading {
		CurrencyConverter currencyConverter = loader.loadData(loaderConfig);
		converter = new ConverterImpl(currencyConverter);
	}
}
