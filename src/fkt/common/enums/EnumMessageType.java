package fkt.common.enums;

public enum EnumMessageType {
	SystemAttributes,
	SystemEntity,
	SystemLevel,
	SystemName,
	SystemState;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumMessageType fromString(String text) {
		for (EnumMessageType b : EnumMessageType.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}