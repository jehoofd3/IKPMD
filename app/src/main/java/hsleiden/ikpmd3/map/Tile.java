package hsleiden.ikpmd3.map;

import android.graphics.Bitmap;

/**
 * This object represents a tile in the game.
 * @author Richard Jongenburger
 */

public class Tile {

	private int x, y;
	private Bitmap image;

	public Tile(int x, int y, Bitmap image)
	{
		this.x = x;
		this.y = y;
		this.image = image;
	}

	public void moveTileLeft(float xToMove)
	{
		this.x -= xToMove;
	}

	public int getX()
	{
		return this.x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return this.y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public Bitmap getImage()
	{
		return image;
	}

	public void setImage(Bitmap image)
	{
		this.image = image;
	}
}
