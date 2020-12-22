package layout.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;

import org.omg.CORBA.Environment;

import activity.Activity;
import layout.ContentLayout;

public class ASTableSuggestor extends JTextField{

	private JPopupMenu popupMenu;
	private JTable table;
	private ContentLayout layout;
	private Activity activity;
	private Object selectedItem;
	
	public void setSelectedItem(Object selectedItem){
		this.selectedItem = selectedItem;
	}
		
	public Object getSelectedItem(){
		return this.selectedItem;
	}
	
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
	
	public void setID(String key){
		layout.setID(key, this);
	}
	
	public ASTableSuggestor(ContentLayout layout){
		this.layout = layout;
		this.activity = layout.getActivity();
		setPreferredSize(new Dimension(300, 40));
		
		popupMenu = new JPopupMenu();
//		popupMenu.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height/4));
		
		table = new JTable();
		JScrollPane scP = new JScrollPane(table);
		popupMenu.add(scP);
		setDocumentListener();
		setTableListListener();
		setSelectionListener();
		setKeyListener();
	}
	
	private void setKeyListener(){
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
//				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_DOWN){
					table.requestFocusInWindow();
					table.clearSelection();
				}
			}
		});
	}
	
	private void setSelectionListener(){
		table.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
//				super.keyPressed(e);
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					onSelect(table.getSelectedRow());
					ASTableSuggestor.this.requestFocusInWindow();
					table.clearSelection();
					popupMenu.setVisible(false);
				}else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_UP){
					table.clearSelection();
					ASTableSuggestor.this.requestFocusInWindow();
				}
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				onSelect(table.getSelectedRow());
				ASTableSuggestor.this.requestFocusInWindow();
				table.clearSelection();
				popupMenu.setVisible(false);
			}
		});
	}
	
	public void onSelect(int rowIndex){}
	
	private void setDocumentListener(){
		getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
//				setSelectedItem(null);
				onDocumentChanged(e);
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
//				setSelectedItem(null);
				onDocumentChanged(e);
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				onDocumentChanged(e);
			}
		});
	}
	
	private void setTableListListener(){
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()){
					if (table.getSelectedRow() == -1) return;
					onRowSelectionChanged(e);
				}
			}
		});
	}
	
	public void onRowSelectionChanged(ListSelectionEvent e){}
	
	public void onDocumentChanged(DocumentEvent e){
		if (!popupMenu.isVisible()){
			popupMenu.show(ASTableSuggestor.this, 0, ASTableSuggestor.this.getHeight());
			ASTableSuggestor.this.requestFocusInWindow();
		}
	}
	
	public void setModel(TableModel model){
		table.setModel(model);
	}
	
	public TableModel getModel(){
		return table.getModel();
	}
	
	public JPopupMenu getPopupMenu(){
		return this.popupMenu;
	}
	
	public JTable getTable(){
		return table;
	}
}
