package com.caiozero.githubtrendingrepos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.caiozero.githubtrendingrepos.Adapter;
import com.caiozero.githubtrendingrepos.R;

import com.caiozero.githubtrendingrepos.api.GitServiceDaily;
import com.caiozero.githubtrendingrepos.api.GitServiceMonthly;
import com.caiozero.githubtrendingrepos.api.GitServiceWeekly;
import com.caiozero.githubtrendingrepos.models.Trending;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    public static final String TagApi = "API_ERROR";
    public static final String TagNet = "NET_ERROR";
    public static final String TagErro = "ERROR";
    String url;
    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();

        /*Get option if the requested mode it`s daily, weekly or monthly*/
        try {
            String option = bundle.getString("Op");
            if (option.equalsIgnoreCase("Daily")) {
                url = GitServiceDaily.Base_Url;
                createRecyclerView(this);
                createCall(createRetrofit(url), "Daily");

            } else if ((option.equalsIgnoreCase("Weekly"))) {
                url = GitServiceWeekly.Base_Url;
                createRecyclerView(this);
                createCall(createRetrofit(url), "Weekly");
            } else {
                url = GitServiceMonthly.Base_Url;
                createRecyclerView(this);
                createCall(createRetrofit(url), "Monthly");
            }
            }
            catch(Exception e){
                Log.e(TagErro,"Exception error "+e.getMessage());
            }
        }

    public Retrofit createRetrofit(String url) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

    public void createRecyclerView(Context context) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter(context);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void createCall(Retrofit retrofit, String gitServiceType) {
        /*Async Callback*/
        /*Create Class to receive Gson Object*/
        if (gitServiceType.equalsIgnoreCase("Daily")) {
            GitServiceDaily service = retrofit.create(GitServiceDaily.class);
            Call<List<Trending>> call = service.listTrending();

            call.enqueue(new Callback<List<Trending>>() {
                @Override
                public void onResponse(Call<List<Trending>> call, Response<List<Trending>> response) {
                    if(!response.isSuccessful()) {
                        Log.e(TagApi, "Api connection has failed ");
                    } else {
                        List<Trending> t = response.body();
                        adapter.adicionarLista(t);
                    }
                }
                @Override
                public void onFailure(Call<List<Trending>> call, Throwable t) {
                    Log.e(TagNet, "Network Failure " + t.getMessage());
                }
            });
        } else if (gitServiceType.equalsIgnoreCase("Weekly")) {
            GitServiceWeekly service = retrofit.create(GitServiceWeekly.class);
            Call<List<Trending>> call = service.listTrending();
            call.enqueue(new Callback<List<Trending>>() {
                @Override
                public void onResponse(Call<List<Trending>> call, Response<List<Trending>> response) {
                    if(!response.isSuccessful()) {
                        Log.e(TagApi, "Api connection has failed ");
                    } else {
                        List<Trending> t = response.body();
                        adapter.adicionarLista(t);
                    }
                }
                @Override
                public void onFailure(Call<List<Trending>> call, Throwable t) {
                    Log.e(TagNet, "Network Failure " + t.getMessage());
                }
            });
        }else{
            GitServiceMonthly service = retrofit.create(GitServiceMonthly.class);
            Call<List<Trending>> call = service.listTrending();
            call.enqueue(new Callback<List<Trending>>() {
                @Override
                public void onResponse(Call<List<Trending>> call, Response<List<Trending>> response) {
                    if (!response.isSuccessful()) {
                        Log.e(TagApi, "Api connection has failed ");
                    } else {
                        List<Trending> t = response.body();
                        adapter.adicionarLista(t);
                    }
                }
                @Override
                public void onFailure(Call<List<Trending>> call, Throwable t) {
                    Log.e(TagNet, "Network Failure " + t.getMessage());
                }
            });
        }
    }
}


