package com.example.grequestiontimer;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static long START_TIME_IN_MILLIS = 90000;

    private ProgressBar progressBar;
    private TextView progressText;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private NumberPicker np;
    private Button TickButton;

    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;
    int i = 0, TimeSeconds = 90;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnClickListener();

        updateCountDownText();
    }

    private void initWidgets() {
        progressBar = findViewById(R.id.progress_bar);
        progressText = findViewById(R.id.progress_text);

//        mTextViewCountDown = findViewById(R.id.text_view_countdown);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

        np = findViewById(R.id.numberPicker);
        TickButton = findViewById(R.id.tickbutton);
    }

    private void setOnClickListener() {
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("HELLO", "onClick: Hello");
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });

        TickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("HELLO", "onClick: Hello");
                int selectedValue = (int) np.getValue();
                if(mTimerRunning == true)
                {

                }
                if(mTimerRunning == false)
                {
                    TimeSeconds = Integer.parseInt(Times.getSecondsArrayList().get(selectedValue).getSeconds_Interval());
                    int timetomilli = TimeSeconds * 1000;
                    START_TIME_IN_MILLIS = timetomilli;
                    resetTimer();

                    Log.d("imp", "onValueChange: "+TimeSeconds);
                }
//                NumberPicker.OnValueChangeListener onValueChangeListener =
//                        new NumberPicker.OnValueChangeListener(){
//                            @Override
//                            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
//                                Toast.makeText(MainActivity.this,
//                                        "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT);
//
//                                TimeSeconds = Integer.parseInt(Times.getSecondsArrayList().get(i1).getSeconds_Interval());
//                                Log.d("imp", "onValueChange: "+TimeSeconds);
//                            }
//                        };
            }
        });
    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                mButtonStartPause.setText("Start");
                mButtonStartPause.setVisibility(View.INVISIBLE);
                mButtonReset.setVisibility(View.VISIBLE);
            }
        }.start();

        mTimerRunning = true;
        mButtonStartPause.setText("pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }

    private void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
    }

    private void resetTimer() {
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setVisibility(View.VISIBLE);
    }

    private void updateCountDownText() {
        Times.initSeconds();
        np.setMaxValue(Times.getSecondsArrayList().size() -1);
        np.setDisplayedValues(Times.TImeSeconds());
        np.setValue(8);

//        np.setOnValueChangedListener(onValueChangeListener);

        int totalTime = (int) (START_TIME_IN_MILLIS/1000);
        int minutes = (int) (mTimeLeftInMillis / 1000);
        double minutesProgressBardouble = (double) (((totalTime-minutes)*100/totalTime));
        int minutesProgressBar = (int)minutesProgressBardouble;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d", minutes);

//        mTextViewCountDown.setText(timeLeftFormatted);
        progressText.setText("" + (timeLeftFormatted));
        progressBar.setProgress(minutesProgressBar);
    }
}