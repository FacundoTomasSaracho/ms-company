package com.facundosaracho.mscompany.business.service;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionService {

    List<Long> getLastCompaniesThatMadeTransactions(LocalDateTime filterDate);
}
