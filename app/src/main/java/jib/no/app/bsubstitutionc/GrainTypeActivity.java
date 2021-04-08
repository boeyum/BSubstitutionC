package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import jib.no.app.bsubstitutionc.adapters.SecondAdapter;
import jib.no.app.bsubstitutionc.domain.GrainChart;

public class GrainTypeActivity extends AppCompatActivity {
    private GrainChart GC = new GrainChart();
    private int listPosition = 0;
    private ArrayList<String> listen;
    private Button slutt;
    private TextView manu;
    private String prod = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grain_type);
        Bundle extras = getIntent().getExtras();
        prod = extras.getString("PROD");

        manu = (TextView) findViewById(R.id.manifname);
        slutt = (Button) findViewById(R.id.returnmanifacturer);

        manu.setText(prod);

        final ArrayList<String> denne = GC.getPerProduser(prod);
        final SecondAdapter grainAdapter = new SecondAdapter(GrainTypeActivity.this, denne);
        final ListView grainView = (ListView) findViewById(R.id.datagrain);
        grainView.setAdapter(grainAdapter);
        grainView.setClickable(true);
        grainView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(GrainTypeActivity.this, GranReplacementActivity.class);
                System.out.println(String.format("******** Starter med %s og %s ************",prod,denne.get(position)));
                i.putExtra("PROD",prod);
                i.putExtra("GRAIN",denne.get(position));
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
