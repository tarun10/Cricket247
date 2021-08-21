package com.learning.cricket247.remoteconnection;


import com.learning.cricket247.home.viewmodel.MatchOddsModel;
import com.learning.cricket247.model.LiveMatchModel;
import com.learning.cricket247.model.MatchPojo;
import com.learning.cricket247.model.players.AllPlayersInfo;
import com.learning.cricket247.model.seriesdata.LiveSeries;
import com.learning.cricket247.model.seriesdata.PointTableModel;
import com.learning.cricket247.model.stats.MatchStats;

import java.util.ArrayList;
import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("upcomingMatches")
    Observable<MatchPojo> upcomingData();

    @GET("LiveLine")
    Observable<ArrayList<LiveMatchModel>> getLiveData();

    @GET("LiveSeries")
    Observable<ArrayList<LiveSeries>> getAllSeries();

    @POST("MatchResults")
    Call<MatchPojo> getFinishedData(@Body HashMap<String, String> stringStringHashMap);

    @POST("LiveLine_Match")
    Observable<ArrayList<LiveMatchModel>> getMatchInfor(@Body HashMap<String, String> stringStringHashMap);

    @POST("GetAllPlayers")
    Observable<AllPlayersInfo> GetAllPlayers(@Body HashMap<String, String> stringStringHashMap);

    @POST("SeriesMatches")
    Observable<ArrayList<LiveMatchModel>> getSelectedSeries(@Body HashMap<String, String> stringStringHashMap);

    @POST("Pointstable")
    Observable<PointTableModel> getPontTable(@Body HashMap<String, String> stringStringHashMap);


    @POST("MatchOdds")
    Observable<MatchOddsModel> GetMatchOdds(@Body HashMap<String, String> stringStringHashMap);

    @POST("MatchStats")
    Observable<MatchStats> getMatchStats(@Body HashMap<String, String> stringStringHashMap);

}
