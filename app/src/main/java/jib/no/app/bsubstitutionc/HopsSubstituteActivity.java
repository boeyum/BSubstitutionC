package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import jib.no.app.bsubstitutionc.adapters.ListeAdapter;
import jib.no.app.bsubstitutionc.domain.HopsChart;

public class HopsSubstituteActivity extends AppCompatActivity {
    private HopsChart HC = new HopsChart();
    private Button slutt;
    private int listPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hops_substitute);

        slutt = (Button) findViewById(R.id.returhopsmain);

        final ArrayList<String> chart = HC.getKeySet();

        ListeAdapter customAdapter = new ListeAdapter(HopsSubstituteActivity.this, chart);
        final ListView listView = (ListView) findViewById(R.id.humleliste);
        listView.setAdapter(customAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                listPosition = position;
                Intent i = new Intent(HopsSubstituteActivity.this, HopsReplacementActivity.class);
                i.putExtra("PROD",chart.get(listPosition));
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
