package hsleiden.ikpmd3.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hsleiden.ikpmd3.rocket.Rocket;
import hsleiden.ikpmd3.rocket.RocketHandeler;

/**
 * @author Richard Jongenburger
 */

public class Collider {

	private List<Rocket> rockets;

	private Player player;

	public Collider(Player player)
	{
		this.rockets = RocketHandeler.getRockets();
		this.player = player;
	}

	public void update(int playerX, int playerY)
	{
		// We use a iterator so that we can remove rockets while iterating.
		Iterator<Rocket> rocketIterator = rockets.iterator();
		while (rocketIterator.hasNext()) {
			Rocket rocket = rocketIterator.next();

			if((playerX + player.getImageWidth()) >= (rocket.getX()) &&
					(playerX) <= (rocket.getX() + rocket.getWidth()) &&
					(playerY + player.getImageHeight()) >= (rocket.getY()) &&
					(playerY) <= (rocket.getY() + rocket.getHeight()))
			{
				player.kill();
				rocket.explode();
			}
		}
	}


}
