package hsleiden.ikpmd3.helpers;

import java.util.ArrayList;

import hsleiden.ikpmd3.map.Tile;
import hsleiden.ikpmd3.player.Player;
import hsleiden.ikpmd3.utility.Configuration;

/**
 * Created by jeroen_van_ottelen on 28-12-15.
 */
public class Collider
{
    private Player player;
    private ArrayList<Tile> tiles;

    public Collider(Player player, ArrayList<Tile> tiles)
    {
        this.player = player;
        this.tiles = tiles;
    }

    public void update()
    {

        if(player.getY() >= Configuration.GAME_HEIGHT ||
                (player.getY() + Configuration.TILE_HEIGHT) <= 0)
        {
            player.kill();
        }


    }

}
