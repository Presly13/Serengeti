package com.radissonblu.www.bluit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
    }

    public void logout(View view) {
        Intent logOut = new Intent(this, MainActivity.class);
        startActivity(logOut);
    }
}
