package fkt.common.enums;

public enum EnumDiscipline {
	PHYSICAL,
	MAGICAL,
	HYBRID;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumDiscipline fromString(String text) {
		for (EnumDiscipline b : EnumDiscipline.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}