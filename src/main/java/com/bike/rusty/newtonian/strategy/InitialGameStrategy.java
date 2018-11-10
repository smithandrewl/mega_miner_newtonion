package com.bike.rusty.newtonian.strategy;

import com.bike.rusty.ai.State;
import com.bike.rusty.newtonian.GameData;
import games.newtonian.AI;

import java.util.logging.Logger;

public class InitialGameStrategy implements State<GameData> {
    private static Logger LOGGER = Logger.getLogger(AI.class.getName());

    public InitialGameStrategy() {
        LOGGER.setLevel(AI.LOG_LEVEL);
    }
    @Override
    public String getName() {
        return "Initial Game Strategy";
    }

    @Override
    public State<GameData> update(GameData data) {
        LOGGER.info("Initial Game Strategy is updating");
        return null;
    }

    @Override
    public void entering(GameData data) {
        LOGGER.info("Game strategy has changed to 'Initial game strategy'");

    }

    @Override
    public void exiting(GameData data) {
        LOGGER.info( "Game strategy is changing.  Initial game strategy is exiting.");
    }
}
