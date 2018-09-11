package fkt.common.component;

import java.util.concurrent.ConcurrentHashMap;

import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumCurrencyType;

public class ComponentCurrencies extends AComponent {
	public ConcurrentHashMap<EnumCurrencyType, Double> Currencies = new ConcurrentHashMap<EnumCurrencyType, Double>();
	public ConcurrentHashMap<EnumCurrencyType, Double> Bank = new ConcurrentHashMap<EnumCurrencyType, Double>();
	
	public ComponentCurrencies(EnumCurrencyType currencyType, double amount) {
		this();

		this.Currencies.put(currencyType, amount);
	}
	public ComponentCurrencies() {
		super(EnumComponentType.CURRENCY);
		
		for(EnumCurrencyType curr : EnumCurrencyType.values()) {
			this.Currencies.put(curr, 0D);
			this.Bank.put(curr, 0D);
		}
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
	public ComponentCurrencies(Object[][] currencies){
		super(EnumComponentType.CURRENCY);
		
		for(Object[] currency : currencies) {
			this.Currencies.put(
				(EnumCurrencyType)currency[0],
				Double.valueOf(currency[1].toString())
			);
		}
	}
	public ComponentCurrencies(ConcurrentHashMap<EnumCurrencyType, Double> currencies) {
		super(EnumComponentType.CURRENCY);
		
		this.Currencies = currencies;
	}
}