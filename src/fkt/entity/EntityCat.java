package fkt.entity;

import fkt.component.AComponent;
import fkt.component.ComponentAttributes;
import fkt.component.ComponentHealth;
import fkt.component.ComponentName;
import fkt.component.ComponentResource;
import fkt.component.ComponentState;

public class EntityCat extends AEntity {
	public EntityCat(String name) {
		super(new AComponent[] {
			new ComponentName("entity-cat", name),
			new ComponentHealth(10, 10),
			new ComponentResource(5, 5),
			new ComponentAttributes(4, 3, 1, 1),
			
			new ComponentState()
		});
	}
	public EntityCat() {
		this(null);
	}
}