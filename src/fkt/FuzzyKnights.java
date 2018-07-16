package fkt;

import fkt.common.entity.EntityCat;
import fkt.common.enums.EnumMessageType;
import fkt.common.exceptions.InvalidStateDurationException;
import fkt.common.message.AMessage;
import fkt.common.message.EntityMessage;
import fkt.common.message.MessageManager;
import fkt.utility.Grid;
import fkt.utility.Helper;

public class FuzzyKnights {
	private static FuzzyKnights INSTANCE = new FuzzyKnights();
	
	public static void main(String[] args) throws InvalidStateDurationException, InterruptedException {
		EntityCat cat = new EntityCat("Bob");
		
//		Helper.cout(cat);

		EntityCat e1 = new EntityCat();
		EntityCat e2 = new EntityCat();

		MessageManager.GetInstance().Dispatch();
		
//		Grid grid = new Grid(5, 5);
//		grid.GetNode(1, 2).AddEntity(e1);
//		Helper.cout(grid.GetNode(1, 2).HasEntity(e1));
//		Helper.cout(grid);
	}
	
	public static FuzzyKnights GetInstance() {
		return FuzzyKnights.INSTANCE;
	}
}