package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;

import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.helpers.Clock;

/**
 *
 * @author Jeroen van Ottelen
 */

public class Player
{

	public int x, y;
	public Bitmap spriteSheet;
	public float xSpeed = 20, ySpeed = 0;
	public boolean touchInput;

	private Animation animation = new Animation();

	public PlayerState playerState;


	public Player(int x, int y, Bitmap spriteSheet, int numFrames)
	{
		this.x = x;
		this.y = y;
		this.spriteSheet = spriteSheet;

		Bitmap[] image = new Bitmap[numFrames];

		for(int i = 0 ; i < image.length ; i++)
		{
			image[i] = Bitmap.createBitmap(spriteSheet, 0, i * 512, 512, 512);
		}

		animation.setFrames(image);
		animation.setDelay(60);

		playerState = new PlayerNormalState(this);
	}

	public void update()
	{
		animation.update();

		playerState.update();

		if(touchInput)
		{
			touchInput = false;
		}

	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(animation.getImage(), x, y, null);
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