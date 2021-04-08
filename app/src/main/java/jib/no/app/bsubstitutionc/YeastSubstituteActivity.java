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
import jib.no.app.bsubstitutionc.domain.YeastChart;

public class YeastSubstituteActivity extends AppCompatActivity {
    private YeastChart YC = new YeastChart();
    private ArrayList<String> liste = new ArrayList<String>();
    private Button slutt;
    private int listPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeast_substitute);

        slutt = (Button) findViewById(R.id.sluttyeastmain);
        liste = YC.getBrands();

        ListeAdapter customAdapter = new ListeAdapter(YeastSubstituteActivity.this, liste);
        final ListView listView = (ListView) findViewById(R.id.yeastlist);
        listView.setAdapter(customAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                listPosition = position;
                Intent i = new Intent(YeastSubstituteActivity.this, YeastTypesActivity.class);
                i.putExtra("PROD",liste.get(listPosition));
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
