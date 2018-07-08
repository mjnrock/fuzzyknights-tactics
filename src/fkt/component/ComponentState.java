package fkt.component;

import java.util.concurrent.ConcurrentHashMap;

import fkt.enums.EnumComponentType;
import fkt.enums.EnumState;
import fkt.exceptions.InvalidStateDurationException;
import fkt.system.SystemState;

public class ComponentState extends AComponent {
	public EnumState DefaultState = EnumState.NORMAL;
	public ConcurrentHashMap<EnumState, Long> States = new ConcurrentHashMap<EnumState, Long>();
	
	public ComponentState() {
		super(EnumComponentType.STATE);
	}
	/**
	 * Pass an object with the following syntax:
	 * 
	 * new Object[][] {
	 * 	{ <EnumState> State, <long> Expiration },
	 *  ...
	 * }
	 * 
	 * @param Object[][] states
	 * @throws InvalidStateDurationException 
	 */
	public ComponentState(Object[][] states) throws InvalidStateDurationException {
		this();
		
		for(Object[] state : states) {
			long expiration, duration = (long)state[1];
			
			if(duration == -1) {
				expiration = Long.MAX_VALUE;
			} else if(duration > 0 && duration < SystemState.DURATION_MAX) {
				expiration = System.currentTimeMillis() + duration;
			} else {
				throw new InvalidStateDurationException(duration);
			}
			
			this.States.put(
				(EnumState)state[0],
				expiration
			);
		}
	}
	public ComponentState(ConcurrentHashMap<EnumState, Long> states) {
		this();
		
		this.States = states;
	}
}