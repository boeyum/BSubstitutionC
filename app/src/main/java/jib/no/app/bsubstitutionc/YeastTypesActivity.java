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
import jib.no.app.bsubstitutionc.domain.YeastChart;

public class YeastTypesActivity extends AppCompatActivity {
    private YeastChart YC = new YeastChart();
    private ArrayList<String> liste = new ArrayList<String>();
    private TextView head;
    private Button slutt;
    private int listPosition = 0;
    private String brand = new String();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeast_types);
        Bundle extras = getIntent().getExtras();
        brand = extras.getString("PROD");

        head = (TextView) findViewById(R.id.textView11);
        slutt = (Button) findViewById(R.id.sluttyeasttyp);
        head.setText(brand);

        liste = YC.getTypesPerBrand(brand);

        ListeAdapter customAdapter = new ListeAdapter(YeastTypesActivity.this, liste);
        final ListView listView = (ListView) findViewById(R.id.yeasttypes);
        listView.setAdapter(customAdapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                listPosition = position;
                Intent i = new Intent(YeastTypesActivity.this, YeastCardActivity.class);
                i.putExtra("PROD",brand);
                i.putExtra("TYPE",liste.get(listPosition));
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
