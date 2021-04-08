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

import jib.no.app.bsubstitutionc.adapters.ListeAdapter;
import jib.no.app.bsubstitutionc.domain.HopsChart;
import jib.no.app.bsubstitutionc.domain.HopsReplacement;

public class HopsReplacementActivity extends AppCompatActivity {
    private HopsChart HC = new HopsChart();
    private TextView hoptyp;
    private Button slutt;
    private String prod = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hops_replacement);
        Bundle extras = getIntent().getExtras();
        prod = extras.getString("PROD");

        hoptyp = (TextView) findViewById(R.id.hopstype);
        slutt = (Button) findViewById(R.id.slutthopsrepl);

        hoptyp.setText(String.format("(for: %s)",prod));

        ArrayList<String> chart = HC.getHopsReplacement(prod);

        ListeAdapter customAdapter = new ListeAdapter(HopsReplacementActivity.this, chart);
        final ListView listView = (ListView) findViewById(R.id.hrepliste);
        listView.setAdapter(customAdapter);
        listView.setClickable(false);

        slutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
