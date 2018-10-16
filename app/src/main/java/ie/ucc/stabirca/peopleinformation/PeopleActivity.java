package ie.ucc.stabirca.peopleinformation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class PeopleActivity extends AppCompatActivity {

    private ListView list = null;
    private ArrayAdapter <String> adapter = null;
    private XMLPeopleData peopleData = null;
    Intent intent = null;
    Bundle b = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        // wire and make the list
        list = findViewById(R.id.listView);

        peopleData = new XMLPeopleData(getApplicationContext());

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                peopleData.getNames());

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                        @Override
                                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                                            intent = new Intent(getApplicationContext(), MainActivity.class);
                                            b = new Bundle();

                                            Log.d("DEBUG", " Bundle made \n");

                                            b.putSerializable("data", peopleData.getPersonData(i));
                                            Log.d("DEBUG", " string put in bundle \n");

                                           // Toast.makeText(getApplicationContext(), ((Person)b.getSerializable("data")).getName(), Toast.LENGTH_LONG).show();

                                            intent.putExtras(b);



                                            startActivity(intent);
                                        }
                                    }
        );

/*


        .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "selected"+peopleData.getNames()[i], Toast.LENGTH_LONG);

                // make an intent and prepare some data for it
                Intent intent = new Intent(PeopleActivity.this, MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("data", peopleData.getPersonData(i));
                intent.putExtras(bundle);

                //Toast.makeText(getApplicationContext(), "selected"+peopleData.getNames()[i], Toast.LENGTH_LONG);

                // start MainActivity
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

    }
}
