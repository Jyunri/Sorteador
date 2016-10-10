package br.com.cdf.sorteador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    RelativeLayout mainActivity;
    Button btConcorrentes;
    ImageButton ibSortear;
    CSVParser csvParser;
    List<Concorrente> concorrenteList;
    int csvSource = R.raw.resultadosushi;   //TODO: trocar por um default do CDF

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = (RelativeLayout)findViewById(R.id.mainActivity);

//        btConcorrentes = (Button)findViewById(R.id.btConcorrentes);
        ibSortear = (ImageButton)findViewById(R.id.ibSortear);

//        btConcorrentes.setOnClickListener(this);
        ibSortear.setOnClickListener(this);


        //configuracao por cliente
        switch (SorteioAtual.sorteioatual) {
            case "Pizzaria do Cheff":
                mainActivity.setBackgroundResource(R.drawable.tela1cheff);
                ibSortear.setBackgroundResource(R.drawable.botaocheff);
                csvSource = R.raw.resultadocheff2;
                break;
            case "Sushi Tina":
                mainActivity.setBackgroundResource(R.drawable.tela1sushi);
                ibSortear.setBackgroundResource(R.drawable.botaosushi);
                csvSource = R.raw.resultadosushi2;
                break;
            case "The Potato Delivery":
                mainActivity.setBackgroundResource(R.drawable.tela1potato);
                ibSortear.setBackgroundResource(R.drawable.botaopotato);
                csvSource = R.raw.resultadopotato;
                break;
            case "Spazio":
                mainActivity.setBackgroundResource(R.drawable.tela1spazio);
                ibSortear.setBackgroundResource(R.drawable.botaospazio);
                csvSource = R.raw.resultadospazio;
                break;
            case "Ceara":
                mainActivity.setBackgroundResource(R.drawable.tela1ceara);
                ibSortear.setBackgroundResource(R.drawable.botaoceara);
                csvSource = R.raw.resultadoceara;
            case "Kam Mann":
                mainActivity.setBackgroundResource(R.drawable.tela1km);
                ibSortear.setBackgroundResource(R.drawable.botaokm);
                csvSource = R.raw.resultadokammann;
                break;
        }

        //banco de dados
        InputStream is = getResources().openRawResource(csvSource);
        csvParser = new CSVParser(is);

        concorrenteList = new ArrayList<>();
        csvParser.read(concorrenteList);

        System.out.println("Current: " + SorteioAtual.sorteioatual);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btConcorrentes:
                String result = "";
                for(Concorrente c:concorrenteList) {
                    result = result + c.codigo+", "+c.nome+", "+c.email+", "+c.telefone+ "\n";
                }
                Intent i = new Intent(this,Resultados.class);
                i.putExtra("r",result);
                startActivity(i);
                break;
            case R.id.ibSortear:
                Collections.shuffle(concorrenteList);
                Intent i2 = new Intent(this,Suspense.class);
                i2.putExtra("codGanhador", concorrenteList.get(0).nome + ", código: " + concorrenteList.get(0).codigo);
                startActivity(i2);

                break;

        }
    }
}


