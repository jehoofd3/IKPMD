package hsleiden.ikpmd3.player;

import android.content.Context;
import android.graphics.Canvas;

import hsleiden.ikpmd3.animation.Animation;
import hsleiden.ikpmd3.boot.MainActivity;

/**
 * Created by jeroen_van_ottelen on 24-12-15.
 */
public abstract class PlayerState
{
    protected Player player;
    protected Context context = MainActivity.getContext();
    protected Animation animation;

    public PlayerState(Player player)
    {
        this.player = player;
    }

    public abstract void update();

    public abstract void draw(Canvas canvas);
}
