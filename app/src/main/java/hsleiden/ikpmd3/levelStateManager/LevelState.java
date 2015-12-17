package hsleiden.ikpmd3.levelStateManager;

import android.content.Context;
import android.view.SurfaceView;

/**
 *	This class is an abstract class that all the levels must extend to.
 *  @author Richard Jongenburger
 */

public abstract class LevelState extends SurfaceView
{
	public LevelState(Context context)
	{
		super(context);
	}

	public abstract void update();

	public abstract void setActivityLoop(ActivityLoop activityLoop);
}
