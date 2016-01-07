package hsleiden.ikpmd3.utility;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by jeroen_van_ottelen on 04-01-16.
 */
public class Utility
{

    // The width and height of the phone
    public static int GAME_WIDTH = 0;
    public static int GAME_HEIGHT = 0;

    // The width and heidht of the images that we developed them in.
    // The method scaleBitmap use them to calculate the scale factor.
    private static int baseWidth = 1280;
    private static int baseHeight = 720;


    public static Bitmap resizedBitmapFull(Bitmap bm)
    {
        // The width and height of the current bitmap.
        int width = bm.getWidth();
        int height = bm.getHeight();

        // The scale factor for the net bitmap.
        float scaleWidth = ((float) GAME_WIDTH) / width;
        float scaleHeight = ((float) GAME_HEIGHT) / height;

        // create a matrix for the manipulation.
        Matrix matrix = new Matrix();

        // Resize the bitmap.
        matrix.postScale(scaleWidth, scaleHeight);

        // Recreate the new bitmap.
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);

        return resizedBitmap;
    }

    public static Bitmap scaleBitmap(Bitmap bm)
    {
        // The width and height of the current bitmap.
        int width = bm.getWidth();
        int height = bm.getHeight();

        // The scale factor for the net bitmap.
        float scaleWidth = ((float) GAME_WIDTH) / baseWidth;
        float scaleHeight = ((float) GAME_HEIGHT) / baseHeight;

        // create a matrix for the manipulation.
        Matrix matrix = new Matrix();

        // Resize the bitmap.
        matrix.postScale(scaleWidth, scaleHeight);

        // Recreate the new bitmap.
        Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);

        return resizedBitmap;
    }

    public static Bitmap[] getBitmapArrayFromSpriteSheet(int numFrames, Bitmap spriteSheet, int imageWidth, int imageHeight)
    {
        Bitmap[] frames = new Bitmap[numFrames];

        for(int i = 0 ; i < frames.length ; i++)
        {
            frames[i] = scaleBitmap(Bitmap.createBitmap(spriteSheet, 0, i * imageHeight, imageWidth, imageHeight));
        }

        return frames;
    }
}
