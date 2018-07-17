package fkt.common.message.entity;

import java.util.concurrent.ConcurrentHashMap;

import com.google.gson.Gson;

import fkt.common.entity.AEntity;
import fkt.common.enums.EnumEvents;
import fkt.common.enums.EnumMessageType;
import fkt.common.message.AMessage;

public class EntityConstructionMessage extends AMessage {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EntityConstructionMessage(AEntity entity) {
		super(EnumMessageType.ENTITY);

		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>() {{
			put("Event", EnumEvents.EntityConstruction);
			put("Entity", entity);
		}};
		
		this.SetPayload((new Gson()).toJson(map));
	}
}