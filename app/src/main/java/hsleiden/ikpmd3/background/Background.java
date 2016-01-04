package hsleiden.ikpmd3.background;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;

import hsleiden.ikpmd3.utility.Utility;

/**
 * This class draws a background.
 *
 * @author Richard Jongenburger
 */

public class Background
{

	private Bitmap image;

	public Background(Bitmap image)
	{
		this.image = Utility.resizedBitmapFull(image);
	}

	public void draw(Canvas canvas)
	{
		canvas.drawBitmap(image, 0, 0, null);
	}
}
