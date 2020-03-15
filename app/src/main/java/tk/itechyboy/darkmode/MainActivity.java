package tk.itechyboy.darkmode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    SharedPref sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState()){
            setTheme(R.style.DarkTheme);
        } else {
            setTheme(R.style.LightTheme);
        }
        setContentView(R.layout.activity_main);

        Button tv = findViewById(R.id.change);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sharedPref.loadNightModeState()) {
                    sharedPref.setNightModeState(false);
                } else {
                    sharedPref.setNightModeState(true);
                }
                //finish();
                animate(MainActivity.this);
                //startActivity(new Intent(MainActivity.this, MainActivity.this.getClass()));
            }
        });
    }

    public void animate(final Context context) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                context.startActivity(new Intent(MainActivity.this,context.getClass()));
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();
            }
        }, 0);
    }
}
