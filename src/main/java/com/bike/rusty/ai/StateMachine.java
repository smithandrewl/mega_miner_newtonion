package com.bike.rusty.ai;

import com.bike.rusty.ai.State;
import com.bike.rusty.newtonian.GameData;

import java.util.ArrayList;
import java.util.List;

public class StateMachine<T> {
    private List<State> states       = new ArrayList<State>();
    private State<T>    initialState = null;
    private State<T>    currentState = null;
    private boolean started = false;

    public StateMachine() {
        this(null);
    }

    public void setInitialState(State<T> initialState) {
        this.initialState = initialState;
        this.currentState = currentState;
    }
    public StateMachine(State<T> initialState) {
        this.initialState = initialState;
        this.currentState = initialState;

    }

    public void switchState(State<T> state, T data) {
        this.currentState.exiting(data);
        state.entering(data);
        this.currentState = state;
    }

    public void update(T data) {
        if(!started) {
            this.currentState.entering(data);
            started = true;
        }

        State<T> newState = this.currentState.update(data);

        if(newState != null) {
            this.currentState.exiting(data);
            newState.entering(data);
            this.currentState = newState;
        }

    }
}
