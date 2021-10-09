package com.example.calculator;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;




public class MainActivity extends AppCompatActivity {

    TextView exprTextView;
    TextView resTextView;
    String expression = "";
    boolean bracketOpened = false;
    boolean lastCharDigit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        exprTextView = (TextView) findViewById(R.id.expressionTextView);
        resTextView = (TextView) findViewById(R.id.resultTextView);
        expression = exprTextView.getText().toString();
    }

    public void addToExpr(String arg){
        expression += arg;
        exprTextView.setText(expression);
    }

    public void ClearButtonClick(View view) {
        exprTextView.setText("");
        resTextView.setText("");
        expression = "";
        //exprTextView.setTextColor();

    }

    public void BracketsButtonClick(View view) {
        if (bracketOpened){
            addToExpr(")");
        }
        else{
            addToExpr("(");
        }
    }

    public void percentButtonClick(View view) {
        addToExpr("%");
    }

    public void DivideButtonClick(View view) {
        addToExpr("/");
    }

    public void SevenButtonClick(View view) {
        addToExpr("7");
        lastCharDigit = true;
    }

    public void EightButtonClick(View view) {
        addToExpr("8");
        lastCharDigit = true;
    }

    public void NineButtonClick(View view) {
        addToExpr("9");
        lastCharDigit = true;
    }

    public void MultiplyButtonClick(View view) {
        addToExpr("*");
    }

    public void FourButtonClick(View view) {
        addToExpr("4");
    }

    public void FiveButtonClick(View view) {
        addToExpr("5");
    }

    public void SixButtonClick(View view) {
        addToExpr("6");
    }

    public void MinusButtonClick(View view) {
        addToExpr("-");
    }

    public void OneButtonClick(View view) {
        addToExpr("1");
    }

    public void TwoButtonClick(View view) {
        addToExpr("2");
    }

    public void ThreeButtonClick(View view) {
        addToExpr("3");
    }

    public void PlusButtonClick(View view) {
        addToExpr("+");
    }

    public void ZeroButtonClick(View view) {
        addToExpr("0");
    }

    public void DotButtonClick(View view) {
        addToExpr(".");
    }

    public void EqualButtonClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try{
            result = (double)engine.eval(expression);
        } catch (ScriptException e) {
            Toast toast = Toast.makeText(this, "Неверный ввод", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        if (result != null){
            resTextView.setText(String.valueOf(result));
        }
    }

    public void RemoveLastButtonClick(View view) {
        if (expression != null && expression.length() > 0){
            expression = expression.substring(0, expression.length() - 1);
            exprTextView.setText(expression);
        }
    }
}