package espirometria.fabricaapp.uninove.com.br.procalc;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import espirometria.fabricaapp.uninove.com.br.procalc.activities.MainActivity;

public class SplashActivity extends AppCompatActivity {

    int timeSleep = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(it);
            }
        },timeSleep);
    }
}
