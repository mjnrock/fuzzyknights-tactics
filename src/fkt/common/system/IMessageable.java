package fkt.common.system;

import fkt.common.message.AMessage;

public interface IMessageable {
	public IMessageable ReceiveMessage(AMessage message);
	public IMessageable MarkAsCompleted(AMessage message);
}