package com.bike.rusty.newtonian.strategy.units.intern.initial;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import games.newtonian.AI;
import games.newtonian.Tile;
import games.newtonian.Unit;

import java.util.List;

public class HeadingToMachine implements State<GameData> {
    private final Intern intern;
    private final Tile target;
    private final List<Tile> targetPath;

    public HeadingToMachine(Intern intern, Tile tile) {
        this.intern = intern;
        this.target = tile;

        this.targetPath = AI.findPath(intern.getUnit().tile, target);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public State<GameData> update(GameData data) {
        Unit unit = intern.getUnit();

        while(unit.moves > 0) {
            if(targetPath.isEmpty()) {
                // Reached the machine
                unit.drop(target, 1,"redium ore");
                if(unit.rediumOre == 0) {
                    break;
                }
            } else {
                unit.move(targetPath.get(0));
                targetPath.remove(0);
            }
        }
        return null;
    }

    @Override
    public void entering(GameData data) {

    }

    @Override
    public void exiting(GameData data) {

    }

    @Override
    public void setStateMachine(StateMachine<GameData> stateMachine) {

    }
}
