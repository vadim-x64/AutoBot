package project.ua.autobot.properties;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import project.ua.autobot.components.TelegramBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@AllArgsConstructor
public class Initialize {
    public TelegramBot b;

    @EventListener({ContextRefreshedEvent.class})

    public void init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(b);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}