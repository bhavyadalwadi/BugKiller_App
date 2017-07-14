package game.nidhi.roachkiller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.widget.Toast;
import game.nidhi.roachkiller.Assets;

import java.util.Random;

import static android.support.v4.app.ActivityCompat.startActivity;

public class MainThread extends Thread {
    MenuActivity m;

    private SurfaceHolder holder;
    private Handler handler;
    private boolean isRunning = false;
    Context context;
    Paint paint;
    int touchx, touchy;
    int touch_count = 0;
    boolean touched;
    private static final Object lock = new Object();

    public MainThread (SurfaceHolder surfaceHolder, Context context) {
        holder = surfaceHolder;
        this.context = context;
        handler = new Handler();
        touched = false;
    }

    public void setRunning(boolean b) {
        isRunning = b;
    }


    public void setXY (int x, int y) {
        synchronized (lock) {
            touchx = x;
            touchy = y;
            this.touched = true;
        }
    }

    @Override
    public void run() {
        while (isRunning) {

            Canvas canvas = holder.lockCanvas();
            if (canvas != null) {

                render(canvas);

                holder.unlockCanvasAndPost (canvas);
            }
        }
    }


    private void loadData (Canvas canvas) {
        Bitmap bmp;
        int newWidth, newHeight;
        float scaleFactor;


        paint = new Paint();





        bmp = BitmapFactory.decodeResource (context.getResources(), R.drawable.foodbar);

        newHeight = (int)(canvas.getHeight() * 0.1f);

        Assets.foodbar = Bitmap.createScaledBitmap (bmp, canvas.getWidth(), newHeight, false);

        bmp = null;


        bmp = BitmapFactory.decodeResource (context.getResources(), R.drawable.roach1_250);

        newWidth = (int)(canvas.getWidth() * 0.2f);

        scaleFactor = (float)newWidth / bmp.getWidth();

        newHeight = (int)(bmp.getHeight() * scaleFactor);

        Assets.roach1 = Bitmap.createScaledBitmap (bmp, newWidth, newHeight, false);
        bmp = null;
        bmp = BitmapFactory.decodeResource (context.getResources(), R.drawable.roach2_250);
        newWidth = (int)(canvas.getWidth() * 0.2f);
        scaleFactor = (float)newWidth / bmp.getWidth();
        newHeight = (int)(bmp.getHeight() * scaleFactor);

        Assets.roach2 = Bitmap.createScaledBitmap (bmp, newWidth, newHeight, false);

        bmp = null;

        bmp = BitmapFactory.decodeResource (context.getResources(), R.drawable.roach3_250);

        newWidth = (int)(canvas.getWidth() * 0.2f);

        scaleFactor = (float)newWidth / bmp.getWidth();

        newHeight = (int)(bmp.getHeight() * scaleFactor);

        Assets.roach3 = Bitmap.createScaledBitmap (bmp, newWidth, newHeight, false);

        bmp = null;


        bmp = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ladybug);
        newWidth = (int) (canvas.getWidth() * 0.2f);

        scaleFactor = (float) newWidth / bmp.getWidth();

        newHeight = (int) (bmp.getHeight() * scaleFactor);

        Assets.ladyroach = Bitmap.createScaledBitmap(bmp, newWidth, newHeight,
                false);
        bmp = null;
        bmp = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.superbug);
        newWidth = (int) (canvas.getWidth() * 0.2f);

        scaleFactor = (float) newWidth / bmp.getWidth();

        newHeight = (int) (bmp.getHeight() * scaleFactor);

        Assets.superroach = Bitmap.createScaledBitmap(bmp, newWidth, newHeight,
                false);

        bmp = null;


        Assets.bug1 = new Bug();
        Assets.bug2 = new Bug();
        Assets.bug3 = new Bug();
        Assets.lady_bug = new LadyBug();
        Assets.super_bug = new SuperBug();
    }
    private void loadBackground (Canvas canvas, int resId) {
        Bitmap bmp = BitmapFactory.decodeResource (context.getResources(), resId);

        Assets.background = Bitmap.createScaledBitmap (bmp, canvas.getWidth(), canvas.getHeight(), false);

        bmp = null;
    }

    public void render (Canvas canvas) {
        int i, x, y;

        switch (Assets.state) {
            case GettingReady:

                loadBackground (canvas, R.drawable.scaredperson);

                loadData(canvas);

                canvas.drawBitmap (Assets.background, 0, 0, null);

                Assets.soundPool.play(Assets.sound_getready, 1, 1, 1, 0, 1);

                Assets.gameTimer = System.nanoTime() / 1000000000f;

                Assets.state = Assets.GameState.Starting;
                break;
            case Starting:

                canvas.drawBitmap (Assets.background, 0, 0, null);

                float currentTime = System.nanoTime() / 1000000000f;
                if (currentTime - Assets.gameTimer >= 3) {

                    loadBackground (canvas, R.drawable.clouds);

                    Assets.state = Assets.GameState.Running;

                }
                break;
            case Running:
                canvas.drawBitmap (Assets.background, 0, 0, null);
                paint.setColor(Color.WHITE);
                paint.setTextSize(50);
                canvas.drawText(Assets.scorenow, 30, 50, paint);

                canvas.drawBitmap (Assets.foodbar, 0, canvas.getHeight()-Assets.foodbar.getHeight(), null);
                int radius = (int)(canvas.getWidth() * 0.05f);
                int spacing = 8; // spacing in between circles
                x = canvas.getWidth() - radius - spacing;	// coordinates for rightmost circle to draw
                y = radius + spacing;
                for (i=0; i<Assets.livesLeft; i++) {
                    paint.setColor(Color.GREEN);
                    paint.setStyle(Paint.Style.FILL);
                    canvas.drawCircle(x, y, radius, paint);
                    paint.setColor(Color.BLACK);
                    paint.setStyle(Paint.Style.STROKE);
                    canvas.drawCircle(x, y, radius, paint);
                    x -= (radius*2 + spacing);
                }

                if(Assets.mp == null) {
                    Assets.mp = MediaPlayer.create(context, R.raw.background1);
                }
                Assets.mp.start();
                Assets.mp.setLooping(true);
                if (touched) {

                    touched = false;

                    boolean bugKilled1 = Assets.bug1.touched(canvas, touchx, touchy);
                    if(bugKilled1){
                        Assets.score++;
                        Assets.scorenow ="Score: "+Assets.score;
                    }

                    boolean bugKilled2 = Assets.bug2.touched(canvas, touchx, touchy);
                    if(bugKilled2){
                        Assets.score++;
                        Assets.scorenow ="Score: "+Assets.score;
                    }

                    boolean bugKilled3 = Assets.bug3.touched(canvas, touchx, touchy);
                    if(bugKilled3){
                        Assets.score++;
                        Assets.scorenow ="Score: "+Assets.score;
                    }


                    if (bugKilled1 || bugKilled2 || bugKilled3) {
                        Random randomGen = new Random();
                        int randomInt = randomGen.nextInt(3) + 1;
                        if(randomInt == 1)
                            Assets.soundPool.play(Assets.sound_squish, 1, 1, 1, 0, 1);
                        else if(randomInt == 2)
                            Assets.soundPool.play(Assets.sound_squish2, 1, 1, 1, 0, 1);
                        else if(randomInt == 3)
                            Assets.soundPool.play(Assets.sound_squish3, 1, 1, 1, 0, 1);
                    }

                    else
                        Assets.soundPool.play(Assets.sound_thump, 1, 1, 1, 0, 1);

                    boolean ladybugKilled = Assets.lady_bug.touched_ladybug(canvas, touchx, touchy);
                    if(ladybugKilled) {
                        Assets.soundPool.play(Assets.sound_ladybugeath, 1, 1, 1, 0, 1);
                        Assets.state = Assets.GameState.GameEnding;
                    }
                    boolean superbugKilled = Assets.super_bug.touched_superbug(canvas, touchx, touchy);
                    if(superbugKilled) {
                        Assets.soundPool.play(Assets.sound_squish_super, 1, 1, 1, 0, 1);
                        Assets.score = Assets.score + 10;
                        Assets.scorenow ="Score: "+Assets.score;
                    }
                }

                // Draw dead bugs on screen
                Assets.bug1.drawDead(canvas);
                Assets.bug2.drawDead(canvas);
                Assets.bug3.drawDead(canvas);


                // Move bugs on screen
                Assets.bug1.move(canvas);
                Assets.bug2.move(canvas);
                Assets.bug3.move(canvas);

                // Bring a dead bug to life?
                Assets.bug1.birth(canvas);
                Assets.bug2.birth(canvas);
                Assets.bug3.birth(canvas);

                Assets.lady_bug.drawDead(canvas);
                Assets.lady_bug.move(canvas);
                Assets.lady_bug.birth(canvas);

                Assets.super_bug.drawDead(canvas);
                Assets.super_bug.move(canvas);
                Assets.super_bug.birth(canvas);

                // ADD MORE CODE HERE TO PLAY GAME


                // Are no lives left?
                if (Assets.livesLeft == 0)
                    // Goto next state
                    Assets.state = Assets.GameState.GameEnding;
                break;
            case GameEnding:
                // Show a game over message
                if (Assets.mp != null) {
                    Assets.mp.stop();
                    Assets.mp.release();
                    Assets.mp = null;

                }
                handler.post(new Runnable() {
                    public void run() {
                        Toast.makeText(context, "Game Over", Toast.LENGTH_SHORT).show();
                    }
                });
                // Goto next state
                Assets.state = Assets.GameState.GameOver;
                break;
            case GameOver:
                canvas.drawColor(Color.BLUE);
                SharedPreferences sharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(context);
                int highscore = sharedPreferences.getInt("prefs_highscore", 0);
                if (Assets.score > highscore) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("prefs_highscore", Assets.score);
                    editor.commit();
                    handler.post(new Runnable() {
                        public void run() {
                            Assets.soundPool.play(Assets.sound_high_score, 1, 1, 1, 0, 1);
                            Toast.makeText(context,
                                    "New High Score has been reached",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
                break;
        }
    }
}

