package com.bike.rusty.newtonian.strategy.units.intern.initial;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import games.newtonian.AI;
import games.newtonian.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class InitialInternState implements State<GameData> {
    private StateMachine<GameData> stateMachine;
    private final Intern                 intern;


    private static Logger LOGGER = Logger.getLogger(InitialInternState.class.getName());

    public InitialInternState(Intern intern) {
        this.intern       = intern;

        LOGGER.setLevel(AI.LOG_LEVEL);
    }

    public void setStateMachine(StateMachine<GameData> stateMachine) {
        this.stateMachine = stateMachine;
    }
    @Override
    public String getName() {
        return "Intern Initial Strategy.";
    }

    @Override
    public State<GameData> update(GameData data) {
        LOGGER.info(String.format("Updating Initial Intern State for intern %s", intern.getId()));

        List<Tile> tilesWithRedOre  = data.getRedOre();
        List<Tile> tilesWithBlueOre = data.getBlueOre();

        int startWithRed = (int) (Math.random() * 10 % 2);
        if(startWithRed == 1d) {
            if (tilesWithRedOre.size() > 0) {
                LOGGER.info(String.format("Tiles exist with red ore."));
                int randomDest = (int) ((Math.random() * 20) % tilesWithRedOre.size());
                Tile target = tilesWithRedOre.get(randomDest);
                LOGGER.info(String.format("Selected target tile (%s, %s) which has red ore.", target.x, target.y));

                return new HeadingToRedOre(intern, target);

            } else if (tilesWithBlueOre.size() > 0) {
                LOGGER.info("Tiles exist with blue ore.");
                int randomDest = (int) ((Math.random() * 20) % tilesWithBlueOre.size());

                Tile target = tilesWithBlueOre.get(randomDest);

                LOGGER.info(String.format("Selected target tile (%s, %s) which has blue ore.", target.x, target.y));
                return new HeadingToRedOre(intern, target);
            }
        } else {
            if (tilesWithBlueOre.size() > 0) {
                LOGGER.info("Tiles exist with blue ore.");
                int randomDest = (int) ((Math.random() * 20) % tilesWithBlueOre.size());

                Tile target = tilesWithBlueOre.get(randomDest);

                LOGGER.info(String.format("Selected target tile (%s, %s) which has blue ore.", target.x, target.y));
                return new HeadingToRedOre(intern, target);
            } else if (tilesWithRedOre.size() > 0) {
                LOGGER.info(String.format("Tiles exist with red ore."));
                int randomDest = (int) ((Math.random() * 20) % tilesWithRedOre.size());
                Tile target = tilesWithRedOre.get(randomDest);
                LOGGER.info(String.format("Selected target tile (%s, %s) which has red ore.", target.x, target.y));

                return new HeadingToRedOre(intern, target);
            }
        }

        return null;
    }

    @Override
    public void entering(GameData data) {
        LOGGER.info(String.format("Entering Initial Intern State for intern %s", intern.getId()));
    }

    @Override
    public void exiting(GameData data) {
        LOGGER.info(String.format("Exiting Initial Intern State for intern %s", intern.getId()));

    }
}
