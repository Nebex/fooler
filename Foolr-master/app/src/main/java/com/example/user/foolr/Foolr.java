package com.example.user.foolr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.OutputStreamWriter;


public class Foolr extends ActionBarActivity {
    TextView txt;
    EditText passwd;
    SharedPreferences prefs;
    String password1;
    String boolFolder;
    String path;
    Intent intent;

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("boolFolder","True");
        editor.putString("path", file.getAbsolutePath());
        editor.commit();
        if (!file.mkdirs()) {
            Log.e("error", "Directory not created");
        }
        return file;
    }
    protected void onCreate(Bundle savedInstanceState) {
        prefs = this.getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE);
        password1 = prefs.getString("preference_file_key", "");
        boolFolder = prefs.getString("boolFolder","");
        if(boolFolder.length() <= 0 ){
            getAlbumStorageDir("foolrPictures");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foolr);
        ImageView image1 = (ImageView) findViewById(R.id.imageView);
        image1.setImageResource(R.drawable.img1);

        intent = new Intent(this, Vault.class);

        if (password1.length() <= 0) {

            Toast.makeText(this, "looks like your first time please put in a new password", Toast.LENGTH_LONG).show();

        }


        Toast.makeText(this, "looks like your first time please input your password.", Toast.LENGTH_LONG).show();

        txt = (TextView) findViewById(R.id.textView);
        passwd = (EditText) findViewById(R.id.editText);

        final String passwordStorage = "";
        passwd.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    if (password1.length() <= 0) {
//                        /*Log.d("TEST","this happened");*/
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putString("preference_file_key", passwd.getText().toString());
                        editor.commit();
                        // prefs.edit().putString("preference_file_key", passwd.getText().toString()).commit();
                        String x = prefs.getString("preference_file_key", "");
                        txt.setText(x);
                        startActivity(intent);


                    } else {
                        if (passwd.getText().toString().equals(prefs.getString("preference_file_key", ""))) {
                            startActivity(intent);
                        }

                        return true;
                    }
                    return false;
                }
                return false;
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_foolr, menu);
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

    public void setTxt(String x) {
        txt.setText(x);
    }
}
