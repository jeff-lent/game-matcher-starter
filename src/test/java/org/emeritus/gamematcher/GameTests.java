package org.emeritus.gamematcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameTests {
    
    @Test
    void constructorTest() {
        Game game = new Game();
        assertNotNull(game);
    }

    @Test
    void gettterSetterTest() {
        Game game = new Game();
        UUID player1 = UUID.randomUUID();
        UUID player2 = UUID.randomUUID();
        game.setPlayer1(player1);
        game.setPlayer2(player2);
        assertEquals(player1, game.getPlayer1());
        assertEquals(player2, game.getPlayer2());
    }
}
