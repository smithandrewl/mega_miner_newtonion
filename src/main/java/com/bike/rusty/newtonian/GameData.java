package com.bike.rusty.newtonian;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.strategy.units.intern.initial.InitialInternState;
import com.bike.rusty.newtonian.units.Intern;
import com.bike.rusty.newtonian.units.Manager;
import com.bike.rusty.newtonian.units.Physicist;
import games.newtonian.*;

import java.util.*;
import java.util.logging.Logger;

public class GameData {

    private final Game game;
    private final Player player;
    private final List<Unit> units;

    private HashSet<String> idsOfLoadedUnits;

    public List<Machine> getMachines() {
        return game.machines;
    }

    public List<Machine> getReadyBlueMachines() {
        List<Machine> readyBlueMachines = new ArrayList<>();

        for(Machine machine : game.machines) {
            if(machine.tile.blueiumOre >= machine.refineInput) {
                readyBlueMachines.add(machine);
            }
        }


        return readyBlueMachines;
    }

    public List<Tile> getBlueOre() {
        List<Tile> tilesWithBlueOre = new ArrayList<>();

        for(Tile tile : game.tiles) {
            if(tile.blueiumOre > 0) {
                tilesWithBlueOre.add(tile);
            }
        }

        return tilesWithBlueOre;
    }

    public List<Tile> getRedOre() {
        List<Tile> tilesWithRedOre = new ArrayList<>();
        for(Tile tile : game.tiles) {
            if(tile.rediumOre > 0) {
                tilesWithRedOre.add(tile);
            }
        }

        return tilesWithRedOre;
    }

    public HashMap<String, Intern> getInterns() {
        return interns;
    }

    public HashMap<String, Physicist> getPhysicists() {
        return physicists;
    }

    public HashMap<String, Manager> getManagers() {
        return managers;
    }

    private HashMap<String, Intern>    interns;
    private HashMap<String, Physicist> physicists;
    private HashMap<String, Manager>   managers;

    private static Logger LOGGER = Logger.getLogger(GameData.class.getName());

    public GameData(Game game, Player player) {
        this.game = game;
        this.player = player;
        this.units = player.units;

        this.idsOfLoadedUnits = new HashSet<>();

        LOGGER.setLevel(AI.LOG_LEVEL);

        interns = new HashMap<>();
        physicists = new HashMap<>();
        managers = new HashMap<>();
    }

    public void update() {
        LOGGER.info("Updating game data");

        LOGGER.info("Processing units");
        for(Unit unit : player.units) {
            LOGGER.info(String.format("Processing unit %s", unit.id));

            if(!this.idsOfLoadedUnits.contains(unit.id)) {


                // Only keep intern, physicist and manager information in memory.
                if(unit.job.title.equals("intern") || unit.job.title.equals("physicist") || unit.job.title.equals("manager")) {
                    LOGGER.info(String.format("Unit %s is a worker, but is not in memory yet", unit.id));

                    LOGGER.info(String.format("Adding unit %s to the list of loaded units", unit.id));

                    idsOfLoadedUnits.add(unit.id);

                    switch (unit.job.title) {
                        case "intern":
                            LOGGER.info(String.format("Unit %s is an intern", unit.id));

                            StateMachine<GameData> stateMachine = new StateMachine<>();
                            Intern intern = new Intern(unit);

                            State<GameData> initialState = new InitialInternState(intern);

                            stateMachine.setInitialState(initialState);
                            initialState.setStateMachine(stateMachine);
                            intern.setStrategy(stateMachine);

                            LOGGER.info(String.format("Adding intern %s to the collection of interns", unit.id));
                            interns.put(unit.id, intern);
                            break;
                        case "physicist":

                            break;
                        case "manager":
                            break;
                    }
                }
            }
        }

        Set<String> activeUnitIds = new HashSet<>();
        for(Unit unit : player.units) {
            activeUnitIds.add(unit.id);
        }

        // Remove any dead units from memory
        for(String id : idsOfLoadedUnits) {
            // If a loaded unit is no longer alive,
            // Remove them from memory.
            if(!activeUnitIds.contains(id)) {
                if(interns.containsKey(id))    { interns.remove(id); }
                if(physicists.containsKey(id)) {physicists.remove(id);}
                if(managers.containsKey(id))   { managers.remove(id);}

                idsOfLoadedUnits.remove(id);
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
