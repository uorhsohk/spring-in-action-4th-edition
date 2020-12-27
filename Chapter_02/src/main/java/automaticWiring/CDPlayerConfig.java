package main.java.automaticWiring;

import main.java.soundsystem.SoundSystemMarker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = SoundSystemMarker.class)
public class CDPlayerConfig {
}
