package hsleiden.ikpmd3.Timer;

import java.util.TimerTask;

/**
 * Created by jeroen_van_ottelen on 30-12-15.
 */
public class Timer
{
    private static Timer _instance = null;

    private java.util.Timer timer;
    private int minutes, seconds, milliSeconds;

    private Timer ()
    {
        timer = new java.util.Timer();
    }

    private synchronized static void createInstance ()
    {
        if (_instance == null)
        {
            _instance = new Timer ();
        }
    }

    public static Timer getInstance ()
    {
        if (_instance == null)
        {
            createInstance ();
        }

        return _instance;
    }

    public void start()
    {
        timer.schedule(getTimerTask(), 0, 100);
    }

    public void stop()
    {
        timer.cancel();
        timer = new java.util.Timer();
    }

    public void reset()
    {
        this.minutes = 0;
        this.seconds = 0;
        this.milliSeconds = 0;
    }

    public int[] getTime()
    {
        int[] time = new int[3];
        time[0] = minutes;
        time[1] = seconds;
        time[2] = milliSeconds;

        return time;
    }

    private TimerTask getTimerTask()
    {
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                milliSeconds++;

                if(milliSeconds >= 10)
                {
                    seconds++;
                    milliSeconds = 0;
                }

                if(seconds >= 60)
                {
                    minutes++;
                    seconds = 0;
                }
            }
        };

        return timerTask;
    }
}
