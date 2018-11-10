package com.bike.rusty.newtonian.units;

import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import games.newtonian.AI;
import games.newtonian.Unit;

import java.util.logging.Logger;

public class Physicist {
    private static Logger LOGGER = Logger.getLogger(AI.class.getName());

    public Physicist(StateMachine<GameData> strategy, Unit unit) {
        this.strategy = strategy;
        this.unit = unit;

        LOGGER.setLevel(AI.LOG_LEVEL);
    }

    private Unit unit;

    public Unit getUnit() {
        return this.unit;
    }

    public void update(GameData gameData) {
        LOGGER.info(String.format("Updating Physicist ", unit.id));
        this.strategy.update(gameData);
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    private StateMachine<GameData> strategy;

    public StateMachine<GameData> getStrategy() {
        return strategy;
    }

    public String getId() {
        return unit.id;
    }

    public void setStrategy(StateMachine<GameData> strategy) {
        this.strategy = strategy;
    }


}
