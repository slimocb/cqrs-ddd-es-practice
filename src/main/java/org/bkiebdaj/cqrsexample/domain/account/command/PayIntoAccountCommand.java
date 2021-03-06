package org.bkiebdaj.cqrsexample.domain.account.command;

import lombok.Value;
import org.bkiebdaj.cqrsexample.core.api.Command;
import org.bkiebdaj.cqrsexample.core.common.AggregateId;

import java.math.BigDecimal;

@Value
public class PayIntoAccountCommand implements Command {
    AggregateId accountId;
    BigDecimal amount;
}
