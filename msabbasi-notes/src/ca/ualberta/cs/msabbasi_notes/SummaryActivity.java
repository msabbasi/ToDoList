package ca.ualberta.cs.msabbasi_notes;

import java.util.ArrayList;

import ca.ualberta.cs.msabbasi_notes.data.IDataManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SummaryActivity extends Activity {

	private TextView totalTasks;
	private TextView totalCheckedTasks;
	private TextView totalUncheckedTasks;
	private TextView totalArchivedTasks;
	private TextView totalCheckedArchivedTasks;
	private TextView totalUncheckedArchivedTasks;
	
	private ArrayList<Task> tasks;
	private ArrayList<Task> archivedTasks;
	
	private IDataManager tasksManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		/*
		 totalTasks = (TextView) findViewById(R.id.textView1);
		 totalCheckedTasks = (TextView) findViewById(R.id.textView2);
		 totalUncheckedTasks = (TextView) findViewById(R.id.textView3);
		 totalArchivedTasks = (TextView) findViewById(R.id.textView4);
		 totalCheckedArchivedTasks = (TextView) findViewById(R.id.textView5);
		 totalUncheckedArchivedTasks = (TextView) findViewById(R.id.textView6);
		 
		 tasks = tasksManager.loadTasks();
		 archivedTasks = tasksManager.loadArchiveTasks();
		 
		 totalTasks.setText("Total ToDo Items: ");
		 totalCheckedTasks.setText("Total ToDo Items: ");
		 totalUncheckedTasks.setText("Total ToDo Items: ");
		 totalArchivedTasks.setText("Total ToDo Items: ");
		 totalCheckedArchivedTasks.setText("Total ToDo Items: ");
		 totalUncheckedArchivedTasks.setText("Total ToDo Items: ");
		 */
		
	}
}
