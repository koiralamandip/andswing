package intent;

import java.util.HashMap;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class Bundle {
	
	private HashMap<String, Object> objectMap;
	
	public Bundle(){
		objectMap = new HashMap<String, Object>();
	}
	
	public void putExtra(String key, String data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, String[] data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, int data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, int[] data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, Object data){
		objectMap.put(key, data);
	}

	public void putExtra(String key, Object[] data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, float data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, float[] data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, boolean data){
		objectMap.put(key, data);
	}
	
	public void putExtra(String key, boolean[] data){
		objectMap.put(key, data);
	}
	
	public String getStringExtra(String key, String defaultValue){
		return (String) objectMap.getOrDefault(key, defaultValue);
	}
	
	public String[] getStringArrayExtra(String key, String[] defaultValue){
		return (String[]) objectMap.getOrDefault(key, defaultValue);
	}
	
	public Object getObjectExtra(String key, Object defaultValue){
		return (Object) objectMap.getOrDefault(key, defaultValue);
	}
	
	public Object[] getObjectArrayExtra(String key, Object[] defaultValue){
		return (Object[]) objectMap.getOrDefault(key, defaultValue);
	}
	
	public int getIntExtra(String key, int defaultValue){
		return (int) objectMap.getOrDefault(key, defaultValue);
	}
	
	public int[] getIntArrayExtra(String key, int[] defaultValue){
		return (int[]) objectMap.getOrDefault(key, defaultValue);
	}
	
	public float getFloatExtra(String key, float defaultValue){
		return (float) objectMap.getOrDefault(key, defaultValue);
	}
	
	public float[] getFloatArrayExtra(String key, float[] defaultValue){
		return (float[]) objectMap.getOrDefault(key, defaultValue);
	}
	
	public boolean getBooleanExtra(String key, boolean defaultValue){
		return (boolean) objectMap.getOrDefault(key, defaultValue);
	}
	
	public boolean[] getBooleanArrayExtra(String key, boolean[] defaultValue){
		return (boolean[]) objectMap.getOrDefault(key, defaultValue);
	}
	
}
