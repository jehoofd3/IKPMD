package hsleiden.ikpmd3.boot;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.helpers.DatabaseReceiver;
import hsleiden.ikpmd3.levelStateManager.LevelStateManager;
import hsleiden.ikpmd3.utility.Utility;

/**
 * This is the activity where all the levels of the game will play.
 *
 * @author Richard Jongenburger
 */

public class MainActivity extends Activity {

	private static Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//turn title off
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		//set to full screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		context = getApplicationContext();

		// Set the widht and height in the Utility class
		Utility.GAME_WIDTH = getWindowManager().getDefaultDisplay().getWidth();
		Utility.GAME_HEIGHT = getWindowManager().getDefaultDisplay().getHeight();

		// Create a database receiver. This makes a database if there isn't one already.
		DatabaseReceiver.getDatabaseReceiver(this);

		// Create a new level state manager that handels the levels.
		new LevelStateManager(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings)
		{
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public static Context getContext()
	{
		return context;
	}


}

