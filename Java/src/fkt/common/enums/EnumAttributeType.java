package fkt.common.enums;

public enum EnumAttributeType {
	HEALTH("HP", "Health", EnumDiscipline.HYBRID),
	MANA("MP", "Mana", EnumDiscipline.MAGICAL),
	
	STRENGTH("STR", "Strength", EnumDiscipline.PHYSICAL),
	TOUGHNESS("TGH", "Toughness", EnumDiscipline.PHYSICAL),
	POWER("PWR", "Power", EnumDiscipline.MAGICAL),
	RESISTANCE("RES", "Resistance", EnumDiscipline.MAGICAL),
	
	HIT("H%", "Hit", EnumDiscipline.HYBRID),
	CRIT_HIT("C%", "Critical Hit", EnumDiscipline.HYBRID),
	CRIT_DAMAGE("CD", "Critical Damage", EnumDiscipline.HYBRID),
	
	GOLD_FIND("GF", "Gold Find", EnumDiscipline.NONE),
	MAGIC_FIND("MF", "Magical Find", EnumDiscipline.NONE);

	private final String Code;
	private final String Label;
	private final EnumDiscipline Discipline;
	
	private EnumAttributeType(String code, String label, EnumDiscipline discipline) {
		this.Code = code;
		this.Label = label;
		this.Discipline = discipline;
	}
	
	public String GetCode() {
		return Code;
	}
	
	public String GetLabel() {
		return Label;
	}
	
	public EnumDiscipline GetDiscipline() {
		return Discipline;
	}
	
	public int GetFlag() {
		return 1 << this.ordinal();
	}

	public static EnumAttributeType fromString(String text) {
		for (EnumAttributeType b : EnumAttributeType.values()) {
			if (b.toString().equalsIgnoreCase(text)) {
				return b;
			}
		}
	    
		return null;
	}
}