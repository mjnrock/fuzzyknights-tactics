package fkt.common.events;

import fkt.common.entity.AEntity;
import fkt.common.message.entity.EntityConstructionMessage;
import fkt.common.message.entity.EntityJoinedNodeMessage;
import fkt.common.message.entity.EntityLeftNodeMessage;
import fkt.utility.Node;

public class EntityEvents {
	protected static EntityEvents INSTANCE = new EntityEvents();

	public void EntityConstruction(AEntity entity) {
		(new EntityConstructionMessage(entity)).Send();
	}
	
	public static EntityEvents GetInstance() {
		return EntityEvents.INSTANCE;
	}

	public void EntityJoinedNode(Node node, AEntity entity) {
		(new EntityJoinedNodeMessage(node, entity)).Send();
		
	}

	public void EntityLeftNode(Node node, AEntity entity) {
		(new EntityLeftNodeMessage(node, entity)).Send();
	}
}