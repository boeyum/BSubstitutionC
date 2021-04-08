package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import jib.no.app.bsubstitutionc.adapters.ListeAdapter;
import jib.no.app.bsubstitutionc.domain.YeastChart;

public class YeastCardActivity extends AppCompatActivity {
    private YeastChart YC = new YeastChart();
    private ArrayList<String> liste = new ArrayList<String>();
    private TextView head;
    private TextView foot;
    private Button slutt;
    private String brand = new String();
    private String type = new String();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeast_card);
        Bundle extras = getIntent().getExtras();
        brand = extras.getString("PROD");
        type = extras.getString("TYPE");

        head = (TextView) findViewById(R.id.yeastname);
        foot = (TextView) findViewById(R.id.comments);
        slutt = (Button) findViewById(R.id.sluttyeastsub);
        String navn = String.format("%s - %s (%s)",YC.getTypeName(brand,type),type,brand);
        head.setText(navn);
        String comment = YC.getTypeComment(brand,type);
        if(comment != null) {
            foot.setText(comment);
        }

        liste = YC.getReplacementTypes(brand,type);

        ListeAdapter customAdapter = new ListeAdapter(YeastCardActivity.this, liste);
        final ListView listView = (ListView) findViewById(R.id.listgjaer);
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
