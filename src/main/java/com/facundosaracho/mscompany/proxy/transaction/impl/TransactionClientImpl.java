package com.facundosaracho.mscompany.proxy.transaction.impl;

import com.facundosaracho.mscompany.config.TransactionApiRetrofitConfig;
import com.facundosaracho.mscompany.proxy.transaction.TransactionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.util.List;

import static com.facundosaracho.mscompany.config.RestClientConfig.checkCall;
import static com.facundosaracho.mscompany.config.RestClientConfig.validateResponse;

@Service
@RequiredArgsConstructor
public class TransactionClientImpl implements TransactionClient {

    private final TransactionApiRetrofitConfig client;

    @Override
    public List<Long> getLastCompaniesThatMadeTransactions(LocalDateTime filterDate) {
        Call<List<Long>> call = client.getLastTransactions(filterDate);
        return validateResponse(checkCall(call)).body();
    }

}
