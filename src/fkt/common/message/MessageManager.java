package fkt.common.message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import fkt.common.system.SystemAttributes;
import fkt.common.system.SystemEntity;
import fkt.common.system.SystemLevel;
import fkt.common.system.SystemName;
import fkt.common.system.SystemState;

public class MessageManager {
	protected static MessageManager INSTANCE = new MessageManager();
	public final UUID uuid = UUID.randomUUID();
	
	protected List<AMessage> Queue = new ArrayList<AMessage>();

	public AMessage Dequeue() {
		return this.Queue.remove(0);
	}
	public MessageManager Enqueue(AMessage message) {
		this.Queue.add(message);
		
		return this;
	}

	public MessageManager Dispatch() {
		while(!this.Queue.isEmpty()) {
			this.Route(this.Dequeue());
		}
		
		return this;
	}
	
	public MessageManager Route(AMessage message) {
		switch(message.MessageType) {
			case SystemAttributes:
				SystemAttributes.GetInstance().ReceiveMessage(message);
				break;				
			case SystemEntity:
				SystemEntity.GetInstance().ReceiveMessage(message);
				break;
			case SystemLevel:
				SystemLevel.GetInstance().ReceiveMessage(message);
				break;
			case SystemName:
				SystemName.GetInstance().ReceiveMessage(message);
				break;
			case SystemState:
				SystemState.GetInstance().ReceiveMessage(message);
				break;
			default:
				break;				
		}
		
		return this;
	}
	
	public static MessageManager GetInstance() {
		return MessageManager.INSTANCE;
	}
}