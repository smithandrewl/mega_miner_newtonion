package com.bike.rusty;

import java.util.ArrayList;
import java.util.List;

public class StateMachine<T> {
    private List<State> states       = new ArrayList<State>();
    private State<T>    initialState = null;
    private State<T>    currentState = null;


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
        State<T> newState = this.currentState.update(data);

        if(newState != null) {
            this.currentState.exiting(data);
            newState.entering(data);
            this.currentState = newState;
        }

    }
}
