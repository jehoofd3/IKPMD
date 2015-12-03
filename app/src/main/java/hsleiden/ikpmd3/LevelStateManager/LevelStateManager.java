package hsleiden.ikpmd3.LevelStateManager;

import android.graphics.Canvas;

<<<<<<< Updated upstream
=======
import hsleiden.ikpmd3.Boot.MainActivity;

>>>>>>> Stashed changes
public class LevelStateManager
{

    private LevelState level;
	private MainActivity mainActivity;
	private Canvas canvas;
	private ActivityLoop activityLoop;

    public LevelStateManager(MainActivity mainActivity)
    {
<<<<<<< Updated upstream
    }
=======
		this.mainActivity = mainActivity;
>>>>>>> Stashed changes

		activityLoop = new ActivityLoop();

<<<<<<< Updated upstream
    public void draw()
    {
        level.draw();
    }
=======
		this.level = new Level1Activity(mainActivity, activityLoop);
		mainActivity.setContentView(level);
>>>>>>> Stashed changes

		runLevel();
    }

	public void runLevel()
	{
		activityLoop.setSurfaceHolder(level.getHolder());
		activityLoop.setLevel(level);
		activityLoop.run();
	}
}
