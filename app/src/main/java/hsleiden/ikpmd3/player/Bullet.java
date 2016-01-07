package hsleiden.ikpmd3.player;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.boot.MainActivity;
import hsleiden.ikpmd3.rocket.RocketExplodeState;
import hsleiden.ikpmd3.rocket.RocketHandeler;
import hsleiden.ikpmd3.rocket.RocketNormalState;
import hsleiden.ikpmd3.rocket.RocketState;
import hsleiden.ikpmd3.utility.Utility;

/**
 *
 * @author Richard Jongenburger
 */

public class Bullet
{

	private int x, y;

	private int imageWidth;
	private int imageHeight;

	private int speed;

	private Animation animation;

	public Bullet(int x, int y, int speed)
	{
		this.x = x;
		this.y = y;

		this.imageWidth = 47;
		this.imageHeight = 15;

		this.speed = speed;

		int numFrames = 3;
		Bitmap spriteSheet = BitmapFactory.decodeResource(MainActivity.getContext().getResources(), R.drawable.player_bullet_spritesheet);
		Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, spriteSheet, imageWidth, imageHeight);

		animation = new Animation();
		animation.setFrames(frames);
		animation.setDelay(60);
	}

	public void update()
	{
		//animation.update();
		x += this.speed;
		animation.update();
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(animation.getImage(), x, y, null);
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