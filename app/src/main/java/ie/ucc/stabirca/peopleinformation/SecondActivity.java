package ie.ucc.stabirca.peopleinformation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTextView = null;
    private TextView phoneTextView = null;
    private TextView addressTextView = null;
    private TextView urlTextView = null;

    private Button webInfoButton = null;
    private Intent intent = null;

    private Person data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // get data from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        data = (Person) bundle.getSerializable("data");

        //wire and populate the fieldswith data.getName() etc
        nameTextView    = findViewById(R.id.textView5);
        phoneTextView   = findViewById(R.id.textView4);
        addressTextView = findViewById(R.id.textView3);
        urlTextView     = findViewById(R.id.textView2);

        nameTextView.setText(data.getName());
        phoneTextView.setText(data.getPhone());
        addressTextView.setText(data.getAddress());
        urlTextView.setText(data.getUrl());

        webInfoButton = findViewById(R.id.button2);

        webInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getUrl()));
                startActivity(intent);
            }
        });

        

    }
}
