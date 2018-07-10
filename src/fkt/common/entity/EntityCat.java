package fkt.common.entity;

import fkt.common.component.AComponent;
import fkt.common.component.ComponentAttributes;
import fkt.common.component.ComponentName;
import fkt.common.component.ComponentResources;
import fkt.common.component.ComponentState;
import fkt.common.enums.EnumResourceType;

public class EntityCat extends AEntity {
	public EntityCat(String name) {
		super(new AComponent[] {
			new ComponentName("entity-cat", name),
			new ComponentResources(new Object[][] {
				{ EnumResourceType.HP, 10, 10 },
				{ EnumResourceType.MANA, 5, 5 }
			}),
			new ComponentAttributes(4, 3, 1, 1),
			
			new ComponentState()
		});
	}
	public EntityCat() {
		this(null);
	}
}