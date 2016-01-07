package hsleiden.ikpmd3.rocket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.player.BulletHandeler;
import hsleiden.ikpmd3.utility.Utility;

public class RocketNormalState extends RocketState
{
    private int rocketSpeed = 10;
    private int imageWidth;
    private int imageHeight;

    public RocketNormalState(Rocket rocket, int rocketSpeed)
    {
        super(rocket);
        this.rocketSpeed = rocketSpeed;

		Bitmap rocketSpriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.rocket_spritesheet);
		int numFrames = 7;
		this.imageWidth = rocket.getWidth();
		this.imageHeight = rocket.getHeight();

		Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, rocketSpriteSheet, imageWidth, imageHeight);

		super.animation = new Animation();
        super.animation.setFrames(frames);
        super.animation.setDelay(60);
    }

    public void update()
    {
		animation.update();
        rocket.setX(rocket.getX() - rocketSpeed);

        if(rocket.getX() < (0 - imageWidth))
        {
            rocket.explode();
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), rocket.getX(), rocket.getY(), null);
    }
}
