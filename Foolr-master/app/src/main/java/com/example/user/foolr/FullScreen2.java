package com.example.user.foolr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FullScreen2 extends Vault{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_2);

        Intent x = new Intent();
        x = getIntent();

        Button back = (Button)this.findViewById(R.id.back);
        back.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Vault.class);
                startActivity(i);
            }
        });
    }

}
