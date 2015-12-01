package hsleiden.ikpmd3.LevelStateManager;

import android.graphics.Canvas;

import java.util.Stack;

public class LevelStateManager
{

    private LevelState level;

    public LevelStateManager()
    {
        //this.level = new MenuState();
    }

    public void update()
    {
        level.update();
    }

    public void draw(Canvas canvas)
    {
        level.draw(canvas);
    }

    public void setLevel(LevelState level)
    {
        this.level = level;
    }
}
