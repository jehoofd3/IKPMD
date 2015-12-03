package hsleiden.ikpmd3.Helpers;

<<<<<<< Updated upstream
public class Artist {
=======
import android.content.Context;
import android.graphics.Canvas;

import android.content.Context;
import android.graphics.Canvas;

public class Artist
{
>>>>>>> Stashed changes
    private static Artist ourInstance = new Artist();

    private Context context;
    private Canvas canvas;
    private float width, height;

    public static Artist getInstance()
    {
        return ourInstance;
    }

    private Artist()
    {
        this.canvas = new Canvas();
    }

    public void setContext(Context context)
    {
        this.context = context;
    }

    public Context getContext()
    {
        return this.context;
    }
}
