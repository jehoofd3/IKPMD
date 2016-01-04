package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import hsleiden.ikpmd3.Timer.Timer;
import hsleiden.ikpmd3.helpers.Clock;
import hsleiden.ikpmd3.utility.Configuration;

/**
 *
 * @author Jeroen van Ottelen
 */

public class Player
{

	public int x, y, startX, startY, health;
	public Bitmap image;
	public Bitmap[] healthImages;
	public float xSpeed, ySpeed;
	public boolean touchInput;
	public Timer timer;

	public PlayerState state;


	public Player(int x, int y, int health, Bitmap image, Bitmap[] healthImages)
	{
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.health = health;
		this.image = image;
		this.healthImages = healthImages;

		this.xSpeed = 20;
		this.ySpeed = 0;

		timer = Timer.getInstance();

		state = new PlayerNormalState(this);
	}

	public void update()
	{
		state.update();
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(image, x, y, null);

		if(health >= 1)
		{
			canvas.drawBitmap(healthImages[health - 1], Configuration.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
		} else
		{
			canvas.drawBitmap(healthImages[0], Configuration.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
		}

	}

	public float getPlayerSpeed()
	{
		xSpeed = Clock.delta() * 5;
		return xSpeed;
	}

	public void kill()
	{
		if(!(state instanceof PlayerDieState))
		{
			state = new PlayerDieState(this);
		}
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