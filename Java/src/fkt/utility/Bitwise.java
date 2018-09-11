package fkt.utility;

public class Bitwise {
    public boolean Has(int base, int flag) {
        return (base & flag) == flag;
    }
    public boolean Has(long base, long flag) {
        return (base & flag) == flag;
    }

    public int Add(int base, int ... flags) {
    	int mask = base;
        for(int flag : flags) {
            mask = mask | flag;
        }
        
        return mask;
    }
    public long Add(long base, long ... flags) {
        long mask = base;
        for(long flag : flags) {
            mask = mask | flag;
        }
        
        return mask;
    }

    public int Remove(int base, int ... flags) {
    	int mask = base;
        for(int flag : flags) {
            mask = mask & ~flag;
        }
        
        return mask;
    }
    public long Remove(long base, long ... flags) {
        long mask = base;
        for(long flag : flags) {
            mask = mask & ~flag;
        }
        
        return mask;
    }
}