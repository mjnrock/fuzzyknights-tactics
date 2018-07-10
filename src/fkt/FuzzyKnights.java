package fkt;

import java.util.concurrent.TimeUnit;

import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumState;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.system.SystemState;
import fkt.utility.Helper;

public class FuzzyKnights {
	private static FuzzyKnights INSTANCE = new FuzzyKnights();
	
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		Helper.cout("Sup.");
	}
	
	public static FuzzyKnights GetInstance() {
		return FuzzyKnights.INSTANCE;
	}
}