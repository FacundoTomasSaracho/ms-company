package com.facundosaracho.mscompany.proxy.transaction.impl;

import com.facundosaracho.mscompany.proxy.transaction.TransactionApi;
import com.facundosaracho.mscompany.proxy.transaction.TransactionClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.time.LocalDateTime;
import java.util.List;

import static com.facundosaracho.mscompany.config.RestClientConfiguration.checkCall;
import static com.facundosaracho.mscompany.config.RestClientConfiguration.validateResponse;

@Service
@RequiredArgsConstructor
public class TransactionClientImpl implements TransactionClient {

    private final TransactionApi transactionApi;

    @Override
    public List<Long> getLastCompaniesThatMadeTransactions(LocalDateTime filterDate) {
        Call<List<Long>> call = transactionApi.getLastTransactions(filterDate);
        return validateResponse(checkCall(call)).body();
    }

}
