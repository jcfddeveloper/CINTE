package co.com.jcfd.pruebaRestFull.util;

import com.google.gson.Gson;

public class GsonUtils {
	
	private GsonUtils() {}
	
	
	public static String serialize (Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public static <T> T toObject(String json, Class<T> destClass) {
		Gson gson = new Gson();
		return gson.fromJson(json, destClass);
		
	}
	
	public static <T> T toObject(Object src, Class<T> destClass) {
		Gson gson = new Gson();
		String srcJson = gson.toJson(src);
		return gson.fromJson(srcJson, destClass);
		
	}

}
