package com.example.d064899.ecofriends;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class ProductActivity extends AppCompatActivity implements Listener {
    private DatabaseReference pDatabase;
    private String barcode;
    public TextView hersteller;
    public TextView name;
    public TextView score;
    public TextView inhalt;
    public TextView erneuerbar;
    public TextView fairtrade;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_content_product);

        barcode = getIntent().getExtras().getString("Barcode");
        pDatabase = FirebaseDatabase.getInstance().getReference("Produkte");

        hersteller = findViewById(R.id.hersteller);
        name = findViewById(R.id.product);
        score = findViewById(R.id.score_overall);
        inhalt = findViewById(R.id.inhalt);
        erneuerbar = findViewById(R.id.erneuerbar);
        fairtrade = findViewById(R.id.fairtrade);



        getProductDetails(barcode, pDatabase, new Listener() {
            @Override
            public void onSuccess(DataSnapshot data, String id) {
                for (DataSnapshot details : data.child(id).getChildren()) {
                    String Key = details.getKey().toString();
                    String Value = details.getValue().toString();
                    switch (Key){
                        case "HERSTELLER":
                            hersteller.setText(Value);
                            hersteller.setVisibility(View.VISIBLE);
                            break;
                        case "NAME":
                            name.setText(Value);
                            name.setVisibility(View.VISIBLE);
                            break;
                        case "SCORE":
                            score.setText(Value);
                            score.setVisibility(View.VISIBLE);
                            break;
                        case "INHALT":
                            inhalt.setText(Value);
                            inhalt.setVisibility(View.VISIBLE);
                            break;
                        case "NACHHALTIGKEIT":
                            erneuerbar.setText(Value);
                            erneuerbar.setVisibility(View.VISIBLE);
                            break;
                        case "FAIRTRADE":
                            fairtrade.setText(Value);
                            fairtrade.setVisibility(View.VISIBLE);
                            break;
                    }
                }
                if (hersteller.getVisibility() == View.INVISIBLE){
                    Context context = getApplicationContext();
                    CharSequence text = "Dieses Produkt existiert leider nicht in unserer Datenbank!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    findViewById(R.id.t_erneuerbar).setVisibility(View.VISIBLE);
                    findViewById(R.id.t_inhalt).setVisibility(View.VISIBLE);
                    findViewById(R.id.t_fairtrade).setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private Query getProductDetails(final String barcode, DatabaseReference database, final Listener listener) {
        Query query = database.orderByChild("BARCODE").equalTo(barcode);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listener.onSuccess(dataSnapshot, "P" + barcode);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return query;
    }

    @Override
    public void onSuccess(DataSnapshot data, String id) {

    }
}
