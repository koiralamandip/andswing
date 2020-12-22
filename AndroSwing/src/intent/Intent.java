package intent;

import activity.Activity;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class Intent{
	private Activity activity;
	private Class newClass;
	private Bundle bundle = new Bundle();
	
	public Intent(Activity activity, Class newClass){
		this.activity = activity;
		this.newClass = newClass;
	}
	
	public Intent(){
		
	}
	
	//----------------------------------
	public Bundle getExtras(){
		return this.bundle;
	}
	
	public void putExtras(Bundle bundle){
		this.bundle = bundle;
	}
	
	public void putExtras(Intent intent){
		this.bundle = intent.getExtras();
	}
	//----------------------------------
	//----------------------------------
	public void putExtra(String key, String data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, String[] data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, int data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, int[] data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, Object data){
		bundle.putExtra(key, data);
	}

	public void putExtra(String key, Object[] data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, float data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, float[] data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, boolean data){
		bundle.putExtra(key, data);
	}
	
	public void putExtra(String key, boolean[] data){
		bundle.putExtra(key, data);
	}
	
	//----------------------------------
	//----------------------------------
	public String getStringExtra(String key, String defaultValue){
		return bundle.getStringExtra(key, defaultValue);
	}
	
	public String[] getStringArrayExtra(String key, String[] defaultValue){
		return bundle.getStringArrayExtra(key, defaultValue);
	}
	
	public int getIntExtra(String key, int defaultValue){
		return bundle.getIntExtra(key, defaultValue);
	}
	
	public int[] getIntArrayExtra(String key, int[] defaultValue){
		return bundle.getIntArrayExtra(key, defaultValue);
	}
	
	public Object getObjectExtra(String key, Object defaultValue){
		return bundle.getObjectExtra(key, defaultValue);
	}
	
	public Object[] getObjectArrayExtra(String key, Object[] defaultValue){
		return bundle.getObjectArrayExtra(key, defaultValue);
	}
	
	public float getFloatExtra(String key, float defaultValue){
		return bundle.getFloatExtra(key, defaultValue);
	}
	
	public float[] getFLoatArrayExtra(String key, float[] defaultValue){
		return bundle.getFloatArrayExtra(key, defaultValue);
	}
	
	public boolean getBooleanExtra(String key, boolean defaultValue){
		return bundle.getBooleanExtra(key, defaultValue);
	}
	
	public boolean[] getBooleanArrayExtra(String key, boolean[] defaultValue){
		return bundle.getBooleanArrayExtra(key, defaultValue);
	}
	
	//----------------------------------
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Class getNewClass() {
		return newClass;
	}

	public void setNewClass(Class newClass) {
		this.newClass = newClass;
	}
	
}
