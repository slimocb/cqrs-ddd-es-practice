package org.bkiebdaj.cqrsexample.domain.command;

import lombok.Value;
import org.bkiebdaj.cqrsexample.api.Command;

@Value
public class SendMailToUserCommand implements Command {
}