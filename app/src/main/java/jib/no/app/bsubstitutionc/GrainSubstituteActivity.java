package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import jib.no.app.bsubstitutionc.adapters.ListeAdapter;
import jib.no.app.bsubstitutionc.adapters.SecondAdapter;
import jib.no.app.bsubstitutionc.domain.GrainChart;

public class GrainSubstituteActivity extends AppCompatActivity {
    private GrainChart GC = new GrainChart();
    private int listPosition = 0;
    private ArrayList<String> listen;
    private Button slutt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grain_substitute);

        slutt = (Button) findViewById(R.id.returngrain);

        String [] base = GC.getProdusers();
        listen = new ArrayList( Arrays.asList(base) );

        ListeAdapter customAdapter = new ListeAdapter(GrainSubstituteActivity.this, listen);
        final ListView listView = (ListView) findViewById(R.id.prodgrain);
        listView.setAdapter(customAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                listPosition = position;
                Intent i = new Intent(GrainSubstituteActivity.this, GrainTypeActivity.class);
                i.putExtra("PROD",listen.get(listPosition));
                startActivity(i);
            }
        });

        slutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
