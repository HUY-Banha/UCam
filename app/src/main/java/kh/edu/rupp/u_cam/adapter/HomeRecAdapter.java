package kh.edu.rupp.u_cam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import kh.edu.rupp.u_cam.R;
import kh.edu.rupp.u_cam.models.UniversityModel;

public class HomeRecAdapter extends RecyclerView.Adapter<HomeRecAdapter.viewHolder>  {


    ArrayList<UniversityModel> list;
    Context context;

    public HomeRecAdapter(Context context, ArrayList<UniversityModel> list) {
        this.list = list;
        this.context = context;

    }

    @NonNull
    @Override
    public HomeRecAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_university, parent ,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRecAdapter.viewHolder holder, int position) {
        UniversityModel universityModel = list.get(position);
//        holder.imageLogo.setImageResource(universityModel.getImageLogo());
        holder.textName.setText(universityModel.getUniversityName());
        holder.textPlace.setText(universityModel.getUniversityPlace());
        Glide.with(context).load(universityModel.getImageLogo()).into(holder.imageLogo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageLogo;
        TextView textName, textPlace;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            imageLogo = itemView.findViewById(R.id.university_logo);
            textName = itemView.findViewById(R.id.university_name);
            textPlace = itemView.findViewById(R.id.university_place);
        }
    }
}