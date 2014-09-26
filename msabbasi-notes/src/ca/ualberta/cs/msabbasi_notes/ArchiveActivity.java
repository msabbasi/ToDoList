package ca.ualberta.cs.msabbasi_notes;

import java.util.ArrayList;

import ca.ualberta.cs.msabbasi_notes.data.FileDataManager;
import ca.ualberta.cs.msabbasi_notes.data.IDataManager;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ArchiveActivity extends Activity {
	
	private IDataManager tasksManager;
	
	private ListView archivedTasksList;
	
	private ArrayList<Task> archivedTasks;
	
	private ArrayAdapter<Task> tasksViewAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archive);
		
		tasksManager = new FileDataManager(this);

		archivedTasksList = (ListView) findViewById(R.id.oldArchiveTasksList);
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();

		
		archivedTasks = tasksManager.loadArchiveTasks();
		tasksViewAdapter = new ArrayAdapter<Task>(this,
				R.layout.list_item, archivedTasks);
		archivedTasksList.setAdapter(tasksViewAdapter);
		
	}
	
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.archivemenu, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	public void removeArchiveItems(MenuItem menu) {
		Toast.makeText(this, "Remove Archived Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(ArchiveActivity.this, RemoveArchiveItemsActivity.class);
		startActivity(intent);
	}
	
	public void emailArchiveItems(MenuItem menu) {
		Toast.makeText(this, "Email Archived Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(ArchiveActivity.this, EmailArchiveActivity.class);
		startActivity(intent);
	}

	public void unArchiveItems(MenuItem menu) {
		Toast.makeText(this, "Unarchive Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(ArchiveActivity.this, UnarchiveActivity.class);
		startActivity(intent);
	}
}
