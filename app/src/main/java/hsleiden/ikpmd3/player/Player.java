package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.helpers.Clock;
import hsleiden.ikpmd3.utility.Utility;

/**
 *
 * @author Jeroen van Ottelen
 */

public class Player
{

	public int x, y, startX, startY, health;
	public Bitmap spriteSheet;
	public Bitmap[] healthImages;
	public float xSpeed, ySpeed;
	public boolean touchInput;

	public PlayerState state;
	private Animation animation = new Animation();


	public Player(int x, int y, int health, Bitmap spriteSheet, int numFrames, Bitmap[] healthImages)
	{
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.health = health;
		this.spriteSheet = spriteSheet;
		this.healthImages = healthImages;

		this.xSpeed = 20;
		this.ySpeed = 0;

		state = new PlayerNormalState(this);

		Bitmap[] image = new Bitmap[numFrames];

		for(int i = 0 ; i < image.length ; i++)
		{
			image[i] = Utility.scaleBitmap(Bitmap.createBitmap(spriteSheet, 0, i * 256, 256, 256));
		}

		animation.setFrames(image);
		animation.setDelay(60);
	}

	public void update()
	{
		animation.update();
		state.update();;
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(animation.getImage(), x, y, null);

		if(health >= 1)
		{
			canvas.drawBitmap(healthImages[health - 1], Utility.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
		} else
		{
			canvas.drawBitmap(healthImages[0], Utility.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
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