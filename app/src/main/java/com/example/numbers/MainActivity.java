package com.example.numbers;

import android.app.Activity;
import android.graphics.drawable.Icon;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView number;
    ImageView face;
    int num;
    Random random = new Random();
    int secret = random.nextInt(10)+1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        number = findViewById(R.id.number);
        face = findViewById(R.id.face);
        Log.d("MAinactive","secret :"+ secret);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num = Integer.parseInt(number.getText().toString());
                num++;
                face.setVisibility(View.VISIBLE);
                face.setAlpha(1.0f);
            number.setText("" +num);

            if(secret == num){
                Toast.makeText(MainActivity.this, "You Dead", Toast.LENGTH_LONG).show();
               face.setImageResource(R.drawable.dead);
            }else {
                face.setImageResource(R.drawable.smile);
                face.animate().alpha(0.0f).setDuration(1000);
            }
            }
        });
    }
    public void zero(View view){
            num=0;
            number.setText(""+num);

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
