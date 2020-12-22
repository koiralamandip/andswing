package main;

import java.lang.reflect.Method;
import intent.Intent;

/**
 * @author Mandip Koirala
 * @version 1.0
 */
public final class AndroSwingLauncher{
	private static Class starterClass;
	
	public static void setStarterClass(Class _starterClass){
		starterClass = _starterClass;
	}
	
	public static void launch(){
		Method mToLoad;
		try {
			Object obj = starterClass.newInstance();
			mToLoad = starterClass.getSuperclass().getDeclaredMethod("run", null);
			mToLoad.setAccessible(true);
			mToLoad.invoke(obj, null);
			mToLoad.setAccessible(false);
//			mToLoad = starterClass.getDeclaredMethod("onCreate", null);
//			mToLoad.setAccessible(true);
//			mToLoad.invoke(obj, null);
//			mToLoad.setAccessible(false);
			mToLoad = starterClass.getMethod("validate", null);
			mToLoad.invoke(obj, null);
		} catch(Exception e){
			e.printStackTrace();
			System.out.println("Could not lauch Application");
		}
	}
	
	public static void launch(Class _starterClass){
		setStarterClass(_starterClass);
		launch();
	}
	
	public static void startActivity(Intent i){
		Class toLoad = i.getNewClass();
		try {
			Object obj = toLoad.newInstance();
			Method mToLoad = toLoad.getMethod("setIntent", Intent.class);
			mToLoad.invoke(obj, i);
			mToLoad = toLoad.getSuperclass().getDeclaredMethod("run", null);
			mToLoad.setAccessible(true);
			mToLoad.invoke(obj, null);
			mToLoad.setAccessible(false);
//			mToLoad = toLoad.getDeclaredMethod("onCreate", null);
//			mToLoad.setAccessible(true);
//			mToLoad.invoke(obj, null);
//			mToLoad.setAccessible(false);
			mToLoad = toLoad.getMethod("validate", null);
			mToLoad.invoke(obj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error Loading " + i.getNewClass());
			e.printStackTrace();
		}
	}
	
	public static void startActivityForResult(Intent i, int requestCode){
		Class toLoad = i.getNewClass();
		try {
			Object obj = toLoad.newInstance();
			Method mToLoad = toLoad.getMethod("setIntent", Intent.class);
			mToLoad.invoke(obj, i);
			mToLoad = toLoad.getMethod("setRequestCode", int.class);
			mToLoad.invoke(obj, requestCode);
			mToLoad = toLoad.getSuperclass().getDeclaredMethod("run", null);
			mToLoad.setAccessible(true);
			mToLoad.invoke(obj, null);
			mToLoad.setAccessible(false);
//			mToLoad = toLoad.getDeclaredMethod("onCreate", null);
//			mToLoad.setAccessible(true);
//			mToLoad.invoke(obj, null);
//			mToLoad.setAccessible(false);
			mToLoad = toLoad.getMethod("validate", null);
			mToLoad.invoke(obj, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println("Error Loading " + i.getNewClass());
		}
	}
	
	
}
