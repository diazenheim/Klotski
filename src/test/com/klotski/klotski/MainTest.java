package com.klotski.klotski;

import com.klotski.klotski.view.QuitAlert;
import org.junit.jupiter.api.Test;

import java.awt.desktop.QuitEvent;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

        @Test
        public void testMain() throws InterruptedException {
            new Main();
            Main.main(null);
        }
}