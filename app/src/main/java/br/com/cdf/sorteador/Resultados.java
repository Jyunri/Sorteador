package br.com.cdf.sorteador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {

    RelativeLayout resultadoActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        String result = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            result += extras.getString("r");
        }



        TextView tvResultado = (TextView)findViewById(R.id.tvResultados);

        tvResultado.setText(result);
    }
}
