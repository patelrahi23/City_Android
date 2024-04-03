package com.rahi.cityguide.HelperClasses.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rahi.cityguide.R;

import java.util.ArrayList;

public class categoriesAdapter extends RecyclerView.Adapter<categoriesAdapter.categoriesViewHlolder> {

    ArrayList<categoriesHelperClass> categoriesLocation;



    public categoriesAdapter(ArrayList<categoriesHelperClass> categoriesLocation) {
        this.categoriesLocation = categoriesLocation;
    }

    @NonNull
    @Override
    public categoriesViewHlolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design,parent,false);
        categoriesViewHlolder categoriesViewHlolder = new categoriesViewHlolder(view);
        return categoriesViewHlolder;
    }

    @Override
    public void onBindViewHolder(@NonNull categoriesViewHlolder holder, int position) {

        categoriesHelperClass chc = categoriesLocation.get(position);
        holder.image.setImageResource(chc.getImage());
        holder.title.setText(chc.getTitle());
        if(position==1) {
            holder.categories_rel.setBackgroundResource(R.drawable.card_1);
        }
        else if(position==2) {
            holder.categories_rel.setBackgroundResource(R.drawable.card_2);
        }
       else if(position==3) {
            holder.categories_rel.setBackgroundResource(R.drawable.card_3);
        }
        else {
            holder.categories_rel.setBackgroundResource(R.drawable.card_4);
        }
    }

    @Override
    public int getItemCount() {
        return categoriesLocation.size();
    }


    public static class categoriesViewHlolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        RelativeLayout categories_rel;

        public categoriesViewHlolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.categories_image);
            title = itemView.findViewById(R.id.categories_title);
            categories_rel = itemView.findViewById(R.id.categories_rel);

        }
    }
}
