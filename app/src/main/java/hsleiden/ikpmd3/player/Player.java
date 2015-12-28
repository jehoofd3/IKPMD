package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import hsleiden.ikpmd3.helpers.Clock;

/**
 *
 * @author Jeroen van Ottelen
 */

public class Player
{

	public int x, y;
	public Bitmap image;
	public float xSpeed = 20, ySpeed = 0;
	public boolean touchInput;

	public PlayerState playerState;


	public Player(int x, int y, Bitmap image)
	{
		this.x = x;
		this.y = y;
		this.image = image;

		playerState = new PlayerNormalState(this);
	}

	public void update()
	{
		playerState.update();

		if(touchInput)
		{
			touchInput = false;
		}
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(image, x, y, null);
	}

	public float getPlayerSpeed()
	{
		xSpeed = Clock.delta() * 5;
		return xSpeed;
	}

	public void kill()
	{
		playerState = new PlayerDieState(this);
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

}