package fkt.common.system;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import fkt.common.component.ComponentState;
import fkt.common.entity.AEntity;
import fkt.common.enums.EnumComponentType;
import fkt.common.enums.EnumState;
import fkt.common.exceptions.InvalidStateDurationException;

public class SystemState {
	private static final SystemState INSTANCE = new SystemState();
	protected static final EnumComponentType COMPONENT_TYPE = EnumComponentType.STATE;

	public static final long DURATION_MAX = 3600000;	// 1hr in milliseconds
	
	public ComponentState GetComponent(AEntity entity) {
		return (ComponentState)SystemEntity.GetInstance().GetComponent(entity, SystemState.COMPONENT_TYPE);
	}
	

	public EnumState GetDefaultState(AEntity entity) {
		return this.GetComponent(entity).DefaultState;
	}
	public SystemState SetDefaultState(AEntity entity, EnumState state) {
		this.GetComponent(entity).DefaultState = state;
		
		return this;
	}

	public ConcurrentHashMap<EnumState, Long> GetStates(AEntity entity) {
		return this.GetComponent(entity).States; 
	}
	public SystemState SetStates(AEntity entity, ConcurrentHashMap<EnumState, Long> states) {
		this.GetComponent(entity).States = states;
		
		return this;
	}

	public boolean HasState(AEntity entity, EnumState state) {
		return this.GetComponent(entity).States.containsKey(state);
	}
	public SystemState SetState(AEntity entity, EnumState state, long duration) throws InvalidStateDurationException {
		long expiration;
		
		if(duration == -1) {
			expiration = Long.MAX_VALUE;
		} else if(duration > 0 && duration < SystemState.DURATION_MAX) {
			expiration = System.currentTimeMillis() + duration;
		} else {
			throw new InvalidStateDurationException(duration);
		}
		
		this.GetComponent(entity).States.put(state, expiration);
		
		return this;
	}	
	public SystemState RemoveState(AEntity entity, EnumState state) {
		this.GetComponent(entity).States.remove(state);
		
		return this;
	}
	

	public int GetStateCount(AEntity entity) {
		return this.GetComponent(entity).States.size();
	}
	

	public long GetExpiration(AEntity entity, EnumState state) {
		return this.GetComponent(entity).States.get(state).longValue();
	}
	public SystemState SetExpiration(AEntity entity, EnumState state, long expiration) {
		if(this.IsValidExpiration(expiration)) {
			this.GetComponent(entity).States.put(state, expiration);
		}
		
		return this;
	}
	
	public boolean IsValidExpiration(long expiration) {
		if(expiration == Long.MAX_VALUE) {
			return true;
		}

		long duration = expiration - System.currentTimeMillis();
		if(duration > 0 && duration < SystemState.DURATION_MAX) {
			return true;
		}

		return false;
	}
	public boolean IsExpired(AEntity entity, EnumState state) {
		 return this.GetComponent(entity).States.get(state).longValue() <= System.currentTimeMillis();
	}
	public boolean IsPersistent(AEntity entity, EnumState state) {
		 return this.GetComponent(entity).States.get(state).longValue() == Long.MAX_VALUE;
	}
	
	
	public SystemState ResetToDefaultState(AEntity entity) throws InvalidStateDurationException {
		this.GetComponent(entity).States.clear();
		this.SetState(entity, this.GetDefaultState(entity), -1);
		
		return this;
	}
	public SystemState RemoveAllExpiredStates(AEntity entity) throws InvalidStateDurationException {
		for(Map.Entry<EnumState, Long> state : this.GetComponent(entity).States.entrySet()) {
			if(this.IsExpired(entity, state.getKey())) {
				this.GetComponent(entity).States.remove(state.getKey());
			}
		}
		
		if(this.GetStateCount(entity) < 1) {
			this.ResetToDefaultState(entity);
		}
		
		return this;
	}
	
	
	public static SystemState GetInstance() {
		return SystemState.INSTANCE;
	}
}