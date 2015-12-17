package hsleiden.ikpmd3.levelLoader;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class is used to load a level from a .txt file into a multidimensional array.
 *
 * The .txt file must consist of numbers that corresponds to the image name that is gonna be used.
 *
 * @author Richard Jongenburger
 */

public class LevelLoader {

	private Context context;

	public LevelLoader(Context context)
	{
		this.context = context;
	}


	/**
	 * This method does the following steps:
	 * - Open a .txt file.
	 * - Loop through it.
	 * - Read the number and put that number in a multidimensional array.
	 *
	 * @param location The location of the .txt file.
	 * @return A multidimensional array that corresponds to the images of the map.
	 */
	public int[][] loadLevel(String location)
	{
		// Number of rows and columns the map consist of.
		final int TILE_ROWS = 20;
		final int TILE_COLUMNS = 60;
		final int TOTAL_TILES = TILE_COLUMNS * TILE_ROWS;

		// Get the assets in the asset folder.
		AssetManager assetManager = context.getAssets();

		// Array with with and height of the map.
		// In the array comes numbers which represent the image_names.
		int[][] map = new int[TILE_ROWS][TILE_COLUMNS];

		try {
			// Open the txt file.
			InputStream inputStream = assetManager.open(location);
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			String line;

			int row = 0;
			int column = 0;
			int count = 0;

			// Loop through evey line of the txt file and fill the array.
			while((line = reader.readLine()) != null &&  count < TOTAL_TILES)
			{
				map[row][column] = Integer.parseInt(line);

				// Increase column with 1.
				column++;

				// When the column is 60, go to the next row.
				if(((column) % 60) == 0)
				{
					row++;
					column = 0;
				}

				count++;
			}


		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return map;
	}
}
