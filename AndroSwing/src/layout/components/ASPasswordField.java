package layout.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPasswordField;

import activity.Activity;
import layout.ContentLayout;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class ASPasswordField extends JPasswordField{
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

	public ASPasswordField(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
	}
	
	public ASPasswordField(ContentLayout layout, String text){
		super(text);
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
	}
	
	public void setID(String key){
		layout.setID(key, this);
	}
	
//	@Override
//	protected void paintBorder(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintBorder(g);
//		g.setColor(Color.decode("#f4e2bf"));
//		g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
//	}
}
