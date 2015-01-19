package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convert(View v){

        EditText etInput = (EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();

        double input = Double.parseDouble(s);
        double c = 0.0;
        double output = 0.0;

        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        int selFrom = rgFrom.getCheckedRadioButtonId();

        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
            c = input;
        }
        else if(selFrom == R.id.rbFrmF ){
            c = (input - 32) * 5/9;
        }
        else if(selFrom == R.id.rbFrmK){
            c = (input - 273.15);
        }

        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selTo = rgTo.getCheckedRadioButtonId();

        if (selTo == R.id.rbToC) { //The user wants to convert from Celsius.
            output = c;
        }
        else if(selTo == R.id.rbToF ){
            output = c * 9/5 + 32;
        }
        else if(selTo == R.id.rbToK){
            output = (c + 273.15);
        }
        TextView tv;
        tv = (TextView)findViewById(R.id.tvOutput);
        //The variable tv is referring to the textView widget in the layout.
        tv.setText(Double.toString(output));
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
