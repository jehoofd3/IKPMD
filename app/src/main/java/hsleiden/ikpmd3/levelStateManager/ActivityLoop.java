package hsleiden.ikpmd3.levelStateManager;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

import hsleiden.ikpmd3.helpers.Clock;

/**
 * This is the game loop of the game. For this game we don't make use of a frame cape.
 * We just run it as fast as possible and use a clock class to normalize.
 *
 * You should use the activity loop like this:
 * First you have to set a level and the surfaceholder of the level.
 * Then you can call the run level to run the level.
 *
 * @author Internet (Source: paymon wang-lotfi youtube channel)
 */

public class ActivityLoop extends Thread
{
    private SurfaceHolder surfaceHolder;
    private LevelState level;

    private boolean running = false;
    private boolean canvasLocked;

    public ActivityLoop()
    {
        super();
    }

    @Override
    public void run()
    {
        Canvas canvas = null;
        while(running) {
            try {
                if (!canvasLocked) {
                    canvas = this.surfaceHolder.lockCanvas(null);
                    canvasLocked = true;
                    synchronized (this.surfaceHolder) {
                        Clock.update();
                        canvas.save();
                        level.update();
                        level.draw(canvas);
                        canvas.restore();
                    }
                }
            } finally {
                if (canvas != null) {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                    canvasLocked = false;
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