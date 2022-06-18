package kh.edu.rupp.u_cam.screen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.databinding.ActivityDepartmentBinding;
import kh.edu.rupp.u_cam.databinding.ActivityMainBinding;

public class DepartmentActivity extends AppCompatActivity {
    ActivityDepartmentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepartmentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

    }
}