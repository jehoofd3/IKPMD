package hsleiden.ikpmd3.player;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.helpers.Clock;
import hsleiden.ikpmd3.utility.Utility;

public class PlayerNormalState extends PlayerState
{
	private int bulletXOffset = player.getImageWidth() - 60;
	private int bulletYOffset = (player.getImageHeight() / 2) + 10;

	private BulletHandeler bulletHandeler = player.getBulletHandeler();

    public PlayerNormalState(Player player)
    {
        super(player);

        player.x = player.startX;
        player.y = player.startY;
        player.ySpeed = 0;

		createPlayerAnimation();
    }

    public void update()
    {
        animation.update();

		if(player.canShoot)
		{
			if(player.getNumberOfBullets() > 0)
			{
					bulletHandeler.add(new Bullet(player.getX() + bulletXOffset, player.getY() + bulletYOffset, 17));
					player.setNumberOfBullets(player.getNumberOfBullets() - 1);
					player.canShoot = false;
			}
		}

        player.x += player.xSpeed;
        player.y -= player.ySpeed;

        player.ySpeed -= 0.4;

		if(player.touchInput)
		{
			player.ySpeed += Clock.delta() * 5;
		}
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), player.x, player.y, null);
    }

	public void createPlayerAnimation()
	{
		// Player fly animation
		Bitmap spriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.player_spritesheet);
		int numFrames = 7;
		int imageWidth = player.getImageWidth();
		int imageHeight = player.getImageHeight();

		Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, spriteSheet, imageWidth, imageHeight);

		super.animation = new Animation();
		super.animation.setFrames(frames);
		super.animation.setDelay(60);
	}

	public void createShootAnimation()
	{
		// Player fly animation
		Bitmap spriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.player_fire_spritesheet);
		int numFrames = 5;
		int imageWidth = player.getImageWidth();
		int imageHeight = player.getImageHeight();

		Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, spriteSheet, imageWidth, imageHeight);

		super.animation = new Animation();
		super.animation.setFrames(frames);
		super.animation.setDelay(60);
	}
}
