package game.nidhi.roachkiller;

import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.SoundPool;

public class Assets {
    static Bitmap background;
    static Bitmap foodbar;
    static Bitmap roach1;
    static Bitmap roach2;
    static Bitmap roach3;
    static Bitmap ladyroach;
    static Bitmap  superroach;

    // States of the Game Screen
    enum GameState {
        GettingReady,	// play "get ready" sound and start timer, goto next state
        Starting,		// when 3 seconds have elapsed, goto next state
        Running, 		// play the game, when livesLeft == 0 goto next state
        GameEnding,	    // show game over message
        GameOver,
        // game is over, wait for any Touch and go back to title activity screen
    };
    static GameState state;		// current state of the game
    static float gameTimer;	    // in seconds
    static int livesLeft;
    static float notifyCallTime;
    static float waitCallTime;

    public static MediaPlayer mp;
    static SoundPool soundPool;
    static int sound_getready;
    static int sound_squish;
    static int sound_squish1;
    static int sound_squish2;
    static int sound_squish3;
    static int sound_thump;
    static int sound_ladybugeath;
    static int sound_squish_super;
    static int sound_high_score;
    static int score;
    public static int touch_count = 0;

    //static int sound_background;
    static String scorenow = "Score: 0 ";

    static Bug bug1,bug2,bug3;
    static LadyBug lady_bug;
    static SuperBug super_bug;// try using an array of bugs instead of only 1 bug (so you can have more than 1 on screen at a time)
}
