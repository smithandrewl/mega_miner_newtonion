package com.bike.rusty.newtonian.strategy.units.intern.initial;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import games.newtonian.AI;

import java.util.logging.Logger;

public class InitialInternState implements State<GameData> {
    private StateMachine<GameData> stateMachine;
    private final Intern                 intern;


    private static Logger LOGGER = Logger.getLogger(AI.class.getName());

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
