package com.guptaji.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText result;
    private EditText newNumber;
    private TextView display;

    private String pendingOperation = "=";
    private Double operand1 = null;
    private Double operand2 = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newNumber = (EditText) findViewById(R.id.result);
        result = (EditText)findViewById(R.id.newNumber);
        display = (TextView) findViewById(R.id.display);
        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);

        Button divide = (Button) findViewById(R.id.div);
        Button multiply = (Button) findViewById(R.id.mul);
        Button plus = (Button) findViewById(R.id.plus);
        Button minus = (Button) findViewById(R.id.min);
        Button equal = (Button) findViewById(R.id.equ);

        Button dot = (Button)findViewById(R.id.point);

        View.OnClickListener onNumClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                newNumber.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(onNumClick);
        button1.setOnClickListener(onNumClick);
        button2.setOnClickListener(onNumClick);
        button3.setOnClickListener(onNumClick);
        button4.setOnClickListener(onNumClick);
        button5.setOnClickListener(onNumClick);
        button6.setOnClickListener(onNumClick);
        button7.setOnClickListener(onNumClick);
        button8.setOnClickListener(onNumClick);
        button9.setOnClickListener(onNumClick);
        dot.setOnClickListener(onNumClick);

        View.OnClickListener onOpClick = new View.OnClickListener() {
            public void onClick(View v){
                Button b = (Button) v;
                String op = b.getText().toString();
                String number = newNumber.getText().toString();
                if(number.length()!=0){
                    performOperation(number,op);
                }
                pendingOperation = op;
                display.setText(pendingOperation);
            }
        };
        equal.setOnClickListener(onOpClick);
        plus.setOnClickListener(onOpClick);
        minus.setOnClickListener(onOpClick);
        divide.setOnClickListener(onOpClick);
        multiply.setOnClickListener(onOpClick);

    }
    private void performOperation(String value,String op){
        if(null == operand1){
            operand1 = Double.valueOf(value);
        }
        else {
            operand2 = Double.valueOf(value);
            if (pendingOperation.equals("=")) {
                pendingOperation = op;
            }
            switch (pendingOperation) {
                case "+": {
                    operand1 += operand2;
                    break;
                }
                case "-": {
                    operand1 -= operand2;
                    break;
                }
                case "*": {
                    operand1 *= operand2;
                    break;
                }
                case "=": {
                    operand1 = operand2;
                    break;
                }
                case "/": {
                    if (operand2 == 0) {
                        operand1 = 0.0;
                        break;
                    } else {
                        operand1 /= operand2;
                    }
                    break;
                }
            }
        }
            result.setText(operand1.toString());
            newNumber.setText("");
            View.OnClickListener onCClick = new View.OnClickListener(){
            public void onClick(View v){
                Button b = (Button) v;
                newNumber.setText("");
                result.setText("");
                display.setText("");
                operand1=null;
            }
        };
        Button res = (Button)findViewById(R.id.reset);
        res.setOnClickListener(onCClick);


        }

}
