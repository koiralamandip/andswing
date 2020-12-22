package test.java;

import java.awt.Container;

import activity.Activity;
import intent.Intent;
import layout.components.ASButton;
import test.layout.TestProjMainLayout;

public class TestProjAnSMainActivity extends Activity{

	private void run(){
		
	}
	@Override
	protected void onCreate() {
		// TODO Auto-generated method stub
//		super.onCreate();
		setContentView(TestProjMainLayout.class);
		setTitle("Main Activity");
		if (getIntent() != null){
			ASButton btn1 = (ASButton) getContentLayout().getContainerByID("btn1");
			btn1.setText(getIntent().getStringExtra("textNew", "Not set"));
			getIntent().putExtra("textOld", "This is previous Activity");
			setResult(0, getIntent());
		}
	}
	
	public void openNew(Container container){
		ASButton btn1 = (ASButton) container;
		btn1.setText("OK");
		Intent intent = new Intent(this, TestProjAnSMainActivity.class);
		intent.putExtra("textNew", "New Activity is Opened");
		startActivityForResult(intent, 1);
		
		Intent intent2 = new Intent(this, TestProjAnSNewActivity.class);
		
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1){
			if (resultCode == 0){
				ASButton btn1 = (ASButton) getContentLayout().getContainerByID("btn1");
				btn1.setText(data.getStringExtra("textOld", "Not set"));
			}
		}
	}
}
