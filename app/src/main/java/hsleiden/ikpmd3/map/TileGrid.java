package hsleiden.ikpmd3.map;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import java.util.ArrayList;
import hsleiden.ikpmd3.utility.Configuration;

/**
 *  This class is use to create an draw a tilegrid. (The map of the game)
 * @author Richard Jongenburger
 */

public class TileGrid {

	private ArrayList<Tile> tiles = new ArrayList<>();

	private final int MOBILE_WIDTH;

	private final int TILE_WIDTH = Configuration.TILE_WIDTH;
	private final int TILE_HEIGHT = Configuration.TILE_HEIGHT;

	private Context context;

	public TileGrid(Context context, int MOBILE_WIDTH, int[][] map)
	{
		this.context = context;
		this.MOBILE_WIDTH = MOBILE_WIDTH;
		createTiles(map);
	}

	/**
	 * Loop through the map multidimensional array.
	 * If the number is not equal to 0, create a tile for it.
	 */
	private void createTiles(int[][] map)
	{
		final int ROWS = Configuration.ROWS;
		final int COLUMNS = Configuration.COLUMNS;
		Bitmap bitmap;

		for(int row = 0 ; row < ROWS ; row++)
		{
			for (int column = 0 ; column < COLUMNS ; column++)
			{
				if(map[row][column] != 0)
				{
					// Get de index of the image in the res directory.
					int imgIndex = context.getResources().getIdentifier("i" + map[row][column], "drawable", context.getPackageName());

					// Load the image.
					bitmap = BitmapFactory.decodeResource(context.getResources(), imgIndex);

					tiles.add(new Tile(column * TILE_WIDTH, row * TILE_HEIGHT, bitmap));
				}
			}
		}
	}

	/**
	 * Draw every tile that should be visible on the mobile screen.
	 * @param canvas The canvas to draw on.
	 */
	public void draw(Canvas canvas)
	{
		for(Tile tile : tiles)
		{
			/* This condition makes sure that we only draw the tiles that
			 * are on the visible x coordinates on the screen.
			 * and that tiles outside screen of the mobile devices aren't drawn.
			 */
			int x = tile.getX();
			if(x > -TILE_WIDTH && x < MOBILE_WIDTH)
				canvas.drawBitmap(tile.getImage(), x, tile.getY(), null);
		}
	}

	public ArrayList<Tile> getTiles()
	{
		return tiles;
	}

}
