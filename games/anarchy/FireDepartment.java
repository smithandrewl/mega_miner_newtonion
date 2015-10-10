/** 
 * Generated by Creer at 03:39AM on October 10, 2015 UTC, git hash: '98604e3773d1933864742cb78acbf6ea0b4ecd7b'
 * Can put out fires completely.
 */
package games.anarchy;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.json.JSONObject;

import joueur.BaseGame;
import joueur.BaseGameObject;
// <<-- Creer-Merge: imports -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
// you can add addtional import(s) here
// <<-- /Creer-Merge: imports -->>
@SuppressWarnings("unused")

/**
 * Can put out fires completely.
 */
public class FireDepartment extends Building {

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of FireDepartment. Used during game initialization, do not call directly.
     */
    public FireDepartment() {
        super();
    }

    /**
     * Bribes this FireDepartment to extinguish the fire in a building.
     *
     * @param   building  The Building you want to extinguish.
     * @return true if the bribe worked, false otherwise
     */
    public void extinguish(Building building) {
        JSONObject args = new JSONObject();
        args.put("building", building);
        return this.runOnServer("extinguish", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}