package com.github.slimocb.cqrsexample.domain.action;

import com.github.slimocb.cqrsexample.api.EventHandler;
import com.github.slimocb.cqrsexample.domain.event.AccountMoneyAmountDecreasedEvent;
import com.github.slimocb.cqrsexample.domain.event.AccountMoneyAmountIncreasedEvent;
import com.github.slimocb.cqrsexample.domain.service.accountpresentation.AccountPresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountEntityDecreaseAmount implements EventHandler<AccountMoneyAmountDecreasedEvent> {

    private final AccountPresentationService accountPresentationService;

    @Override
    public void handle(AccountMoneyAmountDecreasedEvent event) {
        accountPresentationService.handle(event);
    }
}