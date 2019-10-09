package com.caiozero.githubtrendingrepos.api;

import com.caiozero.githubtrendingrepos.models.Trending;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GitServiceWeekly {

    String Base_Url = "https://github-trending-api.now.sh/";
    @GET("repositories?since=weekly")
    Call<List<Trending>> listTrending();
}
