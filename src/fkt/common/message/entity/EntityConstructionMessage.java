package fkt.common.message.entity;

import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.enums.EnumMessageType;
import fkt.common.message.AMessage;

public class EntityConstructionMessage extends AMessage {
	public EntityConstructionMessage(AEntity entity) {
		super(EnumMessageType.SystemEntity);

		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();
		map.put("Event", EnumEvents.EntityConstruction);
		map.put("Entity", entity);
		
		this.SetPayload((new Gson()).toJson(map));
	}
}