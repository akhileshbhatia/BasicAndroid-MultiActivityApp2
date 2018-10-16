package ie.ucc.stabirca.peopleinformation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView personImageView = null;
    private Button moreInfoButton = null;
    private Intent intent = null;

    private Person data = null;
    Bundle bundle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // get data from intent
        Intent intent = getIntent();
        Log.d("DEBUG", "intent made " );
        bundle = intent.getExtras();
        data = (Person)bundle.getSerializable("data");
        // wire
        personImageView = findViewById(R.id.imageView);
        moreInfoButton  = findViewById(R.id.button);

        // set the image from data.image
        String imageName = data.getImage();
        imageName = imageName.substring(0, imageName.indexOf("."));

        int imageResId = getResources().getIdentifier(
                imageName,
                "drawable",
                getPackageName());

        personImageView.setImageResource(imageResId);

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", data);
                intent.putExtras(bundle);

                startActivity(intent);

            }
        });




    }
}








