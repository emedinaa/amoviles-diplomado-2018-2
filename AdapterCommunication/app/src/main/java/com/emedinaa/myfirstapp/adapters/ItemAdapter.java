package com.emedinaa.myfirstapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.listeners.OnItemListener;
import com.emedinaa.myfirstapp.model.Item;

import java.util.List;

/**
 * Created by emedinaa on 30/09/17.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private final List<Item> items;
    private final Context context;
    private final OnItemListener onItemListener;

    public ItemAdapter(Context context, List<Item> mItems){
        this.context= context;
        this.items = mItems;
        this.onItemListener = null;
    }

    public ItemAdapter(Context context, OnItemListener mOnItemClickListener, List<Item> mItems) {
        this.context= context;
        this.items = mItems;
        this.onItemListener = mOnItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - replace the contents of the view with that element
        final Item item= items.get(position);

        final int itemPosition= position;
        final String itemTitle=item.getTitle();

        holder.tviTitle.setText(itemTitle);

        holder.iviFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Toast.makeText(context, "Item from Adapter "+
                        item.toString(), Toast.LENGTH_SHORT).show();*/
                //((ListItemsActivity)context).seleccioneItem(item);

                if(onItemListener!=null){
                    Log.v("ADAPTER", "iviPhoto "+holder.iviFavorite);
                    onItemListener.onItemClickListener(item);
                }
            }
        });
        /*holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(onItemListener!=null){
                    Log.v("ADAPTER", "iviPhoto "+holder.iviPhoto);
                    onItemListener.onItemClickListener(item);
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tviTitle;
        public ImageView iviFavorite;
        public View view;
        public ViewHolder(View  v) {
            super(v);
            this.view = v;
            tviTitle= v.findViewById(R.id.tviTitle);
            iviFavorite=  v.findViewById(R.id.iviFavorite);
        }
    }
}
