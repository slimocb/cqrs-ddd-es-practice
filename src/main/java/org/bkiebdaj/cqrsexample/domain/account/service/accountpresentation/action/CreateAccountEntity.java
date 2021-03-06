package org.bkiebdaj.cqrsexample.domain.account.service.accountpresentation.action;

import lombok.RequiredArgsConstructor;
import org.bkiebdaj.cqrsexample.core.api.EventHandler;
import org.bkiebdaj.cqrsexample.domain.account.event.AccountCreated;
import org.bkiebdaj.cqrsexample.domain.account.service.accountpresentation.AccountPresentationService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateAccountEntity implements EventHandler<AccountCreated> {

    private final AccountPresentationService accountPresentationService;

    @Override
    public void handle(AccountCreated event) {
        accountPresentationService.handle(event);
    }
}
