package org.emeritus.gamematcher;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

/* This class holds the Guids of the two players and the gameID
 * It is the basic data structure for managing the matching process.
 */
public class Game {
    public Game() {}

    @Getter @Setter private UUID player1;

    @Getter @Setter private UUID player2;

    @Getter @Setter private UUID gameId;
}
