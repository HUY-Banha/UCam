package kh.edu.rupp.u_cam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.models.MajorModel;
import kh.edu.rupp.u_cam.models.UniversityModel;

public class MajorRecAdapter extends RecyclerView.Adapter<MajorRecAdapter.viewHolder>  {


    ArrayList<MajorModel> list;
    Context context;

    public MajorRecAdapter(Context context, ArrayList<MajorModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MajorRecAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_major, parent ,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MajorRecAdapter.viewHolder holder, int position) {
        MajorModel majorModel = list.get(position);
        holder.textName.setText(majorModel.getTitleMajor());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView textName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.major_name);
        }
    }
}