package com.bike.rusty.newtonian.strategy;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import com.bike.rusty.newtonian.units.Manager;
import com.bike.rusty.newtonian.units.Physicist;
import games.newtonian.AI;

import java.util.logging.Logger;

public class InitialGameStrategy implements State<GameData> {
    private static Logger LOGGER = Logger.getLogger(InitialGameStrategy.class.getName());
    private StateMachine<GameData> stateMachine;

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

        LOGGER.info("Updating every intern");
        for(Intern intern : data.getInterns().values()){
            intern.update(data);
        }

        LOGGER.info("Updating every physicists");
        for(Physicist physicist: data.getPhysicists().values()) {
            physicist.update(data);
        }

        LOGGER.info("Updating every manager");
        for(Manager manager : data.getManagers().values()) {
            manager.update(data);
        }

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

    @Override
    public void setStateMachine(StateMachine<GameData> stateMachine) {
        this.stateMachine = stateMachine;
    }

}
