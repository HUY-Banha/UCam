package kh.edu.rupp.u_cam.screen;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONException;
import org.json.JSONObject;

import kh.edu.rupp.u_cam.R;

public class HomeDetailActivity extends AppCompatActivity {
    TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        try {

            title = findViewById(R.id.txt_home_detail);
            description = findViewById(R.id.text_description);
            title.setText(getIntent().getStringExtra("title"));
            description.setText(getIntent().getStringExtra("detail"));


        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}