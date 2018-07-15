package fkt.common.enums;

public enum EnumCurrencyType {
	COPPER,
	SILVER,
	GOLD;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}

	public static EnumCurrencyType fromString(String text) {
		for (EnumCurrencyType b : EnumCurrencyType.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}