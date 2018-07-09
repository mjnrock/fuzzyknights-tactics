package fkt.common.entity;

import fkt.common.component.AComponent;
import fkt.common.component.ComponentAttributes;
import fkt.common.component.ComponentHealth;
import fkt.common.component.ComponentName;
import fkt.common.component.ComponentResource;
import fkt.common.component.ComponentState;

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