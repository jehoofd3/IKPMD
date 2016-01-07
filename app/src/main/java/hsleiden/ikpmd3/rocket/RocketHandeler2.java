//package hsleiden.ikpmd3.rocket;
//
//import android.graphics.Canvas;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//public class RocketHandeler2 {
//
//	private static List<Rocket> rockets = new ArrayList<>();
//
//	// We use a iterator so that we can remove rockets while iterating.
//	Iterator<Rocket> rocketIterator;
//
//	public RocketHandeler2() {
//	}
//
//	public void add(Rocket rocket)
//	{
//		rockets.add(rocket);
//	}
//
//	public void remove()
//	{
//
//		if(rocketIterator != null)
//		{
//			rocketIterator.remove();
//		}
//	}
//
//	public void update()
//	{
//		rocketIterator = rockets.iterator();
//		while (rocketIterator.hasNext()) {
//			Rocket rocket = rocketIterator.next(); // must be called before you can call rocketIterator.remove()
//			rocket.update();
//		}
//
//	}
//
//	public void draw(Canvas canvas)
//	{
//		for(Rocket rocket : rockets)
//		{
//			rocket.draw(canvas);
//		}
//	}
//
//	public static List<Rocket> getRockets()
//	{
//		return rockets;
//	}
//}
//
//
//
