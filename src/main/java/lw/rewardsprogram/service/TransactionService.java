package lw.rewardsprogram.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lw.rewardsprogram.model.Transaction;
import lw.rewardsprogram.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class TransactionService {

    private final TransactionRepository repository;

    public List<Transaction> getTransactions() {
        return repository.findAll().stream().map(entity ->
                Transaction.builder()
                        .customer(entity.getCustomer())
                        .date(entity.getDate())
                        .amount(entity.getAmount())
                        .build()
        ).collect(Collectors.toList());
    }
}
