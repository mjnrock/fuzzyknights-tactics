package fkt.utility;

public class WeightedPool<T> {
	protected int[] Weights;
	protected T[] Values;
	
	public WeightedPool(int[] weights, T[] values) {
        this.Weights = weights;
        this.Values = values;
    }
    
    public T Roll() {
        return Dice.GetInstance().WeightedRandom(this.Weights, this.Values);
    }
    
    public int GetChance(int index) {
        int sum = 0;
        for(int i : this.Weights) {
            sum += this.Weights[i];
        }
        
        return (int)Helper.round(this.Weights[index] / sum * 100.0, 2);
    }
    
    public int[] GetWeights() {
        return this.Weights;
    }
    public T[] GetValues() {
        return this.Values;
    }
    public WeightedPool<T> Set(int[] weights, T[] values) {
        this.Weights = weights;
        this.Values = values;
        
        return this;
    }
    
    public int GetWeight(int index) {
        return this.Weights[index];
    }
    public WeightedPool<T> SetWeight(int index, int value) {
        this.Weights[index] = value;
        
        return this;
    }
    
    public T GetValue(int index) {
        return this.Values[index];
    }
    public WeightedPool<T> SetValue(int index, T value) {
        this.Values[index] = value;
        
        return this;
    }
}