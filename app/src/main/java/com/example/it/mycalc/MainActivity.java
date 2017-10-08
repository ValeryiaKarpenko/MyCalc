package com.example.it.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
  //  Calc mCalc = new Calc();

    EditText inputFirstEditText;
    EditText inputSecondEditText;
    Button plusButton;
    Button minusButton;
    Button multiplyButton;
    Button devideButton;
    Button cButton;
    TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstEditText = (EditText) findViewById(R.id.first_value_edit_text);
        inputSecondEditText = (EditText) findViewById(R.id.second_value_edit_text);
        plusButton = (Button) findViewById(R.id.plus_button);
        minusButton = (Button) findViewById(R.id.minus_button);
        multiplyButton = (Button) findViewById(R.id.multiply_button);
        devideButton = (Button) findViewById(R.id.devide_button);
        cButton = (Button) findViewById(R.id.c_button);
        resultTextView = (TextView) findViewById(R.id.result_text_view);

        plusButton.setOnClickListener(this);
        minusButton.setOnClickListener(this);
        multiplyButton.setOnClickListener(this);
        devideButton.setOnClickListener(this);
        cButton.setOnClickListener(this);

        Log.i(TAG,"On Create");
    }



    @Override
    public void onClick(View v) {

        float val1;
        float val2;
        float res = 0;

        if (TextUtils.isEmpty(inputFirstEditText.getText().toString())
                || TextUtils.isEmpty(inputSecondEditText.getText().toString())) {
            return;
        }

        val1 = Float.parseFloat(inputFirstEditText.getText().toString());
        val2 = Float.parseFloat(inputSecondEditText.getText().toString());

        switch (v.getId()) {
            case R.id.plus_button:
                res = val1 + val2;
                break;
            case R.id.minus_button:
                res = val1 - val2;
                break;
            case R.id.multiply_button:
                res = val1 * val2;
                break;
            case R.id.devide_button:
                res = val1 / val2;
                break;
            case R.id.c_button:
                inputFirstEditText.setText("");
                inputSecondEditText.setText("");
                resultTextView.setText("");
                break;
        }
        resultTextView.setText("" + res);


    }
    
    @Override
    protected void onDestroy() {
// TODO Auto-generated method stub
        super.onDestroy();

        Log.i(TAG,"On Destroy");
    }

    @Override
    protected void onPause() {
// TODO Auto-generated method stub
        super.onPause();
        Log.i(TAG,"On Pause");
    }


    @Override
    protected void onRestart() {
// TODO Auto-generated method stub
        super.onRestart();
        Log.i(TAG,"On Restart");
    }


    @Override
    protected void onResume() {
// TODO Auto-generated method stub
        super.onResume();
        Log.i(TAG,"On Resume");
    }


    @Override
    protected void onStart() {
// TODO Auto-generated method stub
        super.onStart();
        Log.i(TAG,"On Start");
    }

    @Override
    protected void onStop() {
// TODO Auto-generated method stub
        super.onStop();
        Log.i(TAG,"On Stop");
    }
}

