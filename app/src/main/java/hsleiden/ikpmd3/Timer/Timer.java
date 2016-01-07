package hsleiden.ikpmd3.Timer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.TimerTask;

/**
 * Created by jeroen_van_ottelen on 30-12-15.
 */
public class Timer
{
    private static Timer _instance = null;

    private java.util.Timer timer;
    private int minutes, seconds, milliSeconds;
    private boolean isDone = false;
    private Paint paint;
    private String time;

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

    public void setTime(int minutes, int seconds)
    {
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public void draw(Canvas canvas)
    {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setTextSize(40);

        if(minutes == 0)
        {
            time = Integer.toString(seconds) + ":" + Integer.toString(milliSeconds);
        } else {
            time = Integer.toString(minutes) + ":" +
                    Integer.toString(seconds) + ":" +
                    Integer.toString(milliSeconds);
        }

        canvas.drawText(time, 10, 40, paint);
    }

    private TimerTask getTimerTask()
    {
        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {

                if(milliSeconds <= 0)
                {
                    seconds--;
                    milliSeconds = 10;
                }

                if(seconds <= 0)
                {
                    minutes--;
                    seconds = 60;
                }

                milliSeconds--;

                if(minutes == 0)
                {
                    if(seconds == 0)
                    {
                        if(milliSeconds == 0)
                        {
                            stop();
                            isDone = true;
                        }
                    }
                }

            }
        };

        return timerTask;
    }

    public int getMinutes()
    {
        return minutes;
    }

    public int getSeconds()
    {
        return seconds;
    }

    public int getMilliSeconds()
    {
        return milliSeconds;
    }
}
