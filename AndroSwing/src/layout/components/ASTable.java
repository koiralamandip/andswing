package layout.components;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JTable;

import activity.Activity;
import layout.ContentLayout;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class ASTable extends JTable{
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

	public ASTable(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
		setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		setRowHeight(getRowHeight() + 10);
	}
	
	public void setID(String key){
		layout.setID(key, this);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		// TODO Auto-generated method stub
		super.paintBorder(g);
	}
	
}
