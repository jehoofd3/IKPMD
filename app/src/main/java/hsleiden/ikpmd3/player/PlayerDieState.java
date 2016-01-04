package hsleiden.ikpmd3.player;

import hsleiden.ikpmd3.utility.Configuration;

/**
 * Created by jeroen_van_ottelen on 28-12-15.
 */
public class PlayerDieState extends PlayerState
{

    public PlayerDieState(Player player)
    {
        super(player);

        player.health--;

        player.ySpeed = 5;
    }

    public void update()
    {
        player.y -= player.ySpeed;
        player.ySpeed -= 0.4;

        if(player.getY() >= Configuration.GAME_HEIGHT)
        {
            player.state = new PlayerNormalState(player);
        }
    }
}
