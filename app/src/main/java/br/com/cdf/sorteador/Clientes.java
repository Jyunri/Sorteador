package br.com.cdf.sorteador;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Clientes extends AppCompatActivity implements View.OnClickListener{

    ListView l;
    String[] clientes;
    Button btSelecionar;
    String selecionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        btSelecionar = (Button)findViewById(R.id.btSelecionar);
        l = (ListView)findViewById(R.id.lvClientes);
        clientes = getResources().getStringArray(R.array.clientes);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(),R.layout.listacliente,clientes);
        l.setAdapter(adapter);
        btSelecionar.setOnClickListener(this);

        l.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SorteioAtual.sorteioatual = parent.getItemAtPosition(position).toString();
            }
        });

    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}

