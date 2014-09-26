package ca.ualberta.cs.msabbasi_notes;

import java.util.ArrayList;

import ca.ualberta.cs.msabbasi_notes.data.FileDataManager;
import ca.ualberta.cs.msabbasi_notes.data.IDataManager;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RemoveActivity extends Activity {

	private IDataManager tasksManager;
	
	private MyCustomAdapter dataAdapter = null;
	
	private ArrayList<Task> tasks;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_remove);
		
		tasksManager = new FileDataManager(this);
		
		tasks = tasksManager.loadTasks();
		
		displayListView();
		  
		checkButtonClick();

	}
	
	private void displayListView() {


		//create an ArrayAdaptar from the String Array
		dataAdapter = new MyCustomAdapter(this, R.layout.selection_list, tasks);
		ListView listView = (ListView) findViewById(R.id.selectRemoveList);
		// Assign adapter to ListView
		listView.setAdapter(dataAdapter);


	}

	private class MyCustomAdapter extends ArrayAdapter<Task> {

		private ArrayList<Task> taskList;

		public MyCustomAdapter(Context context, int textViewResourceId, 
				ArrayList<Task> TaskList) {
			super(context, textViewResourceId, TaskList);
			this.taskList = new ArrayList<Task>();
			this.taskList.addAll(TaskList);
		}

		private class ViewHolder {
			TextView code;
			CheckBox name;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			Log.v("ConvertView", String.valueOf(position));

			if (convertView == null) {
				LayoutInflater vi = (LayoutInflater)getSystemService(
						Context.LAYOUT_INFLATER_SERVICE);
				convertView = vi.inflate(R.layout.selection_list, null);

				holder = new ViewHolder();
				holder.code = (TextView) convertView.findViewById(R.id.code);
				holder.name = (CheckBox) convertView.findViewById(R.id.checkBox);
				convertView.setTag(holder);

				holder.name.setOnClickListener( new View.OnClickListener() {  
					public void onClick(View v) {  
						CheckBox cb = (CheckBox) v ;  
						Task Task = (Task) cb.getTag();  
						Task.setSelected(cb.isChecked());
					}  
				});  
			} 
			else {
				holder = (ViewHolder) convertView.getTag();
			}

			Task Task = taskList.get(position);
			holder.code.setText(" ");
			holder.name.setText(Task.getTaskBody());
			holder.name.setChecked(Task.isSelected());
			holder.name.setTag(Task);

			return convertView;

		}

	}

	private void checkButtonClick() {


		Button myButton = (Button) findViewById(R.id.removeSelected);
		
		myButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				ArrayList<Task> TaskList = dataAdapter.taskList;
				for(int i=0;i<TaskList.size();i++){
					Task Task = TaskList.get(i);
					if(Task.isSelected()){
						tasks.remove(Task);
					}
				}

				Toast.makeText(getApplicationContext(),
						"Task(s) Removed", Toast.LENGTH_SHORT).show();
				
				tasksManager.saveTasks(tasks);
				
				finish();

			}
		});

	}

	
}
