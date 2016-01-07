package hsleiden.ikpmd3.rocket;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.utility.Utility;

/**
 *
 * @author Richard Jongenburger
 */

public class Rocket extends RocketHandeler
{

	private int x, y;

	public RocketState state;

	private int imageWidth;
	private int imageHeight;


	public Rocket(int x, int y, int rocketSpeed, int imageWidth, int imageHeight)
	{
		this.x = x;
		this.y = y;

		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;

		state = new RocketNormalState(this, rocketSpeed);
	}

	public void update()
	{
		state.update();
	}

	public void draw(Canvas canvas)
	{
		state.draw(canvas);
	}

	public void explode()
	{

		if(!(state instanceof RocketExplodeState))
		{
			state = new RocketExplodeState(this);
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth()
	{
		return imageWidth;
	}

	public int getHeight()
	{
		return imageHeight;
	}

}