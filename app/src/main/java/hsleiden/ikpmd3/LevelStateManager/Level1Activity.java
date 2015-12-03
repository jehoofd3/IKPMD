package hsleiden.ikpmd3.LevelStateManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import hsleiden.ikpmd3.Background.Background;
import hsleiden.ikpmd3.Boot.Boot;
import hsleiden.ikpmd3.Helpers.Artist;
import hsleiden.ikpmd3.Map.TileGrid;
import hsleiden.ikpmd3.R;


public class Level1Activity extends SurfaceView implements SurfaceHolder.Callback, LevelState
{
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 640;

	private Background background;
	private TileGrid tileGrid;

	private Boot thread;
	private Canvas canvas;

	public Level1Activity(Context context)
	{
		super(context);

		this.canvas = getHolder().lockCanvas();

		//add the callback to the surfaceholder to intercept events
		getHolder().addCallback(this);

		//make gamePanel focusable so it can handle events
		setFocusable(true);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		background = new Background(BitmapFactory.decodeResource(getResources(), R.drawable.test_background));
	}

	public void update()
	{

	}

	public void draw()
	{

		super.draw(canvas);
		final float scaleFactorX = getWidth()/(WIDTH*1.f);
		final float scaleFactorY = getHeight()/(HEIGHT*1.f);

		if(canvas!=null)
		{
			System.out.println("---------------------------------------------------NIET NULL");
			final int savedState = canvas.save();
			canvas.scale(scaleFactorX, scaleFactorY);

			background.draw(canvas);
			tileGrid.draw(canvas);

			canvas.restoreToCount(savedState);
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder){}
}