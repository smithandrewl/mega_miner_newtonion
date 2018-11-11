package com.bike.rusty.newtonian;

import com.bike.rusty.newtonian.units.Intern;
import com.bike.rusty.newtonian.units.Manager;
import com.bike.rusty.newtonian.units.Physicist;
import games.newtonian.Game;
import games.newtonian.Player;
import games.newtonian.Unit;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GameData {

    private final Game game;
    private final Player player;
    private final List<Unit> units;

    private HashSet<String> idsOfLoadedUnits;
    private HashMap<String, Intern>    interns;
    private HashMap<String, Physicist> physicists;
    private HashMap<String, Manager>   managers;

    public GameData(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.units = player.units;

        this.idsOfLoadedUnits = new HashSet<>();
    }

    public void update() {
        for(Unit unit : player.units) {
            if(!this.idsOfLoadedUnits.contains(unit.id)) {
                idsOfLoadedUnits.add(unit.id);

                switch(unit.job.title) {
                    case "intern":

                        break;
                    case "physicist":
                        break;
                    case "manager":
                        break;
                }
            }
        }
    }

    public int getHeat() {
        return player.heat;
    }

    public int getPressure() {
        return player.pressure;

    }

    public boolean isGameOver() {
        return player.lost;
    }



}
