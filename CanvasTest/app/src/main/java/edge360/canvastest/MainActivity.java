package edge360.canvastest;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.*;
import android.view.Menu;
import android.widget.LinearLayout;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class MainActivity extends Activity {
    Bitmap bg = Bitmap.createBitmap(480, 800, Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(bg);

    Timer timer;
    TimerTask timerTask;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawEverything();
        startTimer();

        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
        ll.setBackgroundDrawable(new BitmapDrawable(bg));
    }

    /*@Override
    public void onResume() {
        clearCanvas();
    }*/

    public void drawEverything() {
        Paint paint1 = new Paint();
        paint1.setColor(Color.parseColor("#CD5C5C"));

        Paint paint2 = new Paint();
        paint2.setColor(Color.parseColor("GREEN"));

        Paint paint3 = new Paint();
        paint3.setColor((Color.parseColor("BLUE")));

        //Random random = new Random();

        int c1 = (int) (Math.random()*380) + 50;
        canvas.drawRect(50, 50, c1, 200, paint1);

        int c2 = (int) (Math.random()*380) + 50;
        canvas.drawRect(50, 250, c2, 400, paint2);

        int c3 = (int) (Math.random()*380);
        canvas.drawRect(50, 450, c3, 600, paint3);
    }

    public void clearCanvas() {
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
    }

    public void startTimer() {
        timer = new Timer();

        initializeTimerTask();

        timer.schedule(timerTask, 5000);
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            public void run() {
                clearCanvas();
                drawEverything();
            }
        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}