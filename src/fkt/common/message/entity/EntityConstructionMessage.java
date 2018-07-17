package fkt.common.message.entity;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.enums.EnumMessageType;
import fkt.common.message.AMessage;
import fkt.common.message.IEventMessage;

public class EntityConstructionMessage extends AMessage implements IEventMessage {
	public AEntity Entity;
	
	public EntityConstructionMessage(AEntity entity) {
		super(EnumMessageType.SystemEntity);

		this.Entity = entity;
	}

	@Override
	public EnumEvents GetEvent() {
		return EnumEvents.EntityConstruction;
	}
}