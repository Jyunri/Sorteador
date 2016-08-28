package br.com.cdf.sorteador;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;


public class Suspense extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 2000;
    RelativeLayout suspenseActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suspense);

        suspenseActivity = (RelativeLayout)findViewById(R.id.suspenseActivity);

        //configuracao por cliente
        switch (SorteioAtual.sorteioatual) {
            case "Pizzaria do Cheff":
                suspenseActivity.setBackgroundResource(R.drawable.tela2cheff);
                break;
            case "Sushi Tina":
                suspenseActivity.setBackgroundResource(R.drawable.tela2sushi);
                break;
            case "The Potato Delivery":
                suspenseActivity.setBackgroundResource(R.drawable.tela2potato);
                break;
        }

        new Handler().postDelayed(new Runnable() {

         /*
          * Showing splash screen with a timer. This will be useful when you
          * want to show case your app logocheff / company
          */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                String ganhador = "";
                Bundle extras = getIntent().getExtras();
                if (extras != null) {
                    ganhador += extras.getString("codGanhador");
                }

                Intent i2 = new Intent(Suspense.this,Ganhador.class);
                i2.putExtra("chave", ganhador);
                startActivity(i2);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}
