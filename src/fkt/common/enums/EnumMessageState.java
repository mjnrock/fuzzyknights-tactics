package fkt.common.enums;

public enum EnumMessageState {
	PENDING,
	COMPLETED;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumMessageState fromString(String text) {
		for (EnumMessageState b : EnumMessageState.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}