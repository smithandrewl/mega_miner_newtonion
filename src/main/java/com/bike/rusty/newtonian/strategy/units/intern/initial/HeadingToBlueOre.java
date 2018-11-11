package com.bike.rusty.newtonian.strategy.units.intern.initial;

import com.bike.rusty.ai.State;
import com.bike.rusty.ai.StateMachine;
import com.bike.rusty.newtonian.GameData;
import com.bike.rusty.newtonian.units.Intern;
import games.newtonian.AI;
import games.newtonian.Tile;

import java.util.List;
import java.util.logging.Logger;

public class HeadingToBlueOre implements State<GameData> {
    private final Tile targetTile;
    private final Intern intern;
    private final List<Tile> pathToTile;
    private StateMachine<GameData> stateMachine;
    private static Logger LOGGER = Logger.getLogger(HeadingToBlueOre.class.getName());

    public HeadingToBlueOre(Intern intern, Tile target) {
        this.intern = intern;
        this.targetTile = target;
        Tile internTile = this.intern.getUnit().tile;
        this.pathToTile = AI.findPath(internTile, this.targetTile);

        if(pathToTile.isEmpty()) {
            LOGGER.severe(String.format("Could not find a path for intern from (%s, %s) to (%s, %s)", internTile.x, internTile.y, targetTile.x, targetTile.y ));
        }
        for(Tile tile : pathToTile) {
            System.out.print(String.format("(%s, %s) -> ", tile.x, tile.y));
        }
    }

    @Override
    public String getName() {
        return "Heading To Blue Ore State";
    }

    @Override
    public State<GameData> update(GameData data) {
        while(intern.getUnit().moves > 0) {
            if(pathToTile.isEmpty()) {
                LOGGER.info("We have arrived at the tile which had blue ore.");
                break;
                // we are at the location.
            } else {

                Tile nextTile = pathToTile.get(0);

                LOGGER.info("We are still not at the blue ore tile.");
                LOGGER.info(String.format("Moving to (%s, %s)", nextTile.x, nextTile.y));
                this.intern.getUnit().move(nextTile);
                pathToTile.remove(0);
            }
        }

        return null;
    }

    @Override
    public void entering(GameData data) {
        LOGGER.info(String.format("Intern %s Entering Heading To Blue Ore State", intern.getId()));

    }

    @Override
    public void exiting(GameData data) {
        LOGGER.info(String.format("Intern %s Exiting Heading To Blue Ore State"));
    }

    @Override
    public void setStateMachine(StateMachine<GameData> stateMachine) {
        this.stateMachine = stateMachine;
    }
}
