package fkt.utility;

public class Experience {
	public int Level;
	public int Current;
	public int Max;

	public Experience(int level, int current, int max) {
		this.Level = level;
		this.Current = current;
		this.Max = max;
	}
	public Experience(int current, int max) {
		this(1, current, max);
	}
	public Experience() {
		this(1, 0, 0);
	}
}