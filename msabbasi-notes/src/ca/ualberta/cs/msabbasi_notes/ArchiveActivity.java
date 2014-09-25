package ca.ualberta.cs.msabbasi_notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class ArchiveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_archive);
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
		Toast.makeText(this, "Email Archived Items", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(ArchiveActivity.this, EmailArchiveActivity.class);
		startActivity(intent);
	}
}
