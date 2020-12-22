package activity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import intent.Intent;
import layout.ContentLayout;
import main.AndroSwingLauncher;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public abstract class Activity extends JFrame{
	
	private int requestCode;
	private Intent i;
	private ContentLayout layout;
	
	private void run(){
		setTitle("Activity");
		setSize(640,480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.onCreate();
		setVisible(true);
	}
	
	public void setContentLayout(ContentLayout layout){
		this.layout = layout;
	}
	
	public ContentLayout getContentLayout(){
		return this.layout;
	}
	
	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}
	
	public Intent getIntent(){
		return i;
	}
	
	public void setIntent(Intent i){
		this.i = i;
	}
	
	/**
	 * @param none
	 * @return none
	 * Abstract method onCreate() must be implemented (overridden) in each subclass exteding Activity. Activity initialization is done here.
	 */
	protected abstract void onCreate();
	
	protected void setContentView(Class className){
		try{
			Constructor cons = className.getConstructor(Activity.class);
			ContentLayout c = (ContentLayout) cons.newInstance(this);
			Method drawMethod = className.getDeclaredMethod("setupUI", null);
			drawMethod.setAccessible(true);
			drawMethod.invoke(c, null);
			drawMethod.setAccessible(false);
			this.setContentLayout(c);
			this.setContentPane(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	protected void setResult(int resultCode, Intent returnIntent){
		returnIntent.getActivity().onActivityResult(getRequestCode(), resultCode, returnIntent);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		
	}
	
	protected void startActivity(Intent i){
		AndroSwingLauncher.startActivity(i);
	}
	
	protected void startActivityForResult(Intent i, int requestCode){
		AndroSwingLauncher.startActivityForResult(i, requestCode);
	}
	
	/**
	 * When disposing the activity, onDestory() of superclass or the overridden (if done) in sub-class will be called first.
	 * Which returns boolean indicating whether the activity should be disposed or not.
	 */
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		if (onDestroy())
			super.dispose();
	}
	
	/**
	 * If, in your system, you want the activity to remain open before certain conditions meet, implement the onDestroy method to check
	 * if those conditions meet
	 * @return boolean indication (not)-dispose the current activity
	 */
	protected boolean onDestroy(){return true;}
}
