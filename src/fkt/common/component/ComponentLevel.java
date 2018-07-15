package fkt.common.component;

import fkt.common.enums.EnumComponentType;
import fkt.utility.Experience;

public class ComponentLevel extends AComponent {
	public Experience Experience;

	public ComponentLevel(int level, int current, int max) {
		super(EnumComponentType.LEVEL);
		
		this.Experience = new Experience(level, current, max);
	}
	public ComponentLevel(int current) {
		this(1, current, 0);
	}
	public ComponentLevel() {
		this(1, 0, 0);
	}
}