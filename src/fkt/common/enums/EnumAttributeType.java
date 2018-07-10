package fkt.common.enums;

public enum EnumAttributeType {
	HEALTH("HP", "Health", EnumDiscipline.HYBRID),
	MANA("MP", "Mana", EnumDiscipline.MAGICAL),
	
	STRENGTH("STR", "Strength", EnumDiscipline.PHYSICAL),
	TOUGHNESS("TGH", "Toughness", EnumDiscipline.PHYSICAL),
	POWER("PWR", "Power", EnumDiscipline.MAGICAL),
	RESISTANCE("RES", "Resistance", EnumDiscipline.MAGICAL);

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