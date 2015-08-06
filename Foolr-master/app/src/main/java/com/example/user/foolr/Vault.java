package com.example.user.foolr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class Vault extends ActionBarActivity {
Button add;
Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* File root = new File( path );
        File[] list = root.listFiles();
        for(File f : list){
            CryptoUtils.decrypt("LaLaLaLaLaLaLaLa", f.getName(), f.getName())
        }
*/
        intent = new Intent(this, SelectPhoto.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vault);
        add = (Button) findViewById(R.id.button);
        add.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        Button btn2 = (Button)this.findViewById(R.id.btn2);
        Button btn3 = (Button)this.findViewById(R.id.btn3);
        Button btn4 = (Button)this.findViewById(R.id.btn4);
        Button btn5 = (Button)this.findViewById(R.id.btn5);

        btn2.setOnClickListener(new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
                Intent a = new Intent(getApplicationContext(),FullScreen.class);
                startActivity(a);
            }
        });

        btn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(),FullScreen2.class);
                startActivity(b);
            }
        });

        btn4.setOnClickListener(new Button.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent c = new Intent(getApplicationContext(),FullScreen3.class);
                startActivity(c);
            }
        });

        btn5.setOnClickListener(new Button.OnClickListener() {
        @Override
            public void onClick(View v) {
                Intent d = new Intent(getApplicationContext(),FullScreen4.class);
                startActivity(d);
            }
        });
    }
    void encryptPhotos(){


    }
    @Override
    public void onDestroy() {

        super.onDestroy();
        /*
        File root = new File( path );
            File[] list = root.listFiles();
       for(File f : list){
CryptoUtils.decrypt("LaLaLaLaLaLaLaLa", f.getName(), f.getName())
       }
       */
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_vault, menu);
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
