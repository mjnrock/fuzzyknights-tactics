package fkt.common.message;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.enums.EnumMessageType;
import fkt.utility.KeyValue;

public class EntityMessage extends AMessage {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EntityMessage(EnumEvents event, AEntity entity) {
		super(EnumMessageType.ENTITY, new KeyValue(event, entity));
	}
}