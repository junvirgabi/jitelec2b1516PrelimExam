package tech.sidespell.prelimexam;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView mTvTime;
    private ToggleButton mBtnSwitch;
    private RadioButton rbnPlus;
    private RadioButton rbnMin;
    private RadioGroup rbnGroup;
    private SeekBar seekBar;



    private long timeRemaining = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvTime = (TextView) findViewById(R.id.txtVal);
        mBtnSwitch = (ToggleButton) findViewById(R.id.btnPeform);
        rbnPlus = (RadioButton)findViewById(R.id.rbnInc);
        rbnMin = (RadioButton)findViewById(R.id.rbnDec);
        seekBar =(SeekBar)findViewById(R.id.seekBar);

        mTvTime.setText(seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            int progress = 0;


            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {

                progress = progresValue;

                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();

            }


            @Override

            public void onStartTrackingTouch(SeekBar seekBar) {

                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();

            }


            @Override

            public void onStopTrackingTouch(SeekBar seekBar) {

                mTvTime.setText("Covered: " + progress + "/" + seekBar.getMax());

                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();

            }

        });
        final Handler handler = new Handler();

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                timeRemaining -= 1000;
//                mTvTime.setText(timeRemaining + "");
//
//                if (timeRemaining > 0) {
//                    handler.postDelayed(this, 1000);
//                }
//            }
//        };
//
//        handler.postDelayed(runnable, 1000);
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

    public void onrbnGroup(View view) {

        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbnInc:
                if (checked)

                    break;
            case R.id.rbnDec:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
