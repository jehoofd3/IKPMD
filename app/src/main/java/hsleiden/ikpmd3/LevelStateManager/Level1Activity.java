package hsleiden.ikpmd3.LevelStateManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import hsleiden.ikpmd3.Background.Background;
import hsleiden.ikpmd3.Boot.Boot;
import hsleiden.ikpmd3.Map.TileGrid;
import hsleiden.ikpmd3.R;


public class Level1Activity extends SurfaceView implements SurfaceHolder.Callback
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;
	public static final int MOVESPEED = -5;

	private Background background;
	private TileGrid tileGrid;

	private Boot thread;

	public Level1Activity(Context context)
	{
		super(context);

		//add the callback to the surfaceholder to intercept events
		getHolder().addCallback(this);

		thread = new Boot(getHolder(), this);

		//make gamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){
		boolean retry = true;
		int counter = 0;
		while(retry && counter < 1000)
		{
			counter++;
			try{thread.setRunning(false);
				thread.join();
				retry = false;

			} catch(InterruptedException e){e.printStackTrace();}

		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder){
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.test_background));
		tileGrid = new TileGrid(BitmapFactory.decodeResource(getResources(), R.drawable.test_tile));
		//we can safely start the game loop
		thread.setRunning(true);
		thread.start();

	}

	public void update()
	{

	}

	@Override
	public void draw(Canvas canvas)
	{
		super.draw(canvas);
		final float scaleFactorX = getWidth()/(WIDTH*1.f);
		final float scaleFactorY = getHeight()/(HEIGHT*1.f);

		if(canvas!=null) {
			final int savedState = canvas.save();

			background.draw(canvas);
			tileGrid.draw(canvas);

			canvas.restoreToCount(savedState);
		}
	}


}