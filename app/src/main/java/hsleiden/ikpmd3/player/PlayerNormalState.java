package hsleiden.ikpmd3.player;

/**
 * Created by jeroen_van_ottelen on 24-12-15.
 */
public class PlayerNormalState extends PlayerState
{

    public PlayerNormalState(Player player)
    {
        super(player);

        player.x = player.startX;
        player.y = player.startY;
        player.ySpeed = 0;
    }

    public void update()
    {

        //player.x += player.xSpeed;
        player.y -= player.ySpeed;

        player.ySpeed -= 0.4;

        if(player.touchInput)
        {
            player.ySpeed = 10;
        }

    }

}
