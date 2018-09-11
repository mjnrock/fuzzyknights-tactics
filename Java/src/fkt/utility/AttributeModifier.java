package fkt.utility;

import java.util.UUID;

import fkt.common.enums.EnumAttributeType;

public class AttributeModifier {
	protected UUID Source = null;	// The UUID of the source (e.g. an Item, a Spell, Equipment, etc.).  More for bookkeeping than anything.
	
	public EnumAttributeType Attribute;
	public double Amount;	
	public long Expiration;
	public boolean IsAdditive;
	
	public AttributeModifier(UUID source, EnumAttributeType attribute, double amount, long expiration, boolean isAdditive) {
		this.SetSource(source);
		
		this.Attribute = attribute;
		this.Amount = amount;
		this.Expiration = expiration;
		this.IsAdditive = isAdditive;
	}
	public AttributeModifier(EnumAttributeType attribute, double amount, long expiration) {
		this(null, attribute, amount, expiration, true);
	}
	
	public UUID GetSource() {
		return this.Source;
	}
	public AttributeModifier SetSource(UUID source) {
		this.Source = source;
		
		return this;
	}
}