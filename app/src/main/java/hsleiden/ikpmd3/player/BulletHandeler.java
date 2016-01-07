package hsleiden.ikpmd3.player;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hsleiden.ikpmd3.rocket.Rocket;

public class BulletHandeler {

	private static List<Bullet> bullets = new ArrayList<>();

	// We use a iterator so that we can remove bullets while iterating.
	Iterator<Bullet> bulletIterator;

	public BulletHandeler() {
		bullets.clear();
	}

	public void add(Bullet bullet)
	{
		bullets.add(bullet);
	}

	public void remove()
	{
		if(bulletIterator != null)
		{
			bulletIterator.remove();
		}
	}

	public void update()
	{
		bulletIterator = bullets.iterator();
		while (bulletIterator.hasNext()) {
			Bullet bullet = bulletIterator.next(); // must be called before you can call rocketIterator.remove()
			bullet.update();
		}

	}

	public void draw(Canvas canvas)
	{
		for(Bullet bullet : bullets)
		{
			bullet.draw(canvas);
		}
	}

	public static List<Bullet> getbullets()
	{
		return bullets;
	}
}



