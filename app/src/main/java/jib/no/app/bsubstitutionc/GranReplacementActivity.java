package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import jib.no.app.bsubstitutionc.adapters.ListeAdapter;
import jib.no.app.bsubstitutionc.domain.GrainChart;

public class GranReplacementActivity extends AppCompatActivity {
    private GrainChart GC = new GrainChart();
    private TextView tprod;
    private TextView tgrain;
    private Button retur;
    private String prod = new String();
    private String grain = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gran_replacement);
        Bundle extras = getIntent().getExtras();
        prod = extras.getString("PROD");
        grain = extras.getString("GRAIN");

        tprod = (TextView) findViewById(R.id.produsent);
        tgrain = (TextView) findViewById(R.id.korn);
        retur = (Button) findViewById(R.id.returnreplace);

        tprod.setText(prod);
        tgrain.setText(grain);

        ArrayList<String> subst = GC.getSubstitutes(prod,grain);
        ListeAdapter customAdapter = new ListeAdapter(this, subst);
        final ListView listView = (ListView) findViewById(R.id.replace);
        listView.setAdapter(customAdapter);
        listView.setClickable(false);

        retur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
