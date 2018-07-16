package fkt;

import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumMessageType;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.message.AMessage;
import fkt.common.message.MessageManager;
import fkt.utility.Helper;

public class FuzzyKnights {
	private static FuzzyKnights INSTANCE = new FuzzyKnights();
	
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		EntityCat cat = new EntityCat("Bob");
		
		Helper.cout(cat);

		AMessage m1 = new AMessage(EnumMessageType.ENTITY, new EntityCat());
		AMessage m2 = new AMessage(EnumMessageType.ATTRIBUTES, new EntityCat());

		m1.Send();
		m2.Send();
		MessageManager.GetInstance().Dispatch();
	}
	
	public static FuzzyKnights GetInstance() {
		return FuzzyKnights.INSTANCE;
	}
}