package layout.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import activity.Activity;
import layout.ContentLayout;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class ASLabel extends JLabel{
	private ContentLayout layout;
	private Activity activity;

	public ContentLayout getContentLayout() {
		return layout;
	}

	public void setContentLayout(ContentLayout layout) {
		this.layout = layout;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ASLabel(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
	}
	
	public ASLabel(ContentLayout layout, String text){
		super(text);
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
	}
	
	public void setID(String key){
		layout.setID(key, this);
	}
}
