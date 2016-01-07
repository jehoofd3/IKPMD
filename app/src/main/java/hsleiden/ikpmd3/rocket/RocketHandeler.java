package hsleiden.ikpmd3.rocket;

import android.graphics.Canvas;
import android.os.Debug;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RocketHandeler {

	private static List<Rocket> rockets = new ArrayList<>();

	public RocketHandeler() {
	}

	public void add(Rocket rocket)
	{
		rockets.add(rocket);
	}

	public void remove(Rocket rocket)
	{
		rockets.remove(rocket);
	}

	public void update()
	{
		List<Rocket> copyList = new ArrayList<>(rockets);
		for (Rocket rocket : copyList){
			rocket.update();
			if (rocket.state instanceof RocketExplodeState){
				if(rocket.state.animation.getPlayedOnce())
					remove(rocket);
			}
		}
	}

	public void draw(Canvas canvas)
	{
		for(Rocket rocket : rockets)
		{
			rocket.draw(canvas);
		}
	}

	public static List<Rocket> getRockets()
	{
		return rockets;
	}
}



