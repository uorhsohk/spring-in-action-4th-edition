package main.com.springinaction.config;

import main.com.springinaction.knights.BraveKnight;
import main.com.springinaction.knights.Knight;
import main.com.springinaction.knights.Quest;
import main.com.springinaction.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KnightConfig {
    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }
}
