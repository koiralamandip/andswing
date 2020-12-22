package layout;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import activity.Activity;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public abstract class ContentLayout extends JPanel{
	
	protected Activity activity;
	protected HashMap<String, Container> viewList = new HashMap<String, Container>();
	
	public void setActivity(Activity activity){
		this.activity = activity;
	}
	
	public ArrayList<Container> getAll(){
		return (ArrayList<Container>) viewList.values();
	}
	
	public Activity getActivity(){
		return this.activity;
	}
	
	public ContentLayout(Activity activity){
		this.activity = activity;
//		activity.setContentLayout(this);
	}
	
	protected abstract void setupUI();
	
	public void setID(String id, Container c){
		viewList.put(id, c);
	}
	
	public Container getContainerByID(String id){
		return viewList.getOrDefault(id, null);
	}
}
