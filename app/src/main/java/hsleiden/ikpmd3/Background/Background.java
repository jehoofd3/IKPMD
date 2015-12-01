package hsleiden.ikpmd3.Background;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import hsleiden.ikpmd3.LevelStateManager.LevelState;

public class Background
{

	private Bitmap image;

	public Background(Bitmap image)
	{
		this.image = image;
	}

	public void update()
	{
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(image , 0 , 0 , null);
	}
}
