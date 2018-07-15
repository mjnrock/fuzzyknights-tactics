package fkt;

import fkt.common.entity.EntityCat;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.utility.Helper;

public class FuzzyKnights {
	private static FuzzyKnights INSTANCE = new FuzzyKnights();
	
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		EntityCat cat = new EntityCat("Bob");
		
		Helper.cout(cat);
	}
	
	public static FuzzyKnights GetInstance() {
		return FuzzyKnights.INSTANCE;
	}
}