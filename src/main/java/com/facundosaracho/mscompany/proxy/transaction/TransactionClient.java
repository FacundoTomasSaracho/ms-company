package com.facundosaracho.mscompany.proxy.transaction;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionClient {

    List<Long> getLastCompaniesThatMadeTransactions(LocalDateTime filterDate);
}
