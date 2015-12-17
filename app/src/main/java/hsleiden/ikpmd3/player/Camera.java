package hsleiden.ikpmd3.player;

import java.util.ArrayList;

import hsleiden.ikpmd3.map.Tile;

/**
 * This class is the camera of the player.
 * The camera moves all the tiles instead of the player to create a camera effect.
 * @author  Richard Jongenburger
 */

public class Camera {

	private ArrayList<Tile> tiles;

	public Camera(ArrayList<Tile> tiles)
	{
		this.tiles = tiles;
	}

	/**
	 * This method moves all the tiles on their x-as.
	 * @param xToMove The x units to move.
	 */
	public void moveTiles(int xToMove)
	{
		for(Tile tile : tiles)
		{
			tile.moveTileLeft(xToMove);
		}
	}
}
