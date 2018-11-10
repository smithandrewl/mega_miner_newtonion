package com.bike.rusty.newtonian.units;

import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import games.newtonian.Unit;

public class Intern {

    public Intern(StateMachine<GameData> strategy, Unit unit) {
        this.strategy = strategy;
        this.unit = unit;
    }
    private Unit unit;

    public Unit getUnit() {
        return this.unit;
    }

    public void update(GameData gameData) {
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
