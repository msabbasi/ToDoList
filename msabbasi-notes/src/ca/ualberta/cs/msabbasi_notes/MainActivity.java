package ca.ualberta.cs.msabbasi_notes;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.msabbasi_notes.data.FileDataManager;
import ca.ualberta.cs.msabbasi_notes.data.IDataManager;

public class MainActivity extends Activity {

	private IDataManager dataManager;

	private EditText bodyText;

	private ListView oldTasksList;

	private ArrayList<Task> tasks;

	private ArrayAdapter<Task> tasksViewAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		dataManager = new FileDataManager(this);

		bodyText = (EditText) findViewById(R.id.body);
		oldTasksList = (ListView) findViewById(R.id.oldTasksList);
	}

	@Override
	protected void onStart() {
		super.onStart();

		tasks = dataManager.loadTasks();
		tasksViewAdapter = new ArrayAdapter<Task>(this,
				R.layout.list_item, tasks);
		oldTasksList.setAdapter(tasksViewAdapter);
	}

	public void save(View v) {

		String text = bodyText.getText().toString();

		Task task = new Task(new Date(), text);
		tasks.add(task);

		tasksViewAdapter.notifyDataSetChanged();

		bodyText.setText("");
		dataManager.saveTasks(tasks);
	}

	public void clear(View v) {

		tasks.clear();
		tasksViewAdapter.notifyDataSetChanged();
		dataManager.saveTasks(tasks);
	}

}