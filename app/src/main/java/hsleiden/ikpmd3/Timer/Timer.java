package hsleiden.ikpmd3.Timer;

import java.util.TimerTask;

/**
 * Created by jeroen_van_ottelen on 30-12-15.
 */
public class Timer
{

    private java.util.Timer timer;
    private TimerTask timerTask;
    private int minutes, seconds, milliSeconds;

    public Timer()
    {
        timer = new java.util.Timer();

        timerTask = new TimerTask()
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

    }

    public void start()
    {
        timer.schedule(timerTask, 0, 100);
    }

    public void stop()
    {
        timer.cancel();
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
}
