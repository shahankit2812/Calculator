package com.example.ankit_pc.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Ankit_PC on 05/03/2015.
 */
public class AdvancedLayout extends ActionBarActivity{
    private TextView textView;
    StringBuffer d=new StringBuffer("");
    private String value;
    private int value2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advanced_layout);
        textView=(TextView) findViewById(R.id.value);
        Intent intent=getIntent();
        value=intent.getStringExtra("value");
        textView.setText(value);
        d=new StringBuffer(value);
    }

    public void onClick(View v) {
        //System.out.println(v.getId());
        Button b;
        Double answer;
        switch (v.getId()) {
            case R.id.buttonSin:
                b = (Button) v;
                answer = Math.sin(Math.toDegrees(Double.parseDouble(value)));
                textView.setText(answer.toString());
                break;
            case R.id.buttonCos:
                b = (Button) v;
                answer = Math.cos(Math.toDegrees(Double.parseDouble(value)));
                textView.setText(answer.toString());
                break;
            case R.id.buttonTan:
                b = (Button) v;
                answer = Math.tan(Math.toDegrees(Double.parseDouble(value)));
                textView.setText(answer.toString());
                break;
            case R.id.buttonLn:
                b = (Button) v;
                answer = Math.log(Double.parseDouble(value));
                textView.setText(answer.toString());
                break;
            case R.id.buttonLog:
                b = (Button) v;
                answer = Math.log10(Double.parseDouble(value));
                textView.setText(answer.toString());
                break;
            case R.id.buttonPie:
                b = (Button) v;
                textView.setText(d.append(Math.PI));
                break;
            case R.id.buttonE:
                b = (Button) v;
                textView.setText(d.append(2.718281828459));
                break;
            case R.id.buttonPercentage:
                b = (Button) v;
                answer = (Double.parseDouble(value) / 100);
                textView.setText(answer.toString());
                break;
            case R.id.buttonRoot:
                b = (Button) v;
                answer = Math.sqrt(Double.parseDouble(value));
                textView.setText(answer.toString());
                break;
            case R.id.buttonRaiseTo:
                b = (Button) v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonFact:
                b = (Button) v;
                Double fact = fact(Double.parseDouble(value));
                textView.setText(fact.toString());
                break;
            case R.id.buttonDelete:
                b=(Button)v;
                String delete=textView.getText().toString();
                if (delete == null || delete.length() == 0) {
                    textView.setText(delete);
                }
                else
                    textView.setText(delete.substring(0, delete.length()-1));
                break;
        }
    }
        Double fact(Double n)
        {
            if(n==1)
                return 1.0;
            else
                return fact(n-1)*n;
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(AdvancedLayout.this, MainActivity.class);
            System.out.println(textView.getText());
            intent.putExtra("value", textView.getText());
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
