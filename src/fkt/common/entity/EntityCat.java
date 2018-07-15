package fkt.common.entity;

import fkt.common.component.AComponent;
import fkt.common.component.ComponentAttributes;
import fkt.common.component.ComponentCurrencies;
import fkt.common.component.ComponentLevel;
import fkt.common.component.ComponentName;
import fkt.common.component.ComponentState;
import fkt.common.enums.EnumAttributeType;

public class EntityCat extends AEntity {
	public EntityCat(String name) {
		super(new AComponent[] {
			new ComponentName("entity-living", name),
			new ComponentAttributes(new Object[][] {
				{ EnumAttributeType.HEALTH, 10 },
				{ EnumAttributeType.MANA, 5 },
				
				{ EnumAttributeType.STRENGTH, 4 },
				{ EnumAttributeType.TOUGHNESS, 1 },
				{ EnumAttributeType.POWER, 2 },
				{ EnumAttributeType.RESISTANCE, 3 }
			}),			
			new ComponentState(),
			new ComponentLevel(),
			new ComponentCurrencies()
		});
	}
	public EntityCat() {
		this(null);
	}
}