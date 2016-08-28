package br.com.cdf.sorteador;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ganhador extends AppCompatActivity {

    TextView tvVencedor;
    RelativeLayout ganhadorActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganhador);

        String ganhador = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ganhador += extras.getString("chave");
        }

        ganhadorActivity = (RelativeLayout)findViewById(R.id.ganhadorActivity);

        //configuracao por cliente
        switch (SorteioAtual.sorteioatual) {
            case "Pizzaria do Cheff":
                System.out.println("tela3"+"Pizza3");
                ganhadorActivity.setBackgroundResource(R.drawable.tela3cheff);
                break;
            case "Sushi Tina":
                ganhadorActivity.setBackgroundResource(R.drawable.tela3sushi);
                break;
            case "The Potato Delivery":
                ganhadorActivity.setBackgroundResource(R.drawable.tela3potato);
                break;
        }

        tvVencedor = (TextView)findViewById(R.id.tvVencedor);
        tvVencedor.setText(ganhador);


//        AlertDialog.Builder b2 = new AlertDialog.Builder(this);
//        b2.setMessage(ganhador)
//                .setTitle("Ganhador");
//        AlertDialog d2 = b2.create();
//        d2.show();
    }
}
