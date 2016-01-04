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
        }
    }
    public Bitmap getImage(){
        return frames[currentFrame];
    }

    public int getFrame(){
        return currentFrame;
    }
}