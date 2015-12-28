package hsleiden.ikpmd3.levelStateManager;

import hsleiden.ikpmd3.boot.MainActivity;

/**
 * This class handles the state the level is in.
 * It basically means that it handles which level is updated and drawn and used to set a new level.
 * It makes sure that only one level is active.
 *
 * @author Richard Jongenburger
 */

public class LevelStateManager
{

    private LevelState level;
	private MainActivity mainActivity;
	private ActivityLoop activityLoop;

    public LevelStateManager(MainActivity mainActivity)
    {
		this.mainActivity = mainActivity;
		activityLoop = new ActivityLoop();
		setLevel(new Level1Activity(mainActivity));
		runLevel();
    }

	/**
	 * Runs the specific level that is in the level variable.
	 */
	public void runLevel()
	{
		level.setActivityLoop(activityLoop);
		mainActivity.setContentView(level);
		activityLoop.setSurfaceHolder(level.getHolder());
		activityLoop.setLevel(level);
		activityLoop.run();
	}

	public void setLevel(LevelState level)
	{
		this.level = level;
		runLevel();
	}
}
