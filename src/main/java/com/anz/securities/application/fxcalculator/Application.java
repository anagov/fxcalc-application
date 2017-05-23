package com.anz.securities.application.fxcalculator;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.anz.securities.common.exception.SameSourceAndDestinationCurrency;
import com.anz.securities.converter.dto.UserInputDto;

/**
 * The FxCalculator application, Takes user input and converts the amount and
 * prints it
 * 
 * @author Anand Katti
 *
 */
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	private Application() {
	}

	public static void main(String[] args) {

		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			FxCalculator calc = (FxCalculator) context.getBean("calculator");
			UserInputDto userInput = getUserInput();

			calc.loadData();
			calc.convert(userInput);

			logger.debug("Converted Amount is:", userInput.getConvertedAmount());
			System.out.println("Converted Amount is:" + userInput.getConvertedAmount());
			context.close();
		} catch (SameSourceAndDestinationCurrency exSourecAndDestinationCurrencySame) {
			System.out.println(exSourecAndDestinationCurrencySame.getMessage());
			logger.debug("Converted Amount is:", exSourecAndDestinationCurrencySame.getMessage());
		} catch (Exception ex) {
			logger.error("Error", ex);
			System.out.println(ex.getMessage());
		}
	}

	private static UserInputDto getUserInput() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Source Currency:");
		String sourceCurrency = scanner.next();

		System.out.println("Enter Destination Currency:");
		String destCurrency = scanner.next();

		System.out.println("Enter Amount to be converted:");
		String amount = scanner.next();

		UserInputDto userDto = new UserInputDto();

		userDto.setConversionAmount(amount);
		userDto.setSourceCurrency(sourceCurrency);
		userDto.setDestinationCurrency(destCurrency);
		scanner.close();
		return userDto;
	}

}
