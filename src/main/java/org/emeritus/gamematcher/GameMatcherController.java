package org.emeritus.gamematcher;

import java.util.ArrayList;

import lombok.Getter;

//This class is the controller for the service.  
//Its root URL mapping should be "/api"
public class GameMatcherController {
    //This holds the URL of the GameManager Service
    //Try to use external configuration to load this value from applicaiton properties.
    private String gameManagerUri;
    
    //This ArrayList holds list of queuing players.
    @Getter private final ArrayList<Game> pq = new ArrayList<Game>();
    
    /* requestMatch will map to /game/{player}
     * player will be a guid.
     * it will return a game object that includes the two players and the guid of the game.
     * if player 2 hasn't matched yet,it'll return null for player 2 and the gameID
     * once player 2 matches then all three fields in Game will be populated with guids.
     * Once player 2 is matched this endpoint should register the game with the GameManager Service.
     * You can see behavior of this endpoint at https://checker-game-matcher-prod.herokuapp.com/api/game/{player_guid}
     */
    public Game requestMatch(String playerString) {
        //properly annotate this method and add code here to match the behavior shown at the URL above.
        return new Game();
    }

    /* deleteRequest will map to /delete/{player}
     * player will be a guid.
     * This will post a call to remove a pending match request.
     * it will return a string of either "Deleted" or "Not Found" depending on if it successfully deleted the request.
     * Status of 200 will return if the request is deleted, 404 will return otherwise.
     * Your should return the response string in a ResponseEntity Object.
     * You can see behavior of this endpoint at https://checker-game-matcher.herokuapp.com/api/delete/{player_guid}
     */
    public String deleteRequest(String playerString) {
        //properly annotate this method and add code here to match the behavior shown at the URL above.
        return "";
    }
}
