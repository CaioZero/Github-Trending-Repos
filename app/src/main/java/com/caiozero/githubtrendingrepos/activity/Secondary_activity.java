package com.caiozero.githubtrendingrepos.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.caiozero.githubtrendingrepos.R;

public class Secondary_activity extends AppCompatActivity {

    private TextView autor;
    private TextView name;
    private TextView stars;
    private TextView forks;
    private ImageButton urlAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_activity);

        autor = findViewById(R.id.tvAuthor);
        name = findViewById(R.id.tvName);
        stars = findViewById(R.id.tvStars);
        forks = findViewById(R.id.tvForks);
        urlAvatar = findViewById(R.id.imageButton);

       Bundle dados = getIntent().getExtras();
       /*Getting data by Call*/
       String autorIntent = dados.getString("Autor");
       String nameIntent = dados.getString("Name");
       String starsIntent = dados.getString("Stars");
       String forksIntent = dados.getString("Fork");
       String avatar = dados.getString("Avatar");
       final String url = dados.getString("Url");

       /*Object Glide to get avatar and load on imageButton*/
       Glide.with(getApplicationContext())
           .load(avatar)
           .centerCrop()
           .diskCacheStrategy(DiskCacheStrategy.ALL)
           .into(urlAvatar);

       autor.setText("Author: "+autorIntent);
       name.setText("Repository name: "+nameIntent);
       stars.setText("Stars: "+ starsIntent);
       forks.setText("Forks: "+ forksIntent);

        urlAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Openning Github Repository Page",Toast.LENGTH_SHORT).show();
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url));
                startActivity(browserIntent);

            }
        });
    }

}
