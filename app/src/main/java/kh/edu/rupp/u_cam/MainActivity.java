package kh.edu.rupp.u_cam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import kh.edu.rupp.u_cam.databinding.ActivityMainBinding;
import kh.edu.rupp.u_cam.fragment.HomeFragment;
import kh.edu.rupp.u_cam.fragment.MajorFragment;
import kh.edu.rupp.u_cam.fragment.SearchFragment;
import kh.edu.rupp.u_cam.fragment.SettingFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    DatabaseReference databaseUsers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        databaseUsers = FirebaseDatabase.getInstance().getReference();
        HomeFragment homeFragment = new HomeFragment();
        showFragment(homeFragment);

        listenerClick();
    }

    private void listenerClick() {
        binding.bottomNavigationBar.setOnItemSelectedListener(menuItem -> {
            switch (menuItem.getItemId()){
                case R.id.menu_home:
                    showFragment(new HomeFragment());
                    break;
                case R.id.menu_major:
                    showFragment(new MajorFragment());
                    break;
                case R.id.menu_search:
                    showFragment(new SearchFragment());
                    break;
                case R.id.menu_setting:
                    showFragment(new SettingFragment());
                    break;
                default:
                    showFragment(new HomeFragment());
            }
            return true;
        });
    }


    private void showFragment (Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.free_container, fragment);
        fragmentTransaction.commit();
    }
}