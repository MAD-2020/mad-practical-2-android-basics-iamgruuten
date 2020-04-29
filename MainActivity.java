package sg.edu.np.Week2Practical;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button ButtonLeft;
    private Button ButtonRight;
    private Button ButtonMiddle;
    private TextView TextScore;

    private String Score = "0";
    private int intRandom;
    private static final String TAG = "ButtonActivity";
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"Whack-A-Mole" );
        ButtonLeft = findViewById(R.id.ButtonLeft); //Set as 1
        ButtonMiddle = findViewById(R.id.ButtonMiddle); //Set as 2
        ButtonRight = findViewById(R.id.ButtonRight); //Set as 3
        TextScore = findViewById(R.id.TextViewScore); //Score view
        reset();

        ButtonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Left clicked!" );
                Score = check(1, intRandom, Score);
                TextScore.setText(Score);
                reset();
            }
        });

        ButtonMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Middle clicked!" );
                Score = check(2, intRandom, Score);
                TextScore.setText(Score);
                reset();
            }
        });

        ButtonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Button Right clicked!" );
                Score = check(3, intRandom, Score);
                TextScore.setText(Score);
                reset();
            }
        });
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"Started");
    }
    
    @Override
    protected void onPause() {
        super.onStart();
        Log.v(TAG,"Paused");
        Score = 0;
    }
    
    private void reset(){
        //Initialize
        intRandom = random(); //Get Random
        if(intRandom == 1){ButtonLeft.setText("*"); ButtonMiddle.setText("O"); ButtonRight.setText("O");}
        else if(intRandom == 2){ButtonMiddle.setText("*"); ButtonLeft.setText("O"); ButtonRight.setText("O");}
        else if(intRandom == 3){ButtonRight.setText("*"); ButtonMiddle.setText("O"); ButtonLeft.setText("O");}
    }

    private int random(){
        return random.nextInt(3) + 1;
    }

    private String check(int ButtonClicked, int value, String score){
        int Score =  Integer.parseInt(score);
        if(ButtonClicked == value){
            Log.v(TAG, "Hit, Score added!");
            Score = Score + 1;
        }else{
            Log.v(TAG, "Missed, Score deducted!");
            Score = Score - 1;
        }

        return String.valueOf(Score);
    }
}
