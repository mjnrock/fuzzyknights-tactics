package fkt.common.message.entity;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.enums.EnumMessageType;
import fkt.common.message.AMessage;
import fkt.common.message.IEventMessage;
import fkt.utility.Node;

public class EntityLeftNodeMessage extends AMessage implements IEventMessage {
	public Node Node;
	public AEntity Entity;
	
	public EntityLeftNodeMessage(Node node, AEntity entity) {
		super(EnumMessageType.SystemEntity);

		this.Node = node;
		this.Entity = entity;
	}

	@Override
	public EnumEvents GetEvent() {
		return EnumEvents.EntityLeftNode;
	}
}