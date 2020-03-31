package com.ex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void count(View v) {
        TextView error = findViewById(R.id.LabelError);
        TextView x1 = findViewById(R.id.X1);
        TextView x2 = findViewById(R.id.X2);
        int n, s;
        double[] y, sqrtY;
        boolean f = false;

        error.setVisibility(View.INVISIBLE);
        InputMethodManager inputManager = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

        if (((EditText)findViewById(R.id.NumberIn)).getText().toString().isEmpty()) {
            error.setVisibility(View.VISIBLE);
            error.setText("Error: Enter a number!");
            return;
        }

        n = Integer.parseInt(((EditText)findViewById(R.id.NumberIn)).getText().toString());

        if ((n%2) == 0 || n < 0) {
            error.setVisibility(View.VISIBLE);
            error.setText("Error: The number must be natural and unpaired!");
            return;
        }

        y = new double[n];
        sqrtY = new double[n];

        s = (int)(Math.sqrt(n)+1);

        for (int i = 0; i < n; i++) {
            y[i] = Math.pow((s+i),2) - n;
            sqrtY[i] = Math.sqrt(y[i]);
            if ((y[i] - (int)(y[i])) == 0 && (sqrtY[i] - (int)(sqrtY[i])) == 0 ) {
                x1.setText(Integer.toString((s+i) + (int)sqrtY[i]));
                x2.setText(Integer.toString((s+i) - (int)sqrtY[i]));

                f = true;
                break;
            }
        }

        if (!f) {
            error.setVisibility(View.VISIBLE);
            error.setText("Error: The number cannot be represented as the difference between the squares of two natural integers!");
            return;
        }
    }
}
