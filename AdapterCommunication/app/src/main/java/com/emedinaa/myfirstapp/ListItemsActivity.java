package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapters.ItemAdapter;
import com.emedinaa.myfirstapp.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 7/7/18
 */
public class ListItemsActivity extends AppCompatActivity {

    private List<Item> items;
    private ItemAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        ui();
        loadItems();
    }

    private void loadItems() {
        items= new ArrayList<>();
        items.add(new Item("Item 1"));
        items.add(new Item("Item 2"));
        items.add(new Item("Item 3"));
        items.add(new Item("Item 4"));
        items.add(new Item("Item 5"));

        //render items
        adapter= new ItemAdapter(this,items);
        recyclerView.setAdapter(adapter);
    }

    private void ui(){
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //events
        /*recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(adapter!=null && items!=null){
                    Item item= items.get(position);
                    selectedItem(item);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));*/
    }

    private void selectedItem(Item item){
        Toast.makeText(this, "item "+item.toString(), Toast.LENGTH_SHORT).show();
    }
}
