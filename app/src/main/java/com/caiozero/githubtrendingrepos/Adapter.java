package com.caiozero.githubtrendingrepos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.caiozero.githubtrendingrepos.activity.Secondary_activity;
import com.caiozero.githubtrendingrepos.models.Trending;

import java.util.ArrayList;
import java.util.List;


public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private ArrayList<Trending> dataset;
    private Context context;

    public Adapter(Context context){
        this.context = context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_detail,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final Trending t = dataset.get(position);

        holder.textViewName.setText(t.getName());
        holder.textViewAuthor.setText(t.getAuthor());
        holder.textViewStars.setText(t.getStars());
        holder.textViewForks.setText(t.getForks());
        holder.textViewurl.setText(t.getForks());

        Glide.with(context)
                .load(t.getAvatar())
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageButton);

        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
        /*Aqui eh o seguinte:
        /* Primeiro tem que criar um Objeto Intent para poder ter acesso a outra activity
        /* Esse objeto tem como parametro o getApplicationContext e depois o nome da outra
        /* activity.class*/
        Intent intent = new Intent(context, Secondary_activity.class);

       /*Agora deve se passar esse valor obtido e transferir para outra activity, primeiramente
       * armazenando esse valor*/
        intent.putExtra("Autor",t.getAuthor());
        intent.putExtra("Name",t.getName());
        intent.putExtra("Stars",t.getStars());
        intent.putExtra("Fork",t.getForks());
        intent.putExtra("Avatar",t.getAvatar());
        intent.putExtra("Url",t.getUrl());

        Toast.makeText(context,"For more Details, click on Icon",Toast.LENGTH_SHORT).show();
        /*Feito isso, basta dar o start nesse objeto, que agora eh a outra activity*/
        context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void adicionarLista(List<Trending> t) {
        dataset.addAll(t);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView textViewAuthor;
        private TextView textViewName;
        private TextView textViewStars;
        private TextView textViewForks;
        private TextView textViewurl;
        private ImageButton imageButton;

        public ViewHolder(View itemView){
            super(itemView);
            textViewAuthor = itemView.findViewById(R.id.tvAuthor);
            textViewName = itemView.findViewById(R.id.tvName);
            textViewStars = itemView.findViewById(R.id.tvStars);
            textViewForks = itemView.findViewById(R.id.tvForks);
            imageButton = itemView.findViewById(R.id.imageButton);
            textViewurl = itemView.findViewById(R.id.tvUrl);

        }
    }

}

