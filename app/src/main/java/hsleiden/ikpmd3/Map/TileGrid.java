package hsleiden.ikpmd3.Map;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;

public class TileGrid {

	private int rows = 10;
	private int columns = 60;

	private ArrayList<Tile> tiles = new ArrayList<>();

	private Bitmap images;

	public TileGrid(Bitmap images)
	{
		this.images = images;

		createTiles();
	}

	private void createTiles()
	{
		for(int i = 0 ; i < 10 ; i ++)
		{
			tiles.add(new Tile(64 * i, 64, images));
		}

		tiles.add(new Tile(64 * 4, 64 * 4, images));
		tiles.add(new Tile(64 * 5, 64 * 4, images));
		tiles.add(new Tile(64 * 5, 64 * 5, images));
		tiles.add(new Tile(64 * 5, 64 * 6, images));
	}

	public void draw(Canvas canvas)
	{
		for(Tile tile : tiles)
		{
			if(tile != null)
				canvas.drawBitmap(tile.getImage(), tile.getX(), tile.getY(), null);
		}
	}

}
