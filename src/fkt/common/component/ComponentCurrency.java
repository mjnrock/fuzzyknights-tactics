package fkt.common.component;

import java.util.concurrent.ConcurrentHashMap;

import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumCurrencyType;

public class ComponentCurrency extends AComponent {
	public ConcurrentHashMap<EnumCurrencyType, Double> Currencies = new ConcurrentHashMap<EnumCurrencyType, Double>();
	
	public ComponentCurrency(EnumCurrencyType currencyType, double amount) {
		super(EnumComponentType.CURRENCY);

		this.Currencies.put(currencyType, amount);
	}

	/**
	 * Pass an object with the following syntax:
	 * 
	 * new Object[][] {
	 * 	{ <EnumCurrencyType> CurrencyType, <double> Amount },
	 *  ...
	 * }
	 * 
	 * @param Object[][] currencies
	 */
	public ComponentCurrency(Object[][] currencies){
		super(EnumComponentType.CURRENCY);
		
		for(Object[] currency : currencies) {
			this.Currencies.put(
				(EnumCurrencyType)currency[0],
				Double.valueOf(currency[1].toString())
			);
		}
	}
	public ComponentCurrency(ConcurrentHashMap<EnumCurrencyType, Double> currencies) {
		super(EnumComponentType.CURRENCY);
		
		this.Currencies = currencies;
	}
}