package hsleiden.ikpmd3.LevelStateManager;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import java.util.logging.Level;


public class ActivityLoop extends Thread
{
    private SurfaceHolder surfaceHolder;
    private LevelState level;
    private boolean running;
    public static Canvas canvas;

    public ActivityLoop()
    {
        super();
    }
    @Override
    public void run()
    {
        try {

        } catch (Exception e)
        {

        }

        while(running) {
            canvas = null;

            //try locking the canvas for pixel editing
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    level.draw(canvas);
                }
            } catch (Exception e) {
            }
            finally{
                if(canvas!=null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){e.printStackTrace();}
                }
            }
        }
    }
    public void setRunning(boolean isRunning)
    {
        running = isRunning;
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void setLevel(LevelState level) {
        this.level = level;
    }
}