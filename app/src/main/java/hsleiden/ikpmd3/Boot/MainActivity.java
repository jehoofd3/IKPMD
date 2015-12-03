package hsleiden.ikpmd3.Boot;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
<<<<<<< Updated upstream
=======

import hsleiden.ikpmd3.Helpers.DatabaseInfo;
import hsleiden.ikpmd3.Helpers.DatabaseReceiver;
import hsleiden.ikpmd3.LevelStateManager.Level1Activity;
import hsleiden.ikpmd3.LevelStateManager.LevelState;
import hsleiden.ikpmd3.LevelStateManager.LevelStateManager;
>>>>>>> Stashed changes
import hsleiden.ikpmd3.R;

public class MainActivity extends Activity
{
<<<<<<< Updated upstream
	private Boot2 boot;
=======
>>>>>>> Stashed changes

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//turn title off
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		//set to full screen
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

<<<<<<< Updated upstream
		boot = new Boot2(this);
		
		setContentView(boot);
=======
		DatabaseReceiver databaseReceiver = DatabaseReceiver.getDatabaseReceiver(this);
		databaseReceiver.insertImage("test_tile", DatabaseInfo.MapImages.TABLE_NAME);
		LevelStateManager lsm = new LevelStateManager(this);
>>>>>>> Stashed changes
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
}