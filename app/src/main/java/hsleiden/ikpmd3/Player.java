package hsleiden.ikpmd3;
import android.graphics.Bitmap;
import android.graphics.Canvas;

import hsleiden.ikpmd3.Animation.Animation;

public class Player {
	private Bitmap spritesheet;
	private int score;

	private boolean up;
	private boolean playing;
	private Animation animation = new Animation();
	private long startTime;

	public Player(Bitmap res, int w, int h, int numFrames) {



	}

	public void setUp(boolean b){
		up = b;
	}

	public void update()
	{

	}

	public void draw(Canvas canvas)
	{

	}
}