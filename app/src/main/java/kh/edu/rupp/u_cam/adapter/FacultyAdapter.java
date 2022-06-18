package kh.edu.rupp.u_cam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.models.DetailModel;
import kh.edu.rupp.u_cam.models.FacultyModel;

public class FacultyAdapter extends RecyclerView.Adapter<FacultyAdapter.viewHolder> {

    ArrayList<String> list;

    public FacultyAdapter(ArrayList<String> list, Context context) {
        this.list = list;
    }

    Context context;

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faculty_component, parent ,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        //FacultyModel facultyModel = list.get(position);
        holder.facultyName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{

//        TextView textViewList;
        TextView facultyName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
//            textViewList = itemView.findViewById(R.id.home_faculty);
            facultyName = itemView.findViewById(R.id.home_faculty);
        }

    }


}
