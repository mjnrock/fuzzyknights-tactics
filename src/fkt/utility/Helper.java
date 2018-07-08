package fkt.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Helper {
	public static <T> void cout(T input) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(input));
	}
}