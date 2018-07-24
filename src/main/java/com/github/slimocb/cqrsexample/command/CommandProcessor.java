package com.github.slimocb.cqrsexample.command;

import com.github.slimocb.cqrsexample.api.Command;
import com.github.slimocb.cqrsexample.message.CommandMessageBus;
import com.github.slimocb.cqrsexample.message.SimpleMessageBus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class CommandProcessor implements Runnable {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final CommandMessageBus commandMessageBus;
    private final SimpleCommandDispatcher commandDispatcher;

    public CommandProcessor(CommandMessageBus commandMessageBus, SimpleCommandDispatcher commandDispatcher) {
        this.commandMessageBus = commandMessageBus;
        this.commandDispatcher = commandDispatcher;
        this.executorService.execute(this);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Command command = commandMessageBus.poll();
                commandDispatcher.dispatchCommand(command);
            } catch (Exception e) {
                log.error("Error while processing command", e);
            }
        }
    }
}
