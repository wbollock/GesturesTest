package wbollock.com.gesturestest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener{

    private TextView buckysMessage; // just a reference to the text placed
    private GestureDetectorCompat gestureDetector;  // object for class that implements gestures

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buckysMessage = (TextView)findViewById(R.id.buckysMessage); // can actually tweak buckysMessage now
        this.gestureDetector = new GestureDetectorCompat(this, this); // allows us to detect gestures
        gestureDetector.setOnDoubleTapListener(this); // allows us to detect double taps as well

        Button bollButton = (Button) findViewById(R.id.boll_button);

        bollButton.setOnClickListener( // sit and wait for someone to click you
                new Button.OnClickListener(){ // interface
                    public void onClick(View v) {
                        TextView buckysMessage = (TextView) findViewById(R.id.buckysMessage); // make a textview variable that corresponds with the id of the object buckystext
                        buckysMessage.setText("You clicked the button!"); // changing the actual text
                    }
                }
        );
    }

    //Gestures
    @Override
    public boolean onDown(MotionEvent motionEvent) {
        buckysMessage.setText("onDown");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
        buckysMessage.setText("onShowPress");

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        buckysMessage.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        buckysMessage.setText("onScroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        buckysMessage.setText("onLongPress");

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        buckysMessage.setText("onFling");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        buckysMessage.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        buckysMessage.setText("onDoubleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        buckysMessage.setText("onDoubleTapEvent");
        return true;
    }

        //End Gestures


        @Override
        public boolean onTouchEvent(MotionEvent event) {
            this.gestureDetector.onTouchEvent(event); // pass through event that was called earlier. first detect if touch was a special type of gesture
            return super.onTouchEvent(event);
        }
}
