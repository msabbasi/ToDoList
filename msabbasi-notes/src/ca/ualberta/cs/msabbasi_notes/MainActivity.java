/*
    ToDoList : Add, remove, check, uncheck, archive and unarchive tasks. 
    Copyright (C) 2014  Mujda Abbasi 
 
 
    This program is free software: you can redistribute it and/or modify 
    it under the terms of the GNU General Public License as published by 
    the Free Software Foundation, either version 3 of the License, or 
    (at your option) any later version. 
 

    This program is distributed in the hope that it will be useful, 
    but WITHOUT ANY WARRANTY; without even the implied warranty of 
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
    GNU General Public License for more details. 
 
 
    You should have received a copy of the GNU General Public License 
    along with this program.  If not, see <http://www.gnu.org/licenses/>. 

 */

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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import ca.ualberta.cs.msabbasi_notes.data.FileDataManager;
import ca.ualberta.cs.msabbasi_notes.data.IDataManager;

public class MainActivity extends Activity {

	private IDataManager tasksManager;

	private EditText bodyText;

	private ListView oldTasksList;
	
	private ArrayList<Task> tasks;

	private ArrayAdapter<Task> tasksViewAdapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		tasksManager = new FileDataManager(this);

		bodyText = (EditText) findViewById(R.id.editText);
		oldTasksList = (ListView) findViewById(R.id.oldTasksList);
	}

	@Override
	protected void onStart() {
		super.onStart();

		
		tasks = tasksManager.loadTasks();
		tasksViewAdapter = new ArrayAdapter<Task>(this,
				R.layout.list_item, tasks);
		oldTasksList.setAdapter(tasksViewAdapter);
		
		
		oldTasksList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Task Task = (Task) parent.getItemAtPosition(position);
				if (Task.isChecked() == true){
					Task.setChecked(false);
				}
				else {
					Task.setChecked(true);
				}
				
				tasksViewAdapter.notifyDataSetChanged();
				tasksManager.saveTasks(tasks);
								
			}
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.main, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	public void save(View v) {

		String text = bodyText.getText().toString().trim();

		if (!text.isEmpty()) {
			Task task = new Task(text);
			tasks.add(task);

			tasksViewAdapter.notifyDataSetChanged();
			tasksManager.saveTasks(tasks);
		}

		bodyText.setText("");
		
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
