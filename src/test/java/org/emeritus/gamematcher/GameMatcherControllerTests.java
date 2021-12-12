package org.emeritus.gamematcher;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class GameMatcherControllerTests {
    @Autowired
    private WebApplicationContext context;

    protected MockMvc mvc;

    @BeforeEach
    public void setup() {
        this.mvc = MockMvcBuilders
            .webAppContextSetup(this.context)
            .build();
    }
    
    @Test
    public void ConstructorTest() {
        GameMatcherController gmc = new GameMatcherController();
        assertNotNull(gmc);
    }

    @Test
    public void requestMatchOnePlayerTest() {
        // newing up a controller with only one player, so returned game will have no second player.
        GameMatcherController gmc = new GameMatcherController();
        UUID player = UUID.randomUUID();
        Game game = gmc.requestMatch(player.toString());
        assertNull(game.getPlayer2());
    }

    @Test
    public void requestMatchTwoPlayerTest() {
        // newing up a controller with only one player, so returned game will have no second player.
        GameMatcherController gmc = new GameMatcherController();
        UUID player1 = UUID.randomUUID();
        UUID player2 = UUID.randomUUID();
        gmc.requestMatch(player1.toString());
        Game game = gmc.requestMatch(player2.toString());
        assertEquals(player2, game.getPlayer2());
    }

    @Test
    public void requestMatchOnePlayerAPITest() throws Exception{
        mvc.perform(MockMvcRequestBuilders
            .get("/api/game/fd16249a-9bc5-4bd6-9745-87d93418e010"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.player1").value("fd16249a-9bc5-4bd6-9745-87d93418e010"));
    }

    // @Test
    // public void deleteRequestOnePlayerAPITest() throws Exception{
    //     mvc.perform(MockMvcRequestBuilders
    //         .get("/api/game/fd16249a-9bc5-4bd6-9745-87d93418e010"));
    //     mvc.perform(MockMvcRequestBuilders
    //         .post("/api/delete/fd16249a-9bc5-4bd6-9745-87d93418e010"))
    //         .andExpect(MockMvcResultMatchers.status().isOk());
    // }

    @Test
    public void deleteRequestTwoPlayerAPITest() throws Exception{
        mvc.perform(MockMvcRequestBuilders
            .get("/api/game/fd16249a-9bc5-4bd6-9745-87d93418e010"));
        mvc.perform(MockMvcRequestBuilders
            .get("/api/game/fd16249a-9bc5-4bd6-9745-87d93418e011"));
        mvc.perform(MockMvcRequestBuilders
            .post("/api/delete/fd16249a-9bc5-4bd6-9745-87d93418e010"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    public void deleteRequestOnePlayerNotFoundAPITest() throws Exception{
        mvc.perform(MockMvcRequestBuilders
            .post("/api/delete/fd16249a-9bc5-4bd6-9745-87d93418e010"))
            .andExpect(MockMvcResultMatchers.status().isNotFound());
    }
}
