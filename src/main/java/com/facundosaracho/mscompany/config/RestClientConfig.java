package com.facundosaracho.mscompany.config;

import com.facundosaracho.mscompany.exception.RestException;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;

import static com.facundosaracho.mscompany.exception.ExceptionCode.RETROFIT_EXCEPTION;

@Configuration
@Slf4j
public class RestClientConfig {


    @Bean
    Retrofit retrofitConfigurationTransactionApi() {
        // todo properties
        String BASE_URL = "http://localhost:8081/ms-transaction/v1/";
        return new Retrofit.Builder().baseUrl(BASE_URL).client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Bean
    public TransactionApiRetrofitConfig config(Retrofit retrofit) {
        return retrofit.create(TransactionApiRetrofitConfig.class);
    }

    public static Response<List<Long>> validateResponse(Response<List<Long>> responseResponse) {
        if (responseResponse == null || !responseResponse.isSuccessful()) {
            log.error("Exception: {}", responseResponse.errorBody().toString());
            throw new RestException(RETROFIT_EXCEPTION);
        }
        return responseResponse;
    }

    public static <R> Response<R> checkCall(Call<R> call)  {
        try {
            return call.execute();
        } catch (Exception e) {
            log.error("ERROR :{} ", e.getMessage());
            throw new RestException(RETROFIT_EXCEPTION);
        }
    }
}
