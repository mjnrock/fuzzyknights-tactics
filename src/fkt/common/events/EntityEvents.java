package fkt.common.events;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.message.EntityMessage;

public class EntityEvents {
	protected static EntityEvents INSTANCE = new EntityEvents();

	//TODO This will probably need a "Map" parameter at some point
	public void EntityConstruction(AEntity entity) {
		(new EntityMessage(EnumEvents.EntityConstruction, entity)).Send();
	}
	
	public static EntityEvents GetInstance() {
		return EntityEvents.INSTANCE;
	}
}