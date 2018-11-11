package com.bike.rusty.newtonian.units;

import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import games.newtonian.AI;
import games.newtonian.Unit;

import java.util.logging.Logger;

public class Intern {

    private static Logger LOGGER = Logger.getLogger(Intern.class.getName());

    public Intern(Unit unit) {
        this.strategy = strategy;
        this.unit = unit;
        LOGGER.setLevel(AI.LOG_LEVEL);
    }
    private Unit unit;

    public Unit getUnit() {
        return this.unit;
    }

    public void update(GameData gameData) {
        LOGGER.info(String.format("Updating Intern %s", unit.id));
        this.strategy.update(gameData);
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public StateMachine<GameData> strategy;

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
