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
public class MarksButton extends TelegramLongPollingBot {
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
        if (callbackData.equals("Марки")) {
            sendMarks(chatId);
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

    public void sendMarks(long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(
            "\uD83C\uDDEF\uD83C\uDDF5 `Acura`\n_Соітіро Хонда - 1986 рік_\n" +
            "Північноамериканський підрозділ японського концерну Honda, " +
            "який спеціалізується на виробництві люксових та спортивних автомобілів.\n\n" +
            "\uD83C\uDDEE\uD83C\uDDF9 `Alfa Romeo`\n_Нікола Ромео - 1910 рік_\n" +
            "Легендарна італійська марка, заснована в Мілані в 1910 році. " +
            "У ранні роки вона спеціалізувалася на виробництві дорогих " +
            "автомобілів із високими динамічними показниками.\n\n" +
            "\uD83C\uDDEC\uD83C\uDDE7 `Aston Martin`\n_Лайонел Мартін - 1913 рік_\n" +
            "Компанія Aston Martin випускала британські спортивні " +
            "автомобілі вищого класу протягом всієї своєї 100-річної історії.\n\n" +
            "\uD83C\uDDE9\uD83C\uDDEA `Audi`\n_Август Хорьх - 1909 рік_\n" +
            "Німецька компанія Audi зробила значний внесок у розвиток світового " +
            "автомобілебудування, дотримуючись гасла \"Перевага через технології\". " +
            "У 1932 році Audi разом із трьома іншими виробниками увійшла до складу концерну " +
            "Auto Union, звідки й отримала емблему у вигляді чотирьох кілець.\n\n" +
            "\uD83C\uDDEC\uD83C\uDDE7 `Bentley`\n_Волтер Бентлі - 1919 рік_\n" +
            "Такі машини однаково підходили як для гоночних заїздів, так і для повсякденного " +
            "використання, що цінувалися багатими британськими автомобілістами.\n\n" +
            "\uD83C\uDDE9\uD83C\uDDEA `BMW`\n_Фріц Фідлер - 1916 рік_\n" +
            "_Bayerische Motoren Werke - Баварський моторний завод_\n" +
            "У 30-ті роки BMW намагалася конкурувати з Mercedes-Benz на ринку " +
            "люксових автомобілів, а заразом демонструвала перевагу німецької " +
            "техніки на гоночних трасах за допомогою спортивної моделі BMW 328.\n\n" +
            "\uD83C\uDDEB\uD83C\uDDF7 `Bugatti`\n_Етторе Бугатті - 1909 рік_\n" +
            "В основі перших моделей Bugatti лежало просте та легке шасі у поєднанні " +
            "з потужним двигуном. Така конструкція застосовувалася як на серійних, " +
            "так і на гоночних машинах, забезпечуючи останнім переваги у змаганнях.\n\n" +
            "\uD83C\uDDFA\uD83C\uDDF8 `Cadillac`\n_Генрі Леланд - 1902 рік_\n" +
            "\"Світовий стандарт\" - так компанію Cadillac охрестили ще на зорі її розвитку, " +
            "і вона відповідала цьому званню протягом багатьох років, будучи найбільшим " +
            "автовиробником в США. У 1909 році Cadillac увійшов до складу концерну " +
            "General Motors і з того часу є його люксовим підрозділом.\n\n" +
            "\uD83C\uDDFA\uD83C\uDDF8 `Chevrolet`\n_Луї Шевроле - 1911 рік_\n" +
            "Спочатку під маркою Chevrolet випускалися відносно дорогі машини, " +
            "але в 20-ті роки президент GM Альфред Слоун поставив Chevrolet " +
            "на нижчу сходинку у своїй ціновій ієрархії, і за нею закріпився імідж " +
            "бюджетного бренду з \"недорогої трійки\" (Ford, Chevrolet та Plymouth).\n\n" +
            "\uD83C\uDDFA\uD83C\uDDF8 `Chrysler`\n_Волтер Крайслер - 1925 рік_\n" +
            "Американський автовиробник №3, що входить до складу " +
            "\"Великої детройтської трійки\" поряд із General Motors та Ford. " +
            "Підприємство було створено Волтером Крайслером у 1925 році " +
            "на основі придбаної ним компанії Maxwell.\n\n" +
            "\uD83C\uDDEB\uD83C\uDDF7 `Citroen`\n_Андре-Гюстав Сітроєн - 1919 рік_\n" +
            "Компанія Citroen була заснована в 1919 році на набережній Quai de Javel " +
            "у 15-му окрузі Парижа, неподалік Ейфелевої вежі. Її власник Андре Сітроєн був " +
            "авантюристом та азартним гравцем, але завдяки вмінням домовлятися з кредиторами, " +
            "купувати чужі патенти та рекламувати свою продукцію він став " +
            "найбільшим автовиробником у Європі.\n\n");
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