package hsleiden.ikpmd3.helpers;

/**
 * My sukie classs lols
 * @author Jeroen van Ottelen
 */

public class Clock
{
    private static boolean paused = false, first = false;
    public static long lastFrame, totalTime;
    public static float d = 0, multiplier = 1;

    public static long getTime()
    {
        return System.nanoTime() / 1000000;
        //return Sys.getTime() * 1000 / Sys.getTimerResolution();
    }

    //Tijd tussen nu en de tijd van de laatste frame
    public static float getDelta()
    {
        long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta * 0.01f;
    }

    public static float delta()
    {
        if(paused)
        {
            return 0f;
        }
        else
        {
            return d * multiplier;
        }
    }

    public static float totalTime()
    {
        return totalTime;
    }

    public static float getMultiplier()
    {
        return multiplier;
    }

    public static void update()
    {
        if(first)
        {
            d = getDelta();
            totalTime += d;
        }
        else
        {
            d = getDelta();
            d = 0;
            first = true;
        }
    }

    public static void changeMultiplier(int change)
    {
        if(multiplier + change < -1 && multiplier + change > 7)
        {
        }
        else
        {
            multiplier += change;
        }
    }

    public static void pause()
    {
        if(paused)
        {
            paused = false;
        }
        else
        {
            paused = true;
        }
    }
}
