package com.indrap.recycleview;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    String[] products = new String[] {"Windows", "OSX", "Ubuntu"};
    String[] image = new String[] {"http://icons.iconarchive.com/icons/designbolts/free-multimedia/1024/iMac-icon.png", "http://icons.iconarchive.com/icons/paomedia/small-n-flat/1024/sign-check-icon.png", "http://icons.iconarchive.com/icons/graphicloads/colorful-long-shadow/256/Home-icon.png"};
    RecyclerView rv_products;
    RecyclerView.Adapter rv_adapter;
    RecyclerView rv_image;
    RecyclerView.LayoutManager rv_layout_manager;
    ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ////--------Code Recycleview--------

        rv_products = (RecyclerView) findViewById(R.id.rv_products);
        rv_products.setHasFixedSize(true);
        rv_layout_manager = new LinearLayoutManager(this);
        rv_products.setLayoutManager(rv_layout_manager);



        rv_adapter = new MyAdapter(products);

        rv_products.setAdapter(rv_adapter);

        ////-------end recycleview--------
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        private String[] ds_products;
        //private String[] ds_image;

        public class ViewHolder extends RecyclerView.ViewHolder {

            public CardView cv_products;

            public TextView tv_product;
            public ImageView imageview;
            public ViewHolder(View v) {

                super(v);

                cv_products = (CardView)v.findViewById(R.id.cv_products);
                tv_product = (TextView)v.findViewById(R.id.tv_product);
                imageview = (ImageView)v.findViewById(R.id.imageView);

            }

        }



        public MyAdapter(String[] dataset) {

            ds_products = dataset;
            //ds_image = dataset;

        }
        @Override

        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_product, parent, false);

            ViewHolder vh = new ViewHolder(v);

            return vh;

        }
        @Override

        public void onBindViewHolder(ViewHolder holder, int position) {

            holder.tv_product.setText(ds_products[position]);
            Glide.with(MainActivity.this).load(image[position]).into(holder.imageview);
        }



        @Override

        public int getItemCount() {

            return ds_products.length;

        }

    }


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
