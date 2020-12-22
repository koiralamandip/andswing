package layout.components;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

import activity.Activity;
import layout.ContentLayout;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class ASComboBox<T> extends JComboBox<T>{
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

	public ASComboBox(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
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
