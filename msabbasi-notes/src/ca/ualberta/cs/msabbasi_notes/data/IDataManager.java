package ca.ualberta.cs.msabbasi_notes.data;

import java.util.ArrayList;
import java.util.List;

import ca.ualberta.cs.msabbasi_notes.Task;

public interface IDataManager {
	
	public ArrayList<Task> loadTasks();
	
	public void saveTasks(List<Task> lts);
	
	public ArrayList<Task> loadArchiveTasks();
	
	public void saveArchiveTasks(List<Task> lts);

}
