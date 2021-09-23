package com.service;

import java.util.Scanner;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class NumberWordConverterService {

	public static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
			"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
			"Nineteen" };
	public static String[] tens = { "", // 0
			"", // 1
			"twenty", // 2
			"thirty", // 3
			"forty", // 4
			"fifty", // 5
			"sixty", // 6
			"seventy", // 7
			"eighty", // 8
			"ninety" // 9
	};

	public String getMoneyIntoWords(String moneyInString) {

		String moneyInword = "";
		String centStringPart = "";
		String dollarStringPart = "";
		String centsPart = "";
		int dollarsPartInt=0;
		int centsPartInt=0;

		int dot = moneyInString.indexOf('.');
		String dollarsPart = "";
		if(dot>0){
		dollarsPart = moneyInString.substring(0, dot);
		centsPart = moneyInString.substring(dot + 1, moneyInString.length());
		 dollarsPartInt = Integer.parseInt(dollarsPart);
		 centsPartInt = Integer.parseInt(centsPart);
		}else{
		 dollarsPartInt = Integer.parseInt(moneyInString);
		}
		if (dollarsPartInt < 0 && dollarsPartInt > 1000000) {
			
			return "Please enter amount between 0 to 1000000";
		}

		if (null == dollarsPart && centsPart.length() > 2) {

			return "INVALID_INPUT_GIVEN";
		}
		if (dollarsPartInt>0) {
			dollarStringPart = convert(dollarsPartInt).toUpperCase() + " DOLLERS";
		}
		if (centsPartInt>0) {
			centStringPart = convert(centsPartInt).toUpperCase() + " CENTS";
		}
		if (dollarsPartInt > 0 && centsPartInt > 0) {
			moneyInword = dollarStringPart + " AND " + centStringPart;
		} else if (dollarsPartInt > 0) {
			moneyInword = dollarStringPart;
		} else if (centsPartInt > 0) {
			moneyInword = centStringPart;
		}
		return moneyInword;
	}

	
	public static String convert(final int n) {
		if (n < 0) {
			return "Minus " + convert(-n);
		}

		if (n < 20) {
			return units[n];
		}

		if (n < 100) {
			return tens[n / 10] + ((n % 10 != 0) ? " " : "") + units[n % 10];
		}

		if (n < 1000) {
			return units[n / 100] + " Hundred" + ((n % 100 != 0) ? " " : "") + convert(n % 100);
		}

		if (n < 100000) {
			return convert(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + convert(n % 1000);
		}

		if (n < 10000000) {
			return convert(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + convert(n % 100000);
		}

		return convert(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + convert(n % 10000000);
	}

}
