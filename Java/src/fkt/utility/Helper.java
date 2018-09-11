package fkt.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helper {
	public static <T> void cout(T input) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(input));
	}
	
	public static double round(double value, int places) {
		return Math.round(value * Math.pow(10, places)) / Math.pow(10, places); 
	}
	
	public static double clamp(double current, double min, double max) {
		if(current >= max) {
			return max;
		} else if(current <= min) {
			return min;
		}
		
		return current;
	}
	
	public static <T> T coalesce(T a, T b) {
	    return a == null ? b : a;
	}
	public static <T> T coalesce(T a, T b, T c) {
	    return a != null ? a : (b != null ? b : c);
	}
	@SafeVarargs
	public static <T> T coalesce(T ...items) {
	    for(T i : items) if(i != null) return i;
	    return null;
	}
}