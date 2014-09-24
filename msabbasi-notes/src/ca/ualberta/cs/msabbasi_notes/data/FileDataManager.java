package ca.ualberta.cs.msabbasi_notes.data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import ca.ualberta.cs.msabbasi_notes.Task;

public class FileDataManager implements IDataManager{
	
	private static final String FILENAME = "file.sav";
	
	private Context ctx;
	
	public FileDataManager(Context ctx) {
		this.ctx = ctx;
	}
	
	public ArrayList<Task> loadTasks() {
		ArrayList<Task> lts = new ArrayList<Task>();

		try {
			FileInputStream fis = ctx.openFileInput(FILENAME);
			ObjectInputStream ois = new ObjectInputStream(fis);

			lts = (ArrayList<Task>) ois.readObject();

		} catch (Exception e) {
			Log.i("LonelyTwitter", "Error casting");
			e.printStackTrace();
		} 

		return lts;
	}
	
	public void saveTasks(List<Task> lts) {
		try {
			FileOutputStream fos = ctx.openFileOutput(FILENAME, Context.MODE_PRIVATE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(lts);
			fos.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
