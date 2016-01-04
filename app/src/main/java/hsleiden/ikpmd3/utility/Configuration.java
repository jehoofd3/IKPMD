package hsleiden.ikpmd3.utility;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.view.Display;
import android.view.WindowManager;

/**
 * This is simply some configuration variables that many classes use.
 *
 * @author Richard Jongenburger
 */

public class Configuration
{

	// Rows, Columns of the map.
	public final static int ROWS = 7;
	public final static int COLUMNS = 13;

	// Width and height of each tile(image).
	public final static int TILE_HEIGHT = 64;
	public final static int TILE_WIDTH = 64;

	// The width and height of map.
	public final static int GAME_WIDTH = 1280;
	public final static int GAME_HEIGHT = 720;

	public static Bitmap resizedBitmap(Bitmap bm, int newWidth, int newHeight)
	{
		int width = bm.getWidth();
		int height = bm.getHeight();
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// CREATE A MATRIX FOR THE MANIPULATION
		Matrix matrix = new Matrix();
		// RESIZE THE BIT MAP
		matrix.postScale(scaleWidth, scaleHeight);

		// "RECREATE" THE NEW BITMAP
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
		//bm.recycle();

		return resizedBitmap;
	}

}
