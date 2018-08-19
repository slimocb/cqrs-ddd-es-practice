package org.bkiebdaj.cqrsexample.domain.command.handler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bkiebdaj.cqrsexample.core.api.CommandHandler;
import org.bkiebdaj.cqrsexample.domain.account.Account;
import org.bkiebdaj.cqrsexample.domain.account.AccountRepository;
import org.bkiebdaj.cqrsexample.domain.command.PayIntoAccountCommand;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PayIntoAccountCommandHandler implements CommandHandler<PayIntoAccountCommand> {

    private final AccountRepository accountRepository;

    @Override
    public void handle(PayIntoAccountCommand command) {
        log.info("Handle command: {}", command);
        Account account = accountRepository.load(command.getAccountId());
        account.payInto(command.getAmount());
        accountRepository.persist(account);
    }
}
