package kh.edu.rupp.u_cam.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import kh.edu.rupp.u_cam.MainActivity;
import kh.edu.rupp.u_cam.databinding.FragmentSearchBinding;
import kh.edu.rupp.u_cam.models.DetailModel;
import kh.edu.rupp.u_cam.models.FacultyModel;
import kh.edu.rupp.u_cam.models.UniversityModel;

public class SearchFragment extends Fragment {
    FragmentSearchBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSearchBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}
