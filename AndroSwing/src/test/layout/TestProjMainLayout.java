package test.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import activity.Activity;
import layout.ContentLayout;
import layout.components.ASButton;
import layout.components.ASComboBox;
import layout.components.ASLabel;
import layout.components.ASPasswordField;
import layout.components.ASTable;
import layout.components.ASTextField;
import test.java.TestProjAnSMainActivity;

public class TestProjMainLayout extends ContentLayout{

	public TestProjMainLayout(Activity activity) {
		super(activity);
	}

	@Override
	protected void setupUI() {
		// TODO Auto-generated method stub
		this.setLayout(new BorderLayout());
		this.setBackground(Color.gray);
		ASButton btn1 = new ASButton(this, "New Activity");
		btn1.setID("btn1");
		btn1.addActionListener(e -> ((TestProjAnSMainActivity) getActivity()).openNew(btn1));
		add(btn1,BorderLayout.NORTH);
		JPanel l = new JPanel();
		setID("lCenter", l);
		ASTextField tf = new ASTextField(this);
		tf.setPreferredSize(new Dimension(300,35));
		tf.setID("tf");
		l.add(tf);
		
		ASLabel tL = new ASLabel(this, "Enter Name");
		tL.setID("tf");
		l.add(tL);
		
		
		ASComboBox<String> tC = new ASComboBox<String>(this);
		int i = 10;
		while(i > 0){
			tC.addItem(new String("Apple"));
			i--;
		}
		tC.setID("tC");
		l.add(tC);
		
		ASPasswordField pf = new ASPasswordField(this);
		pf.setPreferredSize(new Dimension(300,35));
		pf.setID("tf");
		l.add(pf);
		

		String[] cols = new String[]{"Name", "Age", "Phone"};
		String[][] data = new String[][]{
			{"Mandeep Koirala", "24", "9815980985"},
			{"Mandeep Koirala", "24", "9815980985"},
			{"Mandeep Koirala", "24", "9815980985"},
			{"Mandeep Koirala", "24", "9815980985"}
		};
		DefaultTableModel tm = new DefaultTableModel(data, cols);
		
		ASTable tb = new ASTable(this);
		tb.setModel(tm);
		tb.setID("tb");
		JScrollPane sp = new JScrollPane(tb);
		l.add(sp);
		
		l.setBackground(Color.pink);
		add(l, BorderLayout.CENTER);
	}

}
