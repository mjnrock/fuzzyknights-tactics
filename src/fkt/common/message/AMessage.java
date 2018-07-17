package fkt.common.message;

import java.util.UUID;

import com.google.gson.Gson;

import fkt.common.enums.EnumMessageState;
import fkt.common.enums.EnumMessageType;

public abstract class AMessage {
	public final UUID uuid = UUID.randomUUID();
	protected EnumMessageState State = EnumMessageState.PENDING;
	protected EnumMessageType MessageType;
	protected String Payload;
	protected boolean IsClientOrigin = true;

	public AMessage(EnumMessageType type, String payload) {
		this.SetMessageType(type);
		this.SetPayload(payload);
	}
	public AMessage(EnumMessageType type) {
		this.SetMessageType(type);
	}
	
	public EnumMessageState GetState() {
		return this.State;
	}
	public AMessage SetState(EnumMessageState state) {
		this.State = state;
		
		return this;
	}
	
	public EnumMessageType GetMessageType() {
		return this.MessageType;
	}
	public AMessage SetMessageType(EnumMessageType type) {
		this.MessageType = type;
		
		return this;
	}
	
	public Object GetPayload() {
		return this.Payload;
	}
	public AMessage SetPayload(String payload) {
		this.Payload = payload;
		
		return this;
	}
	
	public Object GetIsClientOrigin() {
		return this.IsClientOrigin;
	}
	public AMessage SetIsClientOrigin(boolean origin) {
		this.IsClientOrigin = origin;
		
		return this;
	}

	public boolean IsServer() {
		return !this.IsClientOrigin;
	}
	
	public AMessage Send() {
		MessageManager.GetInstance().Enqueue(this);
		
		return this;
	}
}