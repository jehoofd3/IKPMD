package hsleiden.ikpmd3.player;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.utility.Utility;

public class PlayerDieState extends PlayerState
{

    public PlayerDieState(Player player)
    {
        super(player);

        player.health--;
        player.ySpeed = 5;

		Bitmap spriteSheet = BitmapFactory.decodeResource(context.getResources(), R.drawable.player_death_spritesheet);
		int numFrames = 7;
		int imageWidth = player.getImageWidth();
		int imageHeight = player.getImageHeight();

		Bitmap[] frames = Utility.getBitmapArrayFromSpriteSheet(numFrames, spriteSheet, imageWidth, imageHeight);

		super.animation = new Animation();
		super.animation.setFrames(frames);
		super.animation.setDelay(60);
    }

    public void update()
    {
		animation.update();
        player.y -= player.ySpeed;
        player.ySpeed -= 0.4;

        if(player.getY() >= Utility.GAME_HEIGHT)
        {
            player.state = new PlayerNormalState(player);
        }

        if(animation.getPlayedOnce())
        {
            player.state = new PlayerNormalState(player);
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animation.getImage(), player.x, player.y, null);
    }
}
