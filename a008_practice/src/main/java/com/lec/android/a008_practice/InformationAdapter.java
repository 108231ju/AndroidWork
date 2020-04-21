package com.lec.android.a008_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lec.android.a008_practice.Information;

import java.util.ArrayList;
import java.util.List;

public class InformationAdapter extends RecyclerView.Adapter<InformationAdapter.ViewHoler>{

    List<Information> items = new ArrayList<>();

    static InformationAdapter adapter;

    public InformationAdapter() {this.adapter = this;}

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inf = LayoutInflater.from(parent.getContext());
        View itemView = inf.inflate(R.layout.item, parent, false);

        return new ViewHoler(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        Information item = items.get(position);
        holder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    static class ViewHoler extends RecyclerView.ViewHolder{
        TextView tvName, tvAge, tvAddress;
        ImageButton btnDelItem;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvAge = itemView.findViewById(R.id.tvAge);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            btnDelItem = itemView.findViewById(R.id.btnDelItem);

            btnDelItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.removeItem(getAdapterPosition());
                    adapter.notifyDataSetChanged();
                }
            });

        } // end 생성자

        public void setItem(Information item){
            tvName.setText(item.getName());
            tvAge.setText(Integer.toString(item.getAge()));
            tvAddress.setText(item.getAddress());
        }

    } // end  ViewHolder

    public void addItem(Information item) { items.add(item);}
    public void removeItem(int position){items.remove(position);}

} // end InformationAdapter class