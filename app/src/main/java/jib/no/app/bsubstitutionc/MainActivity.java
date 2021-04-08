package jib.no.app.bsubstitutionc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button exit;
    private Button yest;
    private Button hops;
    private Button grain;
    private Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = (Button) findViewById(R.id.info);
        grain = (Button) findViewById(R.id.grain);
        hops = (Button) findViewById(R.id.hops);
        yest = (Button) findViewById(R.id.yest);
        exit = (Button) findViewById(R.id.exit);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BCInfoActivity.class));
            }
        });

        grain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GrainSubstituteActivity.class));
            }
        });

        hops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HopsSubstituteActivity.class));
            }
        });

        yest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, YeastSubstituteActivity.class));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
