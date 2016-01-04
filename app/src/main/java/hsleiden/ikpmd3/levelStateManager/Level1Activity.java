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
import hsleiden.ikpmd3.map.TileGrid;
import hsleiden.ikpmd3.player.Camera;
import hsleiden.ikpmd3.player.Player;
import hsleiden.ikpmd3.utility.Configuration;

/**
 *  This class creates and handles level 1 of the game.
 * @author Ricahrd Jongenburger
 */

public class Level1Activity extends LevelState implements SurfaceHolder.Callback
{
	public static final int WIDTH = Configuration.GAME_WIDTH;
	public static final int HEIGHT = Configuration.GAME_HEIGHT;

	private float scaleFactorX;
	private float scaleFactorY;

	private Background background;
	private TileGrid tileGrid;
	private Player player;
	private Camera camera;
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

		//LevelLoader levelLoader = new LevelLoader(context);
		//int[][] map = levelLoader.loadLevel("Level1.txt");
		//tileGrid = new TileGrid(context, WIDTH, map);

		Bitmap[] healthImages = new Bitmap[3];
		healthImages[0] = BitmapFactory.decodeResource(getResources(),R.drawable.health_1);
		healthImages[1] = BitmapFactory.decodeResource(getResources(),R.drawable.health_2);
		healthImages[2] = BitmapFactory.decodeResource(getResources(),R.drawable.health_3);

		player = new Player(100, 100, 3, BitmapFactory.decodeResource(getResources(),R.drawable.player_spritesheet), 12, healthImages);
		//camera = new Camera(tileGrid.getTiles());
		//collider = new Collider(player, tileGrid.getTiles());

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
		//camera.moveTiles(player.getPlayerSpeed());
		player.update();

		//collider.update();
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