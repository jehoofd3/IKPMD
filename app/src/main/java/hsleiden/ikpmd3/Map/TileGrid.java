package hsleiden.ikpmd3.Map;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class TileGrid
{
	private int rows = 10;
	private int columns = 60;

	private Tile[][] tiles = new Tile[rows][columns];

	private int[][] map;

	public TileGrid(int[][] map)
	{
		this.map = map;
		createTiles();
	}

	private void createTiles()
	{
		for(int row = 0 ; row < tiles.length ; row++)
		{
			for (int column = 0 ; column < tiles.length ; column++)
			{
				//tiles[row][column] = new Tile(64 * column, 64 * row, );
			}
		}
	}

	public void draw(Canvas canvas)
	{
		for(Tile[] tilesArray : tiles)
		{
			for (Tile tile : tilesArray)
			{
				if(tile != null)
					canvas.drawBitmap(tile.getImage(), tile.getX(), tile.getY(), null);
			}
		}
	}

}
