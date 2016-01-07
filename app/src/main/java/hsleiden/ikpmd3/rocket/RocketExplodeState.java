package hsleiden.ikpmd3.rocket;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.utility.Utility;

public class RocketExplodeState extends RocketState
{

    public RocketExplodeState(Rocket rocket)
    {
        super(rocket);

        Bitmap rocketExplodeSpriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.rocket_explode_spritesheet);
        int numFrames = 7;
        int imageWidth = rocket.getWidth();
        int imageHeight = rocket.getHeight();

        Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, rocketExplodeSpriteSheet, imageWidth, imageHeight);

        super.animation = new Animation();
        super.animation.setFrames(frames);
        super.animation.setDelay(60);
    }

    public void update()
    {
        animation.update();
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), rocket.getX(), rocket.getY(), null);
    }
}
