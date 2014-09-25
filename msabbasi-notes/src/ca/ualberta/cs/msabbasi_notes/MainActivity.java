package ca.ualberta.cs.msabbasi_notes;

import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
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

		bodyText = (EditText) findViewById(R.id.editText);
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
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	public void save(View v) {

		String text = bodyText.getText().toString();

		Task task = new Task(new Date(), text);
		tasks.add(task);

		tasksViewAdapter.notifyDataSetChanged();

		bodyText.setText("");
		dataManager.saveTasks(tasks);
	}

	public void displaySummary(MenuItem menu) {
		Toast.makeText(this, "Summary", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
		startActivity(intent);
	}
	
	public void displayArchive(MenuItem menu) {
		Toast.makeText(this, "Archive", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, ArchiveActivity.class);
		startActivity(intent);
	}
	
	public void archiveItems(MenuItem menu) {
		Toast.makeText(this, "Archive Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, ArchiveItemsActivity.class);
		startActivity(intent);
	}
	
	public void removeItems(MenuItem menu) {
		Toast.makeText(this, "Remove Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, RemoveActivity.class);
		startActivity(intent);
	}
	
	public void emailItems(MenuItem menu) {
		Toast.makeText(this, "Email Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(MainActivity.this, EmailActivity.class);
		startActivity(intent);
	}
	
	/*
	public void clear(View v) {

		tasks.clear();
		tasksViewAdapter.notifyDataSetChanged();
		dataManager.saveTasks(tasks);
	}
*/
}