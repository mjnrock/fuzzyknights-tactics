package fkt.component;

import fkt.enums.EnumComponentType;

public class ComponentAI extends AComponent {
	
	//TODO These Strings are placeholders, they should eventually become PriorityQueue<TASK_CLASS>
	public String CurrentTask;
	public String[] Tasks;
	
	public ComponentAI() {
		super(EnumComponentType.AI);
	}
}