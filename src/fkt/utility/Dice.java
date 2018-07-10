package fkt.utility;

public class Dice {
	public static final Dice INSTANCE = new Dice();
	
	public int Random(int min, int max) {
        return (int)(Math.floor(Math.random() * (max - min + 1)) + min);
    }
    
    public int Roll(int X, int Y, int Z) {
        int value = 0;
        for(int i = 0; i < X; i++) {
            value += this.Random(1, Y);
        }
        
        return value + Z;
    }
    public int Roll(int X, int Y) {
    	return this.Roll(X, Y, 0);
    }
    public int Roll(int Y) {
        return this.Roll(1, Y, 0);
    }
    
    public boolean Coin() {
        return this.Roll(1, 2) == 1 ? true : false;
    }

    public int Fudge(int amount) {
    	if(amount <= 0) {
    		return 0;
    	}
    	
    	return this.Roll(1 * amount, 3, -2 * amount);		// XdF equivalent, X = amount
    }
    public int Fudge() {
    	return this.Fudge(1);
    }

    public int D2() {
        return this.Roll(1, 2);
    }
    public int D2(int Z) {
        return this.Roll(1, 2) + Z;
    }

    public int D3() {
        return this.Roll(1, 3);
    }
    public int D3(int Z) {
        return this.Roll(1, 3) + Z;
    }

    public int D4() {
        return this.Roll(1, 4);
    }
    public int D4(int Z) {
        return this.Roll(1, 4) + Z;
    }

    public int D6() {
        return this.Roll(1, 6);
    }
    public int D6(int Z) {
        return this.Roll(1, 6) + Z;
    }

    public int D10() {
        return this.Roll(1, 10);
    }
    public int D10(int Z) {
        return this.Roll(1, 10) + Z;
    }

    public int D12() {
        return this.Roll(1, 12);
    }
    public int D12(int Z) {
        return this.Roll(1, 12) + Z;
    }

    public int D20() {
        return this.Roll(1, 20);
    }
    public int D20(int Z) {
        return this.Roll(1, 20) + Z;
    }

    public int D25() {
        return this.Roll(1, 25);
    }
    public int D25(int Z) {
        return this.Roll(1, 25) + Z;
    }

    public int D50() {
        return this.Roll(1, 50);
    }
    public int D50(int Z) {
        return this.Roll(1, 50) + Z;
    }

    public int D100() {
        return this.Roll(1, 100);
    }
    public int D100(int Z) {
        return this.Roll(1, 100) + Z;
    }
    
    public <T> T WeightedRandom(int[] weights, T[] values) {                
        int total = 0;
        for(int i : weights) {
            total += weights[i];
        }
        
        int roll = this.Random(1, total);
        
        int count = 0;
        for(int i = 0; i < weights.length; i++) {
            count += weights[i];
            
            if(roll <= count) {
                return values[i];
            }
        }
        
        return values[values.length - 1];
    };
    
	
	public static Dice GetInstance() {
		return Dice.INSTANCE;
	}
}