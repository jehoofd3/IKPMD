package hsleiden.ikpmd3.helpers;

import hsleiden.ikpmd3.player.Player;
import hsleiden.ikpmd3.utility.Utility;

/**
 * Created by jeroen_van_ottelen on 28-12-15.
 */
public class Collider
{
    private Player player;

    public Collider(Player player)
    {
        this.player = player;
    }

    public void update()
    {

        // 256 veranderen
        if(player.getY() >= Utility.GAME_HEIGHT ||
                (player.getY() + 256) <= 0)
        {
            player.kill();
        }


    }

}
