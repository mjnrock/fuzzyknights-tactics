package fkt.enums;

public enum EnumCondition {
	NORMAL,
	WEAK,
	CURSED,
	AFRAID,
	INSANE,
	POISONED,
	DISEASED,
	PARALYZED,
	ASLEEP,
	UNCONCIOUS,
	DEAD;
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}


	public static EnumCondition fromString(String text) {
		for (EnumCondition b : EnumCondition.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}