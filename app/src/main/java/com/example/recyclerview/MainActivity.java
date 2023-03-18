package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.reCycle);

        hashMap=new HashMap<>();
        hashMap.put("title", "amr sonar bangla");
        hashMap.put("Video_id", "5sH2WHxApTE");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title", "ami tomay Valobashi");
        hashMap.put("Video_id", "qJFMlCbV4Pw");
        arrayList.add(hashMap);

        hashMap=new HashMap<>();
        hashMap.put("title", "chirodin tomar akash");
        hashMap.put("Video_id", "kqtD5dpn9C8");
        arrayList.add(hashMap);

        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }
    private class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {

        private class MyViewHolder extends RecyclerView.ViewHolder{

            TextView text;
            ImageView image;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                text = itemView.findViewById(R.id.text);
                image = itemView.findViewById(R.id.image);

            }
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View myView = layoutInflater.inflate(R.layout.recycle,parent,false);

            return new MyViewHolder(myView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String id = hashMap.get("Video_id");
            String url = "https://img.youtube.com/vi/"+id+"/0.jpg";

            holder.text.setText(position+" "+title);
            Picasso.get().load(url).into(holder.image);

            holder.text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (holder.getAdapterPosition()==0) Toast.makeText(MainActivity.this,"buttom"+holder.getAdapterPosition(),  Toast.LENGTH_SHORT).show();
                    if (holder.getAdapterPosition()==1) Toast.makeText(MainActivity.this,"buttom"+holder.getAdapterPosition(),  Toast.LENGTH_SHORT).show();
                    if (holder.getAdapterPosition()==2) Toast.makeText(MainActivity.this,"buttom"+holder.getAdapterPosition(),  Toast.LENGTH_SHORT).show();

                }
            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }


    }
}
