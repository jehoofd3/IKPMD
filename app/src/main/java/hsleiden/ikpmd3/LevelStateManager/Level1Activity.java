package hsleiden.ikpmd3.LevelStateManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import hsleiden.ikpmd3.Background.Background;
import hsleiden.ikpmd3.Helpers.Artist;
import hsleiden.ikpmd3.Map.TileGrid;
import hsleiden.ikpmd3.R;


<<<<<<< Updated upstream
public class Level1Activity extends SurfaceView implements SurfaceHolder.Callback, LevelState
=======
public class Level1Activity extends LevelState implements SurfaceHolder.Callback
>>>>>>> Stashed changes
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;

	private Background background;
	private TileGrid tileGrid;
	private ActivityLoop thread;

<<<<<<< Updated upstream
	private Boot thread;
	private Canvas canvas;

	public Level1Activity(Context context)
	{
		super(context);

		this.canvas = getHolder().lockCanvas();

		//add the callback to the surfaceholder to intercept events
=======
	public Level1Activity(Context context, ActivityLoop thread)
	{
		super(context);
		this.thread = thread;
>>>>>>> Stashed changes
		getHolder().addCallback(this);

		//make gamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.test_background));
<<<<<<< Updated upstream
=======

		//we can safely start the game loop
		thread.setRunning(true);
		thread.start();
>>>>>>> Stashed changes
	}

	public void update()
	{

	}

<<<<<<< Updated upstream
	public void draw()
=======
	public void draw(Canvas canvas)
>>>>>>> Stashed changes
	{
		super.draw(canvas);
		final float scaleFactorX = getWidth()/(WIDTH*1.f);
		final float scaleFactorY = getHeight()/(HEIGHT*1.f);

<<<<<<< Updated upstream
		if(canvas!=null)
=======
		if(canvas != null)
>>>>>>> Stashed changes
		{
			System.out.println("---------------------------------------------------NIET NULL");
			final int savedState = canvas.save();
			canvas.scale(scaleFactorX, scaleFactorY);

			background.draw(canvas);

			canvas.restoreToCount(savedState);
		}

	}
	

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){}
}