package test.java.soundsystem;

import main.java.automaticWiring.CDPlayerConfig;
import main.java.soundsystem.CompactDisc;
import main.java.soundsystem.MediaPlayer;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    @Autowired
    private CompactDisc cd;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private MediaPlayer mediaPlayer;

    @Test
    public void cdShouldNotBeNull() {
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        assertNotNull(cd);
    }

    @Test
    public void play() {
        mediaPlayer.play();
        assertEquals("Playing: Sgt. Pepper's Lonely Hearts Club Band by: The Beatles", systemOutRule.getLog());
    }
}
