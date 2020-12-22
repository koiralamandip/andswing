package layout.components;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import activity.Activity;
import layout.ContentLayout;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public class ASButton extends JButton{
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

	public ASButton(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setBackground(Color.white);
	}
	
	public ASButton(ContentLayout layout, String text){
		super(text);
		this.layout = layout;
		this.activity = layout.getActivity();
//		setBackground(Color.orange);
	}
	
	public void setID(String key){
		layout.setID(key, this);
	}
	
//	protected void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		setContentAreaFilled(false);
//		final Graphics2D g2 = (Graphics2D) g.create();
//        g2.setPaint(new GradientPaint(
//                new Point(0,getHeight()/6), 
//                Color.white,
//                new Point(0, getHeight()),
//                Color.orange));
//        g2.fillRect(0, 0, getWidth(), getHeight());
//        g2.dispose();
//		super.paintComponent(g);
//	}
//	
//	@Override
//	protected void paintBorder(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintBorder(g);
//		g.setColor(Color.orange.darker());
//		g.drawRect(0, 0, getWidth()  - 1, getHeight() - 1);
//	}
}
