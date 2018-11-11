package com.bike.rusty.newtonian.strategy.units.intern.initial;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import games.newtonian.AI;
import games.newtonian.Machine;
import games.newtonian.Unit;

import java.util.List;
import java.util.logging.Logger;

public class MineTheRedOre implements State<GameData> {
    private static Logger LOGGER = Logger.getLogger(MineTheRedOre.class.getName());
    private final Intern intern;

    public MineTheRedOre(Intern intern) {
        this.intern = intern;

        LOGGER.setLevel(AI.LOG_LEVEL);
    }

    @Override
    public String getName() {
        return "Heading To Red Ore State";
    }

    @Override
    public State<GameData> update(GameData data) {
        Unit unit = intern.getUnit();
        if(unit.rediumOre < unit.job.carryLimit) {
            unit.pickup(unit.tile, 1, "redium ore");
        } else {

            List<Machine> machines = data.getMachines();
            int randomIdx= (int) ((Math.random() * 10) % machines.size());

            Machine target = machines.get(randomIdx);

            return new HeadingToMachine(intern, target.tile);
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
