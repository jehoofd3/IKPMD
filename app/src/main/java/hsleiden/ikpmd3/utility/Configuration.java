package hsleiden.ikpmd3.utility;

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
	public final static int GAME_WIDTH = COLUMNS * TILE_WIDTH;
	public final static int GAME_HEIGHT = ROWS * TILE_HEIGHT;
}
