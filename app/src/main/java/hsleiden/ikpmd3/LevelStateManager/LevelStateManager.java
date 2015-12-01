package hsleiden.ikpmd3.LevelStateManager;

import android.graphics.Canvas;

public class LevelStateManager
{

    private LevelState level;

    public LevelStateManager()
    {
    }

    public void update()
    {
        level.update();
    }

    public void draw()
    {
        level.draw();
    }

    public void setLevel(LevelState level)
    {
        this.level = level;
    }
}
