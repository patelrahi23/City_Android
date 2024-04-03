package com.rahi.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahi.cityguide.R;

import java.util.ArrayList;

public class MVAdapter extends RecyclerView.Adapter<MVAdapter.MVViewHolder> {

    ArrayList<MVHelperClass> MVLocations;

    public MVAdapter(ArrayList<MVHelperClass> MVLocations) {
        this.MVLocations = MVLocations;
    }

    @NonNull
    @Override
    public MVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.most_viewed_card_design,parent,false);
        MVViewHolder mvViewHolder =  new MVViewHolder(view);
        return mvViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MVViewHolder holder, int position) {
       // FeaturedHelperClass featuredHelperClass = featuredLocations.get(position);
        MVHelperClass mvHelperClass = MVLocations.get(position);
        holder.image1.setImageResource(mvHelperClass.getImage());
        holder.title1.setText(mvHelperClass.getTitle());
        holder.desc1.setText(mvHelperClass.getDescription());
    }

    @Override
    public int getItemCount() {
        return MVLocations.size();
    }


    public static class MVViewHolder extends RecyclerView.ViewHolder {
        ImageView image1;
        TextView title1,desc1;

        public MVViewHolder(@NonNull View itemView) {
            super(itemView);
            image1 = itemView.findViewById(R.id.most_viewed_image);
            title1 = itemView.findViewById(R.id.most_viewed_title);
            desc1 = itemView.findViewById(R.id.most_viewed_description);

        }
    }
}
