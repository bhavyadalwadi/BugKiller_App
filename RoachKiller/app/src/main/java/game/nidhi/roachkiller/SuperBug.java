package game.nidhi.roachkiller;

import android.graphics.Canvas;

import game.nidhi.roachkiller.Assets;
import game.nidhi.roachkiller.SuperBug.SuperBugState;


public class SuperBug {

    // States of a Bug
    enum SuperBugState {
        Dead,
        ComingBackToLife,
        Alive,
        DrawDead,
    };

    SuperBugState state;
    int x,y;
    int tox, toy;
    float dirx, diry;
    double speed;

    float timeToBirth;
    float startBirthTimer;
    float deathTime;
    float animateTimer;


    public SuperBug () {
        state = SuperBugState.Dead;
    }


    public void birth (Canvas canvas) {

        if (state == SuperBugState.Dead) {
            state = SuperBugState.ComingBackToLife;
            timeToBirth = 20;
            startBirthTimer = System.nanoTime() / 1000000000f;
        }

        else if (state == SuperBugState.ComingBackToLife) {
            float curTime = System.nanoTime() / 1000000000f;
            if (curTime - startBirthTimer >= timeToBirth) {
                state = SuperBugState.Alive;
                x = (int)(Math.random() * canvas.getWidth());
                if (x < Assets.superroach.getWidth()/2)
                    x = Assets.superroach.getWidth()/2;
                else if (x > canvas.getWidth() - Assets.superroach.getWidth()/2)
                    x = canvas.getWidth() - Assets.superroach.getWidth()/2;
                y = 0;
                speed = canvas.getHeight() /4;
                animateTimer = curTime;
            }
        }
    }

    public void move (Canvas canvas) {
        if (state == SuperBugState.Alive) {

            float curTime = System.nanoTime() / 1000000000f;
            float elapsedTime = curTime - animateTimer;
            animateTimer = curTime;
            x += (dirx * speed * elapsedTime);
            y += (diry * speed * elapsedTime);
            //y += (speed * elapsedTime);
            canvas.drawBitmap(Assets.superroach, x,  y, null);
            if (y >= canvas.getHeight()) {
                state = SuperBugState.Dead;
                Assets.livesLeft--;
            }
            else if (y >= toy) {
                // Ccmpute a to location
                tox = (int)(Math.random() * canvas.getWidth());
                toy = (int)(Math.random() * (canvas.getHeight()-y-1) + y-1 );
                // Compute the direction the bug is moving
                dirx = tox - x;
                diry = toy - y;
                // Compute the length of this direction vector
                float len = (float)(Math.sqrt(dirx * dirx + diry * diry));
                // Normalize this direction vector
                dirx /= len;
                diry /= len;
            }
        }
    }


    public boolean touched_superbug (Canvas canvas, int touchx, int touchy) {
        boolean touched = false;
        if (state == SuperBugState.Alive) {
            float dis = (float)(Math.sqrt ((touchx - x) * (touchx - x) + (touchy - y) * (touchy - y)));
            if (dis <= Assets.superroach.getWidth()*0.75f) {
                Assets.touch_count++;
                if (Assets.touch_count<4) {
                    return false;
                }

                else {
                    state = SuperBugState.DrawDead;
                    touched = true;
                    deathTime = System.nanoTime() / 1000000000f;
                    Assets.touch_count=0;
                }
            }
        }
        return (touched);
    }

    public void drawDead (Canvas canvas) {
        if (state == SuperBugState.DrawDead) {
            canvas.drawBitmap(Assets.roach3, x,  y, null);
            float curTime = System.nanoTime() / 1000000000f;
            float timeSinceDeath = curTime - deathTime;
            if (timeSinceDeath > 4)
                state = SuperBugState.Dead;
        }
    }
}