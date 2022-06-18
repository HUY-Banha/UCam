package kh.edu.rupp.u_cam.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.databinding.FragmentMajorBinding;
import kh.edu.rupp.u_cam.databinding.FragmentSettingBinding;

public class SettingFragment extends Fragment {
    FragmentSettingBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}

