package com.example.ankit_pc.calculator;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView textView;
    StringBuffer d=new StringBuffer("");
    private String value="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.value);
        Intent intent=getIntent();
        if(intent!=null) {
            value = intent.getStringExtra("value");
            textView.setText(value);
            if(value!=null)
                d.append(value.toString());
        }
    }

    public void onClick(View v)
    {
    //System.out.println(v.getId());
        Button b;
        Double answer;
        String symbol="";
        switch (v.getId()) {
            case R.id.button0:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button1:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button2:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button3:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button4:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button5:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button6:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button7:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button8:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.button9:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonDecimal:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonDivide:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonMinus:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonMultiply:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonPlus:
                b=(Button)v;
                textView.setText(d.append(((Button) v).getText().toString()));
                break;
            case R.id.buttonEquals:
                System.out.println("inside button");
                String s[];
                if(d.toString().contains("+")) {
                    System.out.println("inside");
                    s = d.toString().split("\\+");
                    //System.out.println(s[0]);
                    //System.out.println(s[1]);
                    answer=Double.parseDouble(s[0])+Double.parseDouble(s[1]);
                    textView.setText(answer.toString());
                }
                else if(d.toString().contains("*")) {
                    s = d.toString().split("\\*");
                    answer=Double.parseDouble(s[0])*Double.parseDouble(s[1]);
                    textView.setText(answer.toString());
                }
                else if(d.toString().contains("-")) {
                    s = d.toString().split("\\-");
                    answer=Double.parseDouble(s[0])-Double.parseDouble(s[1]);
                    textView.setText(answer.toString());
                }
                else if(d.toString().contains("/")) {
                    s = d.toString().split("/");
                    answer=Double.parseDouble(s[0])/Double.parseDouble(s[1]);
                    textView.setText(answer.toString());
                }
                if(d.toString().contains("^")) {
                    s = d.toString().split("\\^");
                    answer=Math.pow(Double.parseDouble(s[0]),Double.parseDouble(s[1]));
                    textView.setText(answer.toString());
                }
                  break;
            case R.id.buttonDelete:
                b=(Button)v;
                String delete=textView.getText().toString();
                if (delete == null || delete.length() == 0) {
                    textView.setText(delete);
                    d=new StringBuffer("");
                }
                else {
                    textView.setText(delete.substring(0, delete.length() - 1));
                    d=new StringBuffer(delete.substring(0, delete.length() - 1));
                }
                break;
        }
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
            System.out.println("Inside");
            Intent intent = new Intent(MainActivity.this, AdvancedLayout.class);
            intent.putExtra("value", textView.getText());
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}