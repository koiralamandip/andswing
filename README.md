# andswing
Swing based java extension to create swing system using Android's Activity &amp; Layout format


In swing:
System.java

	public class System extends JFrame{

		public System(){
			setSize(640, 480);
			// ......
			createComponents();
			setVisible(true);
		}

		public void createComponents(){
			getContentPane().add(new JPanel());
		}

		public static void main(String[] args){
			new System();
		}
	}

Now using AndroSwing:
1. Create a class System extending Activity class
2. override protected onCreate() method
3. call setContentView(SystemLayout.class) inside onCreate()
4. Here, SystemLayout is a java class which holds UI elements and separates logic for System class below.
5. Create a class SystemLayout extending ContentLayout class
6. override protected setupUI() method
7. Now create a launcher class, and in main() method, launch "launch(activity.class)" the main activity/frame you want to open the system with.

System.java
----------------

	public class System extends Activity{

		@Override
		protected void onCreate() {
			// TODO Auto-generated method stub
			//super.onCreate();
			setContentView(SystemLayout.class);
			setTitle("Main Activity");
		}
	}

SystemLayout.java
-------------

	public class SystemLayout extends ContentLayout{
		@override
		protected void setupUI(){
			this.setLayout(new BorderLayout());
			this.setBackground(Color.gray);
			ASButton btn1 = new ASButton(this, "New Activity");
			btn1.setID("btn1");
			btn1.addActionListener(e -> ((System) getActivity()).openNew(btn1));
			add(btn1,BorderLayout.NORTH);
		}
	}

Launcher.java
----------------

	public class Launcher{
		pubic static void main(String[] args){
			AndroSwingLauncher.launch(System.class);
		}
	}



------------------------------------------------------------------------
------------------------------------------------------------------------

To switch acitivies from A to B
________________________________

	public class A extends Activity{

		// ..................

		public void switchToB(){
			Intent i = new Intent(this, B.class);
			startActivity(i);
			// startActivityForResult(i, 10); where 10 is the request code sent to activity B
		}
	
		@override
		protected void onActivityResult(int requestCode, int resultCode, Intent data){
			if (requestCode == 10 && resultCode == 4){
				System.out.println(data.getStringExtra("sentMessage", "Default message if sentMessage is null"));
			}
		}
	}

	public class B extends Activity{
		
		@override
		protected void onCreate(){
			//.........
			Intent i = getIntent();
			i.putExtra("sentMessage", "This message is from B");
			setResult(4, i);
		}
	}