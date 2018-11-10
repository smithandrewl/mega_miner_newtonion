package com.bike.rusty.newtonian.strategy;

import com.bike.rusty.ai.State;
import com.bike.rusty.newtonian.GameData;

public class InitialGameStrategy implements State<GameData> {

    @Override
    public String getName() {
        return "Initial Game Strategy";
    }

    @Override
    public State<GameData> update(GameData data) {
        return null;
    }

    @Override
    public void entering(GameData data) {
        System.out.println("Game strategy has changed to 'Initial game strategy'");

    }

    @Override
    public void exiting(GameData data) {
        System.out.println("Game strategy is changing.  Initial game strategy is exiting.");
    }
}
