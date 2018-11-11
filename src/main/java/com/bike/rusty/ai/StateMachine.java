package com.bike.rusty.ai;

public class StateMachine<T> {
    private State<T> initialState = null;
    private State<T> currentState = null;
    private boolean  started = false;

    public StateMachine() {
    }

    public void setInitialState(State<T> initialState) {
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
