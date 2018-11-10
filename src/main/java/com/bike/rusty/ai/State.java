package com.bike.rusty.ai;

public interface State<T> {

    String getName();
    State<T> update(T data);
    void entering(T data);
    void exiting(T data);
}
