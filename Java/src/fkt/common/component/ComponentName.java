package fkt.common.component;

import fkt.common.enums.EnumComponentType;

public class ComponentName extends AComponent {
	public String Nomen;
	public String Name;
	
	public ComponentName(String nomen, String name) {
		super(EnumComponentType.NAME);

		this.Nomen = nomen;
		this.Name = name == null ? nomen : name;
	}
	public ComponentName(String nomen) {
		this(nomen, nomen);
	}
}