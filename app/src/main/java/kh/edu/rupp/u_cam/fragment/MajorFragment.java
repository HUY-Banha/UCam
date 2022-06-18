package kh.edu.rupp.u_cam.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.RecyclerItemClickListener;
import kh.edu.rupp.u_cam.adapter.HomeRecAdapter;
import kh.edu.rupp.u_cam.adapter.MajorRecAdapter;
import kh.edu.rupp.u_cam.api.VolleySingleton;
import kh.edu.rupp.u_cam.databinding.FragmentMajorBinding;
import kh.edu.rupp.u_cam.models.DetailModel;
import kh.edu.rupp.u_cam.models.MajorModel;
import kh.edu.rupp.u_cam.models.UniversityModel;

public class MajorFragment extends Fragment {
    FragmentMajorBinding binding;
    private RecyclerView recyclerView_major;
    Context context;
    ArrayList<MajorModel> listMajor;
    RequestQueue requestQueue;
    MajorRecAdapter majorRecAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMajorBinding.inflate(inflater, container, false);
        recyclerView_major = binding.getRoot().findViewById(R.id.recyclerview_major_list);
        recyclerView_major.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView_major.setLayoutManager(linearLayoutManager);

        requestQueue = VolleySingleton.getInstance(getActivity()).getRequestQueue();
        fetchData();
        recyclerView_major.addOnItemTouchListener(new RecyclerItemClickListener(context, recyclerView_major, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                System.out.println("Item"+position);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));



        return binding.getRoot();
    }

    private void fetchData() {
        String url = "http://10.0.2.2:3000/major";
//        http://10.0.2.2:8000/posts
        JsonArrayRequest arrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject jsonObject = response.getJSONObject(i);
                    System.out.println("length:::::"+i);
                    String title = jsonObject.getString("title");
                    /*JSONArray detail = jsonObject.getJSONArray("detail");
                    for (int j = 0; j < detail.length(); j++) {
                        System.out.println("length j++++"+ j);
                        JSONObject jsonObject1 = detail.getJSONObject(0);

                        titleDetail = jsonObject1.getString("title");
                        detailDetail = jsonObject1.getString("detail");
                        imageDetail = jsonObject1.getString("image");
                        award = jsonObject1.getString("award");
                        experience = jsonObject1.getString("experian");
                    }

                     */
                    System.out.println("length: "+response.length());

                    MajorModel majorModel = new MajorModel(title);
                    listMajor.add(majorModel);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

                majorRecAdapter = new MajorRecAdapter(getActivity(), listMajor);
                binding.recyclerviewMajorList.setAdapter(majorRecAdapter);

            }

        },
                error -> {
                    Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println(error.getMessage());
                });

        requestQueue.add(arrayRequest);

    }
}
