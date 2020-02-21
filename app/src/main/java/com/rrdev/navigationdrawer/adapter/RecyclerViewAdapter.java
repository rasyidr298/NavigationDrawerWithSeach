package com.rrdev.navigationdrawer.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.rrdev.navigationdrawer.R;
import com.rrdev.navigationdrawer.activity.DetailActivity;
import com.rrdev.navigationdrawer.model.DataModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<DataModel> mItems;
    ItemListener mListener;

    public class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        TextView name;
        ImageView imageView;

        public ViewHolder (View view){
            super(view);
            name = view.findViewById(R.id.text_item);
            imageView = view.findViewById(R.id.img_item);
            cardView = view.findViewById(R.id.cvItem);
        }
    }

    public RecyclerViewAdapter(Context mContext, ArrayList<DataModel> mItems, ItemListener listener) {
        this.mItems = mItems;
        this.mContext = mContext;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.name.setText(mItems.get(position).getName());
        holder.imageView.setImageResource(mItems.get(position).getImg());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DetailActivity.class);

                // pasing data to Detail Activity
                intent.putExtra("name",mItems.get(position).getName());
                intent.putExtra("desc",mItems.get(position).getDescripstion());
                intent.putExtra("img",mItems.get(position).getImg());

                //startAct
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }


    public interface ItemListener{
        void onItemClick (DataModel pName,int position);
    }

    public void setFilter (ArrayList<DataModel> filterList){
        mItems = new ArrayList<>();
        mItems.addAll(filterList);
        notifyDataSetChanged();
    }

}
