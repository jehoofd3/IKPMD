package hsleiden.ikpmd3.player;

/**
 * Created by jeroen_van_ottelen on 24-12-15.
 */
public abstract class PlayerState
{
    protected Player player;

    public PlayerState(Player player)
    {
        this.player = player;
    }

    public abstract void update();
}
