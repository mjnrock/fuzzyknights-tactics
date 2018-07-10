package fkt.utility;

public class Bitwise {    
    public boolean Has(long base, long flag) {
        return (base & flag) == flag;
    }
    
    public long Add(long base, long ... flags) {
        long mask = base;
        for(long flag : flags) {
            mask = mask | flag;
        }
        
        return mask;
    }
    
    public long Remove(long base, long ... flags) {
        long mask = base;
        for(long flag : flags) {
            mask = mask & ~flag;
        }
        
        return mask;
    };
}