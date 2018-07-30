package org.bkiebdaj.cqrsexample.domain.service.accountpresentation;

import org.bkiebdaj.cqrsexample.domain.event.payload.AccountCreated;
import org.bkiebdaj.cqrsexample.domain.event.payload.AccountMoneyAmountDecreased;
import org.bkiebdaj.cqrsexample.domain.event.payload.AccountMoneyAmountIncreased;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class AccountPresentationService {
    private final AccountRepository accountRepository = new AccountRepository();

    public void handle(AccountCreated event) {
        AccountEntity accountEntity = new AccountEntity(event.getAggregadeId().getId().toString(), event.getAccountNumber(), BigDecimal.ZERO);
        accountRepository.save(accountEntity);
    }

    public void handle(AccountMoneyAmountIncreased event) {
        AccountEntity accountEntity = accountRepository.findById(event.getAggregadeId().getId().toString());
        accountEntity.increaseAmount(event.getAmount());
    }

    public void handle(AccountMoneyAmountDecreased event) {
        AccountEntity accountEntity = accountRepository.findById(event.getAggregadeId().getId().toString());
        accountEntity.decreaseAmount(event.getAmount());
    }

    public List<AccountEntity> getAllAccounts() {
        return accountRepository.findAll();
    }
}
