package fkt.common.enums;

public enum EnumEvents {
	EntityConstruction;

	public static EnumEvents fromString(String text) {
		for (EnumEvents b : EnumEvents.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}