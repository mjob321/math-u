package com.example.job.mathu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    int answer;
    String q;
    int score = 0;
    int round = 0;
    int similar1, similar2, similar3, similar4, similar5, similar6;
    Stack<Integer> points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        TextView question = (TextView) findViewById(R.id.question);
        points = new Stack<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        TextView roundView = (TextView) findViewById(R.id.round);
        equation(view);
        setNumbers(view);
        round++;
        roundView.setText(round + "");
    }

    public void restartGame(View view) {
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);

        startGame(view);
        round = 1;
        gameStatus.setText("Question:");
        roundView.setText("1");
        buttonsClickable(view);
    }

    public void setNumbers(View view) {
        int placement = (int) (Math.random() * 6) + 1;
        TextView question = (TextView) findViewById(R.id.question);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);

        button1.setText(similar1 + "");
        button2.setText(similar2 + "");
        button3.setText(similar3 + "");
        button4.setText(similar4 + "");
        button5.setText(similar5 + "");
        button6.setText(similar6 + "");
        if (placement == 1)
            button1.setText(answer + "");
        else if (placement == 2)
            button2.setText(answer + "");
        else if (placement == 3)
            button3.setText(answer + "");
        else if (placement == 4)
            button4.setText(answer + "");
        else if (placement == 5)
            button5.setText(answer + "");
        else
            button6.setText(answer + "");

    }

    public void equation(View view) {
        TextView question = (TextView) findViewById(R.id.question);
        int randomOp = (int) (Math.random() * 3);
        int randomNum1 = (int) (Math.random() * 10);
        int randomNum2 = (int) (Math.random() * 10);
        String rn1 = Integer.toString(randomNum1);
        String rn2 = Integer.toString(randomNum2);
        q = "";

        if (randomOp == 0) {
            q = rn1 + " * " + rn2 + " = ?";
            question.setText(q);
            answer = randomNum1 * randomNum2;
            similar1 = randomNum1 + randomNum2;
            similar2 = randomNum1 * randomNum2 + 1;
            if (randomNum1 > randomNum2)
                similar3 = randomNum1 - randomNum2 + 1;
            else
                similar3 = randomNum2 - randomNum1 + 1;
            similar4 = randomNum1 * randomNum2 + 2;
            similar5 = randomNum1 + randomNum2 + 2;
            similar6 = randomNum1 + randomNum2 + 1;

        }
        else if (randomOp == 1) {
            q = rn1 + " + " + rn2 + " = ?";
            question.setText(q);
            answer = randomNum1 + randomNum2;
            similar1 = randomNum1 * randomNum2;
            similar2 = randomNum1 * randomNum2 + 1;
            if (randomNum1 > randomNum2)
                similar3 = randomNum1 - randomNum2 + 1;
            else
                similar3 = randomNum2 - randomNum1 + 1;
            similar4 = randomNum1 * randomNum2 + 2;
            similar5 = randomNum1 + randomNum2 + 2;
            similar6 = randomNum1 + randomNum2 + 1;
        }
        else {
            if (randomNum1 > randomNum2) {
                q = rn1 + " - " + rn2 + " = ?";
                question.setText(q);
                answer = randomNum1 - randomNum2;
                similar1 = randomNum1 + randomNum2;
                similar2 = randomNum1 * randomNum2 + 1;
                if (randomNum1 > randomNum2)
                    similar3 = randomNum1 - randomNum2 + 1;
                else
                    similar3 = randomNum2 - randomNum1 + 1;
                similar4 = randomNum1 * randomNum2 + 2;
                similar5 = randomNum1 + randomNum2 + 2;
                similar6 = randomNum1 + randomNum2 + 1;
            }
            else {
                q = rn2 + " - " + rn1 + " = ?";
                question.setText(q);
                answer = randomNum2 - randomNum1;
                similar1 = randomNum1 + randomNum2;
                similar2 = randomNum1 * randomNum2 + 1;
                if (randomNum1 > randomNum2)
                    similar3 = randomNum1 - randomNum2 + 1;
                else
                    similar3 = randomNum2 - randomNum1 + 1;
                similar4 = randomNum1 * randomNum2 + 2;
                similar5 = randomNum1 + randomNum2 + 2;
                similar6 = randomNum1 + randomNum2 + 1;
            }
        }
    }

    public void press1(View view) {
        Button button = (Button) findViewById(R.id.button1);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());

        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }
    public void press2(View view) {
        Button button = (Button) findViewById(R.id.button2);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());
        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }
    public void press3(View view) {
        Button button = (Button) findViewById(R.id.button3);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());
        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }
    public void press4(View view) {
        Button button = (Button) findViewById(R.id.button4);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());
        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }
    public void press5(View view) {
        Button button = (Button) findViewById(R.id.button5);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());
        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }
    public void press6(View view) {
        Button button = (Button) findViewById(R.id.button6);
        TextView gameStatus = (TextView) findViewById(R.id.gameStatus);
        TextView roundView = (TextView) findViewById(R.id.round);
        TextView questionView = (TextView) findViewById(R.id.question);
        Button startButton = (Button) findViewById(R.id.startButton);
        int value = Integer.parseInt(button.getText().toString());
        if (answer == value) {
            points.push(value);
            startGame(view);
        }
        else {
            while (!points.empty()) {
                score += points.pop();
            }
            gameStatus.setText("Score:");
            roundView.setText(score + "");
            questionView.setText("Game Over. Try Again.");
            buttonsNotClickable(view);
        }
    }

    public void buttonsNotClickable(View view) {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button startButton = (Button) findViewById(R.id.startButton);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
        button6.setClickable(false);
        startButton.setClickable(false);
    }

    public void buttonsClickable(View view) {
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button startButton = (Button) findViewById(R.id.startButton);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);
        button6.setClickable(true);
    }
}
