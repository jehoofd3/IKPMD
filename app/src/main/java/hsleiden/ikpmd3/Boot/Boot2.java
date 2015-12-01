package hsleiden.ikpmd3.Boot;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import hsleiden.ikpmd3.Helpers.Artist;
import hsleiden.ikpmd3.LevelStateManager.Level1Activity;
import hsleiden.ikpmd3.LevelStateManager.LevelStateManager;

public class Boot2 extends SurfaceView
{
    private boolean running;

    private LevelStateManager lsm;

    public Boot2(Context context)
    {
        super(context);
        this.running = true;

        // LevelStateManager initialiseren
        this.lsm = new LevelStateManager();
        this.lsm.setLevel(new Level1Activity(context));


        while(running)
        {
            lsm.update();
            lsm.draw();
        }
    }
    public void setRunning(boolean isRunning)
    {
        running = isRunning;
    }
}