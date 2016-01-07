package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

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
	public Bitmap[] healthImages;
	public float xSpeed, ySpeed;
	public boolean touchInput;
	private int imageWidth;
	private int imageHeight;

	public boolean canShoot;
	private int numberOfBullets = 30;

	public PlayerState state;
	private Collider collider;

	private Paint paint;

	private BulletHandeler bulletHandeler = new BulletHandeler();

	public Player(int x, int y, int health, int imageWidth, int imageHeight, Bitmap[] healthImages)
	{
		this.x = x;
		this.y = y;
		this.startX = x;
		this.startY = y;
		this.health = health;
		this.healthImages = healthImages;

		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;

		this.ySpeed = 0;

		collider = new Collider(this);

		state = new PlayerNormalState(this);

		paint = new Paint();
		paint.setColor(Color.WHITE);
		paint.setTextSize(40);
	}

	public void update()
	{
		state.update();
		collider.update(x, y);
		bulletHandeler.update();
	}

	public void draw(Canvas canvas)
	{
		state.draw(canvas);
		bulletHandeler.draw(canvas);

		if(health >= 1)
		{
			canvas.drawBitmap(healthImages[health - 1], Utility.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
		} else
		{
			canvas.drawBitmap(healthImages[0], Utility.GAME_WIDTH - healthImages[0].getWidth(), 0, null);
		}


		canvas.drawText("Bullets: " + numberOfBullets, Utility.GAME_WIDTH - 220, Utility.GAME_HEIGHT - 10, paint);

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

	public int getImageHeight()
	{
		return imageHeight;
	}

	public int getImageWidth()
	{
		return imageWidth;
	}

	public BulletHandeler getBulletHandeler()
	{
		return bulletHandeler;
	}

	public int getNumberOfBullets()
	{
		return numberOfBullets;
	}

	public void setNumberOfBullets(int numberOfBullets)
	{
		this.numberOfBullets = numberOfBullets;
	}
}