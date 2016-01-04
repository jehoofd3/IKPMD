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
import hsleiden.ikpmd3.helpers.Collider;
import hsleiden.ikpmd3.player.Player;
import hsleiden.ikpmd3.utility.Utility;

/**
 *  This class creates and handles level 1 of the game.
 * @author Ricahrd Jongenburger
 */

public class Level1Activity extends LevelState implements SurfaceHolder.Callback
{
	public static final int WIDTH = Utility.GAME_WIDTH;
	public static final int HEIGHT = Utility.GAME_HEIGHT;

	private float scaleFactorX;
	private float scaleFactorY;

	private Background background;
	private Player player;
	private Collider collider;

	private ActivityLoop activityLoop;
	private Context context;
	private Timer timer;

	private Canvas canvas;


	public Level1Activity(Context context)
	{
		super(context);
		this.canvas = getHolder().lockCanvas();
		this.context = context;
		
		getHolder().addCallback(this);

		//make gamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.background));

		Bitmap[] healthImages = new Bitmap[3];
		healthImages[0] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.health_1));
		healthImages[1] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.health_2));
		healthImages[2] = Utility.scaleBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.health_3));

		player = new Player(100, 100, 3, BitmapFactory.decodeResource(getResources(),R.drawable.player_spritesheet), 12, healthImages);
//		camera = new Camera(tileGrid.getTiles());
		collider = new Collider(player);

		timer = Timer.getInstance();

		// The scale factors are used to scale the canvas.
		// This is the mobiles width / the width of the game service.
		scaleFactorX = getWidth()/(WIDTH * 1.f);
		scaleFactorY = getHeight()/(HEIGHT * 1.f);
		System.out.println("scaleFactorX: " + scaleFactorX);
		System.out.println("scaleFactorY: " + scaleFactorY);

		//we can safely start the game loop
		activityLoop.setRunning(true);
		activityLoop.start();
	}

	public void update()
	{
		player.update();
		collider.update();
	}

	public void draw(Canvas canvas)
	{
		super.draw(canvas);

		if(canvas != null)
		{
			final int savedState = canvas.save();

			/*
			 * Scale the canvas, so the canvas is adjusted to the
			 * specific mobile with and height this app is running on.
			 */
			//canvas.scale(scaleFactorX, scaleFactorY);

			background.draw(canvas);
			//tileGrid.draw(canvas);
			player.draw(canvas);
			timer.draw(canvas);

			canvas.restoreToCount(savedState);
		}

	}

	public void setActivityLoop(ActivityLoop activityLoop)
	{
		this.activityLoop = activityLoop;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){}

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
}