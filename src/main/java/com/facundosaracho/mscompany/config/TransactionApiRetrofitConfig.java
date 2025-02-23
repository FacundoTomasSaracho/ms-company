package com.facundosaracho.mscompany.config;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionApiRetrofitConfig {

    @GET("transactions")
    Call<List<Long>> getLastTransactions(@Query("filter_date") LocalDateTime filterDate);
}
