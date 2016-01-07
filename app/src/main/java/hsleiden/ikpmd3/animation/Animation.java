package hsleiden.ikpmd3.animation;
import android.graphics.Bitmap;

/**
 * @author Internet
 */

public class Animation {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce = false;

    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }
    public void setDelay(long d) {
        delay = d;
    }

    public void setFrame(int i) {
        currentFrame= i;
    }

    public void update()
    {
        long elapsed = (System.nanoTime() - startTime) / 1000000;

        if(elapsed > delay)
        {
            currentFrame++;
            startTime = System.nanoTime();
        }
        if(currentFrame == frames.length){
            currentFrame = 0;
            playedOnce = true;
        }
    }
    public Bitmap getImage(){
        return frames[currentFrame];
    }

    public int getFrame(){
        return currentFrame;
    }

    public boolean getPlayedOnce()
    {
        return playedOnce;
    }

    public void setPlayedOnce(boolean playedOnce)
    {
        this.playedOnce = playedOnce;
    }
}