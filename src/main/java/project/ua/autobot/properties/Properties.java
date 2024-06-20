package project.ua.autobot.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Setter
@Getter
@Configuration
@PropertySource("/application.properties")
public class Properties {
    private Locale language;

    @Value("${bot.name}")
    String botName;

    @Value("${bot.token}")
    String botToken;
}