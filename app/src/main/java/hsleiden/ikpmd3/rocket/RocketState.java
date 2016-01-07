package hsleiden.ikpmd3.rocket;

import android.content.Context;
import android.graphics.Canvas;

import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.boot.MainActivity;

/**
 * @author Richard Jongenburger
 */

public abstract class RocketState
{
    protected Rocket rocket;
	protected Context context = MainActivity.getContext();
	protected Animation animation;

    public RocketState(Rocket rocket)
    {
        this.rocket = rocket;
    }

    public abstract void update();

    public abstract void draw(Canvas canvas);
}
