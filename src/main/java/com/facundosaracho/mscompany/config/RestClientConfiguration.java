package com.facundosaracho.mscompany.config;

import com.facundosaracho.mscompany.exception.RetrofitException;
import com.facundosaracho.mscompany.proxy.transaction.TransactionApi;
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

import java.util.List;
import java.util.Optional;

import static com.facundosaracho.mscompany.exception.ExceptionCode.RETROFIT_EXCEPTION;

@Configuration
@Slf4j
public class RestClientConfiguration {

    @Value("${http-client.ms-transaction.base-url}")
    private String baseUrl;

    @Bean
    Retrofit retrofitConfigurationTransactionApi() {
        return new Retrofit.Builder().baseUrl(baseUrl).client(new OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Bean
    public TransactionApi config(Retrofit retrofit) {
        return retrofit.create(TransactionApi.class);
    }

    public static Response<List<Long>> validateResponse(Response<List<Long>> responseResponse) {
        if (responseResponse == null || !responseResponse.isSuccessful()) {
            log.error("Exception: {}", Optional.of(responseResponse.errorBody().toString())
                    .orElse("No extra information."));
            throw new RetrofitException(RETROFIT_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseResponse;
    }

    public static <T> Response<T> checkCall(Call<T> call) {
        try {
            return call.execute();
        } catch (Exception e) {
            log.error("ERROR :{} ", e.getMessage());
            throw new RetrofitException(RETROFIT_EXCEPTION, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
