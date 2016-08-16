package br.com.cdf.sorteador;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jimy on 7/30/16.
 */
public class CSVParser {
    InputStream inputStream;
    BufferedReader reader;

    public CSVParser(InputStream inputStream) {
        this.inputStream = inputStream;
        reader = new BufferedReader(new InputStreamReader(inputStream));
    }

    public void read(List<Concorrente> concorrenteList)
    {
        try
        {
            String csvLine;
            int count = 0;
            while((csvLine = reader.readLine()) != null)
            {
                if(count!=0) {
                    Concorrente c = new Concorrente();
                    String[] row = csvLine.split(",");
                    c.codigo = row[1];
                    c.nome = row[2];
                    c.email = row[3];
                    c.telefone = row[4];
                    concorrenteList.add(c);
                }
                count++;
            }

        }catch(Exception e)
        {
            e.toString();
        }
    }
}
