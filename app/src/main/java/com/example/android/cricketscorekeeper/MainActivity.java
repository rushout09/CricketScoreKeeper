package com.example.android.cricketscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int run = 0, wickets = 0, over = 0, balls = 0;
    //Button startInningsA;// =(Button) findViewById(R.id.startInningsA);
    //Button startInningsB;// =(Button) findViewById(R.id.startInningsB);
    TextView scoreA;//= (TextView) findViewById(R.id.scoreA);
    TextView scoreB;// = (TextView) findViewById(R.id.scoreB);
    TextView oversA;//= (TextView) findViewById(R.id.oversA);
    TextView oversB;// = (TextView) findViewById(R.id.oversB);
    EditText runs;//= (EditText) findViewById(R.id.runs);
    Boolean A = true;
    public void endInnings(View view)
    {
        if(!A) {
            reset(view);
        }
        else {
            A = false;
            run = 0;
            wickets = 0;
            over = 0;
            balls = 0;
            Button end = (Button) findViewById(R.id.endInnings);
            end.setText("End 2nd Inninigs");
        }
    }
    public void submitRuns(View view)
    {
        runs = (EditText) findViewById(R.id.runs);
        run = run + Integer.parseInt(runs.getText().toString());
        balls++;
        if(balls>6)
        {
            balls = 0;
            over++;
        }
        if(A) {
            setScoreA();
            setOversA();
        }
        else {
            setScoreB();
            setOversB();
        }

    }
    public void submitWide(View view)
    {
        EditText wide = (EditText) findViewById(R.id.wides);
        run = run + Integer.parseInt(wide.getText().toString());
        if(A) {
            setScoreA();
        }
        else {
            setScoreB();
        }

    }
    public void submitWickets(View view)
    {
        balls++;
        if(balls>6)
        {
            balls = 0;
            over++;
        }
        if (wickets<10)
        wickets++;
        else
        {
            if(A)
            {
                endInnings(view);
            }

            else
            {
                Button end = (Button) findViewById(R.id.endInnings);
                end.setText("Reset");
                LinearLayout editor = (LinearLayout) findViewById(R.id.editor);
                editor.setVisibility(view.INVISIBLE);
            }
        }
        if(A)
        {
            setOversA();
            setScoreA();
        }
        else {
            setScoreB();
            setOversB();
        }
    }
    public void setOversA()
    {
        oversA = (TextView) findViewById(R.id.oversA);
        oversA.setText(over+"."+balls);
    }
    public void setOversB()
    {
        oversB = (TextView) findViewById(R.id.oversB);
        oversB.setText(over+"."+balls);
    }
    public void setScoreA() {
        scoreA = (TextView) findViewById(R.id.scoreA);
        scoreA.setText(run+"/"+wickets);
    }
    public void setScoreB() {
        scoreB = (TextView) findViewById(R.id.scoreB);
        scoreB.setText(run+"/"+wickets);
    }
    public void reset(View view)
    {
        run = 0;
        wickets = 0;
        over = 0;
        balls = 0;
        A = true;
        setOversA();
        setOversB();
        setScoreA();
        setScoreB();
        LinearLayout editor = (LinearLayout) findViewById(R.id.editor);
        editor.setVisibility(view.VISIBLE);
        Button endinnings = (Button) findViewById(R.id.endInnings);
        endinnings.setText("End innings");
    }
}
