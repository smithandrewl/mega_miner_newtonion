/** 
 * Generated by Creer at 06:57PM on October 26, 2015 UTC, git hash: '1b69e788060071d644dd7b8745dca107577844e1'
 * Used to keep cities under control and raid Warehouses.
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
 * Used to keep cities under control and raid Warehouses.
 */
public class PoliceDepartment extends Building {

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of PoliceDepartment. Used during game initialization, do not call directly.
     */
    public PoliceDepartment() {
        super();
    }

    /**
     * Bribe the police to raid a Warehouse, dealing damage equal based on the Warehouse's current exposure, and then resetting it to 0.
     *
     * @param   warehouse  The warehouse you want to raid.
     * @return The amount of damage dealt to the warehouse, or -1 if there was an error.
     */
    public void raid(Warehouse warehouse) {
        JSONObject args = new JSONObject();
        args.put("warehouse", warehouse);
        return this.runOnServer("raid", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
