/** 
 * Generated by Creer at 06:57PM on October 26, 2015 UTC, git hash: '1b69e788060071d644dd7b8745dca107577844e1'
 * Can be bribed to change the next Forecast in some way.
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
 * Can be bribed to change the next Forecast in some way.
 */
public class WeatherStation extends Building {

    // <<-- Creer-Merge: fields -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional field(s) here. None of them will be tracked or updated by the server.
    // <<-- /Creer-Merge: fields -->>


    /**
     * Creates a new instance of WeatherStation. Used during game initialization, do not call directly.
     */
    public WeatherStation() {
        super();
    }

    /**
     * Bribe the weathermen to intensity the next Forecast by 1 or -1
     *
     * @param   negative  By default the intensity will be increased by 1, setting this to true decreases the intensity by 1.
     * @return true if the intensity was changed, false otherwise
     */
    public void intensify(boolean negative) {
        JSONObject args = new JSONObject();
        args.put("negative", negative);
        return this.runOnServer("intensify", args);
    }

    /**
     * Bribe the weathermen to change the direction of the next Forecast by rotating it clockwise or counterclockwise.
     *
     * @param   counterclockwise  By default the direction will be rotated clockwise. If you set this to true we will rotate the forecast counterclockwise instead.
     * @return true if the rotation worked, false otherwise.
     */
    public void rotate(boolean counterclockwise) {
        JSONObject args = new JSONObject();
        args.put("counterclockwise", counterclockwise);
        return this.runOnServer("rotate", args);
    }

    // <<-- Creer-Merge: methods -->> - Code you add between this comment and the end comment will be preserved between Creer re-runs.
    // you can add addtional method(s) here.
    // <<-- /Creer-Merge: methods -->>
}
