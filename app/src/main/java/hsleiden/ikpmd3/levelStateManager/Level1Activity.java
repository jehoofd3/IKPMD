package hsleiden.ikpmd3.levelStateManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

import java.util.TimerTask;

import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.Timer.Timer;
import hsleiden.ikpmd3.background.Background;
import hsleiden.ikpmd3.helpers.Clock;
import hsleiden.ikpmd3.player.Player;
import hsleiden.ikpmd3.rocket.Rocket;
import hsleiden.ikpmd3.rocket.RocketHandeler;
import hsleiden.ikpmd3.utility.Utility;

/**
 *  This class creates and handles level 1 of the game.
 * @author Ricahrd Jongenburger
 */

public class Level1Activity extends LevelState implements SurfaceHolder.Callback
{
	private Background background;
	private Player player;

	private ActivityLoop activityLoop;
	private Timer timer;

	private RocketHandeler rocketHandeler;

	private int timeNextRocket = 1800;
	private int rocketSpeed = 10;
	private int rocketSpeedAfterMinute = 19;

	public Level1Activity(Context context)
	{
		super(context);

		getHolder().addCallback(this);

		//make gamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background2));

		Bitmap[] healthImages = new Bitmap[3];
		healthImages[0] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_1));
		healthImages[1] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_2));
		healthImages[2] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_3));

		player = new Player(100, 100, 3, 256, 256, healthImages);

		timer = Timer.getInstance();
		timer.setTime(2, 0);
		timer.start();

		rocketHandeler = new RocketHandeler();

		// Spawn a rocket every timeNexRocket milliseconds.
		java.util.Timer timer = new java.util.Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				rocketHandeler.add(new Rocket(1020, (int) (Math.random() * 607), rocketSpeed, 300, 113));
			}
		}, 0, timeNextRocket);

		//we can safely start the game loop
		activityLoop.setRunning(true);
		activityLoop.start();
	}

	public void update()
	{
		player.update();

		Clock.getTime();

		rocketHandeler.update();

		if(timer.getMinutes() == 0)
		{
			rocketSpeed = rocketSpeedAfterMinute;
		}

		if(player.health == 1)
		{
		}

	}

	public void draw(Canvas canvas)
	{
		super.draw(canvas);

		if(canvas != null)
		{
			final int savedState = canvas.save();

			background.draw(canvas);
			player.draw(canvas);
			timer.draw(canvas);
			rocketHandeler.draw(canvas);

			canvas.restoreToCount(savedState);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{

		if(event.getAction()==MotionEvent.ACTION_DOWN){

			if(event.getX() <= (Utility.GAME_WIDTH / 2))
			{
				player.touchInput = true;
			}

			if(event.getX() >= (Utility.GAME_WIDTH / 2))
			{
				player.canShoot = true;
			}

			return true;
		}
		if(event.getAction()==MotionEvent.ACTION_UP)
		{
			player.touchInput = false;
			return true;
		}

		return super.onTouchEvent(event);
	}

	public void setActivityLoop(ActivityLoop activityLoop)
	{
		this.activityLoop = activityLoop;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){}
}