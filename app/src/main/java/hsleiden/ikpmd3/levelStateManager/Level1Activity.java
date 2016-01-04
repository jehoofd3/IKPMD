package hsleiden.ikpmd3.levelStateManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import hsleiden.ikpmd3.R;
import hsleiden.ikpmd3.Timer.Timer;
import hsleiden.ikpmd3.background.Background;
import hsleiden.ikpmd3.player.Player;
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
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background));

		Bitmap[] healthImages = new Bitmap[3];
		healthImages[0] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_1));
		healthImages[1] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_2));
		healthImages[2] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.health_3));

		player = new Player(100, 100, 3, BitmapFactory.decodeResource(getResources(),R.drawable.player_spritesheet), 12, 256, healthImages);

		timer = Timer.getInstance();

		//we can safely start the game loop
		activityLoop.setRunning(true);
		activityLoop.start();
	}

	public void update()
	{
		player.update();
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

			canvas.restoreToCount(savedState);
		}

	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{

		if(event.getAction()==MotionEvent.ACTION_DOWN){

			player.touchInput = true;
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