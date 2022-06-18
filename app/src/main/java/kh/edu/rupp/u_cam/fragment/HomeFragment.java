package kh.edu.rupp.u_cam.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.text.style.UpdateLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kh.edu.rupp.u_cam.RecyclerItemClickListener;
import kh.edu.rupp.u_cam.api.VolleySingleton;
import kh.edu.rupp.u_cam.adapter.HomeRecAdapter;
import kh.edu.rupp.u_cam.databinding.FragmentHomeBinding;
import kh.edu.rupp.u_cam.models.DetailModel;
import kh.edu.rupp.u_cam.models.UniversityModel;
import kh.edu.rupp.u_cam.screen.HomeDetailActivity;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    String titleDetail, detailDetail, experience, award, imageDetail;
    Context context;
    HomeRecAdapter homeRecAdapter;
    ArrayList<UniversityModel> universityList;
    RequestQueue requestQueue;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        universityList = new ArrayList<>();
        binding.recyclerviewUniversityList.setHasFixedSize(true);
        binding.recyclerviewUniversityList.setLayoutManager(new LinearLayoutManager(getActivity()));
        requestQueue = VolleySingleton.getInstance(getActivity()).getRequestQueue();
        fetchData();
        binding.recyclerviewUniversityList.addOnItemTouchListener(new RecyclerItemClickListener(context, binding.recyclerviewUniversityList, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println("Item"+position);
                Intent intent = new Intent(getActivity(), HomeDetailActivity.class);
                intent.putExtra("title", titleDetail);
                intent.putExtra("detail", detailDetail);

                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return binding.getRoot();
    }

    private void fetchData() {
        String url = "http://10.0.2.2:3000/home";
//        http://10.0.2.2:8000/posts
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    System.out.println("length:::::"+i);
                    String title = jsonObject.getString("title");
                    String place = jsonObject.getString("place");
                    String image = jsonObject.getString("image");
                    JSONArray detail = jsonObject.getJSONArray("detail");
                    for (int j = 0; j < detail.length(); j++) {
                        System.out.println("length j++++"+ j);
                        JSONObject jsonObject1 = detail.getJSONObject(0);

                        titleDetail = jsonObject1.getString("title");
                        detailDetail = jsonObject1.getString("detail");
                        imageDetail = jsonObject1.getString("image");
                        award = jsonObject1.getString("award");
                        experience = jsonObject1.getString("experian");
                    }
                    System.out.println("length: "+response.length());

                    DetailModel detailModel = new DetailModel(titleDetail, detailDetail, experience, award,award);


                    UniversityModel university = new UniversityModel(image, title, place);
                    universityList.add(university);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                homeRecAdapter = new HomeRecAdapter(getActivity(), universityList);
                binding.recyclerviewUniversityList.setAdapter(homeRecAdapter);

            }

        },
                error -> {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println(error.getMessage());
                });

        requestQueue.add(arrayRequest);

    }
}
