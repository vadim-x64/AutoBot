package project.ua.autobot.components;

import lombok.AllArgsConstructor;
import project.ua.autobot.properties.Keyboard;
import project.ua.autobot.properties.Properties;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;

@AllArgsConstructor
@Component
public class PrincipleButton extends TelegramLongPollingBot {
    private final Properties c;

    @Override
    public String getBotUsername() {
        return c.getBotName();
    }

    @Override
    public String getBotToken() {
        return c.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        String callbackData = callbackQuery.getData();
        long chatId = callbackQuery.getMessage().getChatId();
        if (callbackData.equals("Принцип роботи")) {
            sendPrinciple(chatId);
        } else if (callbackData.equals("close")) {
            deleteMessage(chatId, callbackQuery.getMessage().getMessageId());
        }
    }

    public void deleteMessage(long chatId, int messageId) {
        DeleteMessage deleteMessage = new DeleteMessage();
        deleteMessage.setChatId(String.valueOf(chatId));
        deleteMessage.setMessageId(messageId);
        try {
            execute(deleteMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendPrinciple(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(
            "_В даному розділі, Вам буде пояснено як працює автомобіль._\n\n" +
            "Перед тим, як наважитися сісти за кермо, Ви повинні пройти декілька підготовчих етапів. " +
            "Зрозуміло, що для початку Ви маєте вивчити, знати і дотримуватись ПДР, а також розуміти " +
            "де Ви знаходитесь і як треба поводитися на дорозі. Все це можна почитати в інтернеті, " +
            "знайти відповідну літературу, запитати поради в досвідченого водія і так далі. " +
            "Поза цим всім, головне, що треба взяти до уваги - це хоч трохи " +
            "розібратися і зрозуміти, як взагалі влаштоване авто та як воно те все працює.\n\n" +

            "Зрозуміла річ, що дуже багато деталей, механізмів, і важко відразу все сприйняти " +
            "та зрозуміти. Але на те є я, `AutoBot`, щоб Вам розкласти все по полицях, " +
            "в свою чергу, зробити так, щоб Ви послідовно та легко підходили до цієї " +
            "теми та керували авто із задоволенням. А це головне, бо якщо їхати і від " +
            "цього не отримувати користі, то навіщо воно взагалі треба? " +
            "Отож, просто читайте що написано, і все у Вас складатиметься чудово 😉\n\n" +

            "Як Ви вже знаєте, серцем автомобіля є двигун. Саме від нього " +
            "залежить доля вашої машини, і за ним як за дитиною - треба ретельний догляд, " +
            "щоб все працювало чітко і без нарікань. Тоді машина прослужить довгий час " +
            "і не буде завдавати дорожньої обстановки \uD83D\uDC4C\n\n" +

            "👉 `Першим ділом треба завести двигун`\nЗапуск двигуна бере свій початок від стартера. " +
            "Це що не на є механізм, призначений для обертання колінчастого вала. " +
            "Тобто він кріпиться на картері маховика двигуна таким чином, " +
            "що якір з шестірнею виступають і прилягають до маховика. " +
            "Після того, як ми робимо запуск, якір починає крутитися і " +
            "шестерня прилягаючи до маховика, запускає його. Після чого " +
            "двигун працює на холостих оборотах. Зазвичай це приблизно " +
            "200 об/хв для дизельного типу.\n\n" +

            "👉 `З'єднуємо двигун із платформою ТЗ`\nДалі, якщо не описувати кожен механізм " +
            "авто, то все дуже просто та послідовно. Транспорт " +
            "рухається внаслідок передачі крутного моменту " +
            "від самого двигуна до ведучих коліс. Щоб передати " +
            "його, треба з'єднати ДВЗ з трансмісією. " +
            "Тобто вижати зчеплення, увімкнути першу передачу " +
            "та, плавно його опускаючи, додавати газу. Від колінчастого " +
            "валу момент іде на коробку передач, а далі вже на карданну передачу.\n\n" +

            "👉 `Процес передавання та приведення коліс у дію`\nПісля карданної " +
            "момент іде на головну передачу, яка передає " +
            "його під прямим кутом на диференціал. " +
            "Диференціал розподіляє цей момент між вихідними " +
            "валами, тим самим передає вже його на ведучі колеса " +
            "та відповідно рухає автомобіль.\n\n" +

            "\uD83E\uDDD0 У висновку, хочеться сказати, що все в принципі не складно. " +
            "Основна суть - передавання крутного моменту за допомогою різних " +
            "систем та механізмів, робота яких має бути узгодженою.\n\n" +

            "_P.S. Рекомендую перед початком їзди вивчити такі речі, щоб навчитися " +
            "потім відчувати машину і їздити в задоволення. Як, що і до чого, " +
            "перемикання передач, техніка управління та інші відомості " +
            "будуть описані та доступні у розділі_\n`Основи керування`\n\n" +
            "_Бажаю удачі на дорозі!_ \uD83D\uDE0E");
        sendMessage.setReplyMarkup(Keyboard.createCloseButtonKeyboard());
        sendMessage.enableMarkdown(true);
        try {
            Message sentMessage = execute(sendMessage);
            int sentMessageId = sentMessage.getMessageId();
            deleteMessage(chatId, sentMessageId - 1);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}